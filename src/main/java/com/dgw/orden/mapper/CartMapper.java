package com.dgw.orden.mapper;
import com.dgw.orden.entity.Carts;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CartMapper {

    //查询购物车单价数量
    List<Carts> selectById(@Param("cartId") Integer cartId);
}
