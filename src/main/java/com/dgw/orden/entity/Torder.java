package com.dgw.orden.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Torder implements Serializable {
    /**
     * 订单id
     */
    private Long ordenId;

    /**
     * 订单编号
     */
    private String ordenSn;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 提交时间
     */
    private Date createTime;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 支付方式
     */
    private Integer payType;

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
     *
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}

