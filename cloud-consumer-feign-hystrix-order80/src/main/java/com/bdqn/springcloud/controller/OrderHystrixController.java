package com.bdqn.springcloud.controller;

import com.bdqn.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qiaopy
 * @date 2020/4/27 17:05
 */

@RestController
@Slf4j
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String PaymentInfo_OK(@PathVariable("id")  Integer id){
        String result = paymentHystrixService.PaymentInfo_OK(id);
        return result;

    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String PaymentInfo_TimeOut(@PathVariable("id")  Integer id){
        String result = paymentHystrixService.PaymentInfo_TimeOut(id);
        return result;
    }

}
