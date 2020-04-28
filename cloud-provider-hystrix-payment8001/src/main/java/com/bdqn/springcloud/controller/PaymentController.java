package com.bdqn.springcloud.controller;

import com.bdqn.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qiaopy
 * @date 2020/4/27 15:07
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String PaymentInfo_OK(@PathVariable("id")  Integer id){
        String result = paymentService.PaymentInfo_OK(id);
        log.info("result*********"+result);
        return  result;
    }
    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String PaymentInfo_TimeOut(@PathVariable("id")  Integer id){
        String result = paymentService.PaymentInfo_TimeOut(id);
        log.info("result*********"+result);
        return  result;
    }

}
