package com.bdqn.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author qiaopy
 * @date 2020/4/27 17:02
 */

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String PaymentInfo_OK(@PathVariable("id")  Integer id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String PaymentInfo_TimeOut(@PathVariable("id")  Integer id);
}
