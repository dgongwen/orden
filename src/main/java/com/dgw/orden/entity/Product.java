package com.dgw.orden.entity;
import java.io.Serializable;
import lombok.Data;

@Data
public class Product implements Serializable {
    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品名
     */
    private String productName;

    /**
     * 商品单价
     */
    private Integer productPrice;

    /**
     *
     */
    private Long productNum;

    private static final long serialVersionUID = 1L;
}

