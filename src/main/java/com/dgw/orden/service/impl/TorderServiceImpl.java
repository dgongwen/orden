package com.dgw.orden.service.impl;
import com.dgw.orden.entity.Carts;
import com.dgw.orden.entity.Product;
import com.dgw.orden.entity.Repertory;
import com.dgw.orden.entity.Torder;
import com.dgw.orden.mapper.CartMapper;
import com.dgw.orden.mapper.ProductMapper;
import com.dgw.orden.mapper.RepertoryMapper;
import com.dgw.orden.mapper.TorderMapper;
import com.dgw.orden.request.TorderRequest;
import com.dgw.orden.service.TorderService;
import com.dgw.orden.utils.ColaBeanUtils;
import com.dgw.orden.utils.SnowflakeIdUtils;
import com.dgw.orden.vo.TorderVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TorderServiceImpl implements TorderService {

    @Resource
    CartMapper cartMapper;

    @Resource
    ProductMapper productMapper;

    @Resource
    RepertoryMapper repertoryMapper;

    @Resource
    TorderMapper torderMapper;

    @Override
    public int creatOrder(TorderRequest order) {
        //雪花算法获取id
        String snow = new SnowflakeIdUtils(3, 1).nextId()+"";
        //添加订单
        Torder torder = new Torder();
        torder.setOrdenSn(snow);
        torder.setReceiverPhone(order.getReceiverPhone());
        torder.setReceiverAddress(order.getReceiverAddress());
        torder.setReceiverName(order.getReceiverName());

        //判断库存与单价是否发生改变
        //查购物车单价
        List<Carts> carts = cartMapper.selectById(order.getCartId());
        //查商品单价
        Product products = productMapper.selectProduct(order.getProductId());
        //单价是否发生改变
        if(isPriceChange(carts,products)){
            System.out.println("系统异常,重新下单");
        }

        //查询库存
        Repertory repertory = repertoryMapper.selectNum(order.getRepertoryId());
        //库存是否发生改变
        if(isNumChange(carts,repertory)){
            System.out.println("库存不足,重新下单");
        }

        //计算总金额(单价*数量)
        BigDecimal big = new BigDecimal(0);
        for(Carts car:carts){
            Integer productPrice = car.getProductPrice();
            Integer productNum = car.getProductNum();
            BigDecimal Decimal = new BigDecimal(productNum);
            BigDecimal multiply = Decimal.multiply(new BigDecimal(productPrice));
            big = big.add(multiply);
        }

        //订单添加总金额
        torder.setTotalAmount(big);
        //插入订单数据
        int i = torderMapper.insertOrder(torder);
        return i;
    }

    //查询订单
    @Override
    public List<TorderVo> selectById(long torderId) {
        List<Torder> torders = torderMapper.selectTorder(torderId);
        List<TorderVo> torderVos = ColaBeanUtils.copyListProperties(torders, TorderVo::new);
        return torderVos;
    }


    /**
     *判断库存是否发生改变
     * @param carts
     * @param repertory
     * @return
     */
    private boolean isNumChange(List<Carts> carts, Repertory repertory) {
        for (int i = 0; i < carts.size(); i++) {
            if(repertory.getRepertoryCount()<carts.get(i).getProductNum()){
                return false;
            }
        }

        return true;
    }

    /**
     *判断单价是否发生改变
     *
     * @param carts
     * @param products
     * @return
     */
    private boolean isPriceChange(List<Carts> carts, Product products) {
        for (int i = 0; i <carts.size() ; i++) {
            if(carts.get(i).getProductPrice()!=products.getProductPrice()){
                return false;
            }
        }


        return true;
    }
}
