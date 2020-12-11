package com.dgw.orden.mapper;
import com.dgw.orden.entity.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {

    //查询商品单价
    Product selectProduct(@Param("productId") Long productId);
}
