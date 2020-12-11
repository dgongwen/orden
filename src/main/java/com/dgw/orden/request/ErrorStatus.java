package com.dgw.orden.request;

import lombok.Getter;


@Getter
public enum ErrorStatus {
    SUCCESS(200, "成功"),
    SYS_ERROR(40001, "系统异常"),
    SERVICE_ERROR(404, "服务异常"),
    //用户相关
    ACCOUNT_EXIST_ERROR(40020, "账号已存在!"),

    //    订单相关的异常
    ORDER_PRODUCT_OUT(40010, "商品已下架,请重新下单"),

    ORDER_PRODUCT_PRICE_CHANGE(40011, "价格发送改变!! 请重新下单");
    private int status;
    private String message;

    ErrorStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
