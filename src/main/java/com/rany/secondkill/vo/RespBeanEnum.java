package com.rany.secondkill.vo;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {

    SUCCESS(200, "成功"),
    ERROR(500, "--服务端异常--"),

    DOSECKILL_ERROR(500001, "doSecKill 服务端异常"),

    // 登录模块
    LOGIN_ERROR(500210, "用户名或密码格式不正确"),
    MOBILE_ERROR(500211, "手机号码格式不正确"),
    NOUSER_ERROR(500230, "用户不存在"),
    BIND_ERROR(500212, "参数校验异常"),

    EMPTY_STOCK(500500, "库存不足"),
    REPEATE_ERROR(500505, "重复秒杀"),

    ORDER_NOT_EXIST(500510, "订单号不存在"),

    MOBILE_NOT_EXIST(500213, "手机号码不存在"),
    PASSWORD_UPDATE_FAILED(500214, "密码更新失败"),
    ;

    private final Integer code;
    private final String message;
}
