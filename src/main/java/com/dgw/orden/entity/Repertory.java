package com.dgw.orden.entity;
import java.io.Serializable;
import lombok.Data;

@Data
public class Repertory implements Serializable {
    /**
     * 库存id
     */
    private Integer repertoryId;

    /**
     * 库存总量
     */
    private Long repertoryCount;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 库存状态
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}

