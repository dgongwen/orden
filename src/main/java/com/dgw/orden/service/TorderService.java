package com.dgw.orden.service;
import com.dgw.orden.request.TorderRequest;
import com.dgw.orden.vo.TorderVo;
import java.util.List;

public interface TorderService {

    //创建订单
    int creatOrder(TorderRequest order);

    //查询订单信息
    List<TorderVo> selectById(long torderId);
}
