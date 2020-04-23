package com.bdqn.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qiaopy
 * @date 2020/3/19 16:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

//为什么要加泛型?这个返回类是用于返回json信息,将来既可以用于返回支付信息,也可以返回订单等等信息
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}