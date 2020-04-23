package com.bdqn.springcloud.controller;


import com.bdqn.springcloud.entities.CommonResult;
import com.bdqn.springcloud.entities.Payment;
import com.bdqn.springcloud.enums.ResultEnum;
import com.bdqn.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

/**
 * @author qiaopy
 * @date 2020/3/19 09:26
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("********插入结果:" + result);
        if (result > 0) {
            return new CommonResult(ResultEnum.SUCCESS.getCode(), "插入数据库成功,serverPort:"+serverPort, result);
        } else {
            return new CommonResult(ResultEnum.FAILED.getCode(), "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果:" + payment+"哈哈");
        if (payment != null) {
            return new CommonResult(ResultEnum.SUCCESS.getCode(), "查询成功,serverPort:"+serverPort, payment);
        } else {
            return new CommonResult(ResultEnum.FAILED.getCode(), "没有对应记录,查询id:" + id, null);
        }
    }
}
