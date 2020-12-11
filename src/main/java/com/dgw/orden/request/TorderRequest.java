package com.dgw.orden.request;
import lombok.Data;

@Data
public class TorderRequest {
    /**
     * 收货人
     */
    private String receiverName;

    /**
     * 收货号码
     */
    private String receiverPhone;

    /**
     * 收货地址
     */
    private String receiverAddress;

    /**
     * 商品id
     */
    private Long productId;
    /**
     * 库存id
     */
    private Integer repertoryId;
    /**
     * 购物车id
     */
    private Integer cartId;

}
