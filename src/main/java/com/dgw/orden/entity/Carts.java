package com.dgw.orden.entity;
import java.io.Serializable;
import lombok.Data;

@Data
public class Carts implements Serializable {
    /**
     * 购物车id
     */
    private Integer cartId;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 商品数量
     */
    private Integer productNum;

    /**
     * 商品单价
     */
    private Integer productPrice;

    private Integer status;

    private static final long serialVersionUID = 1L;
}

