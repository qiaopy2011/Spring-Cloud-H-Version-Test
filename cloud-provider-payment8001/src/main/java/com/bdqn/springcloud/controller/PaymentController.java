package com.bdqn.springcloud.controller;


import com.bdqn.springcloud.entities.CommonResult;
import com.bdqn.springcloud.entities.Payment;
import com.bdqn.springcloud.enums.ResultEnum;
import com.bdqn.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author qiaopy
 * @date 2020/3/19 09:26
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}") //此注解的作用,从配置文件读取server.port属性赋值给变量
    private String serverPort;

    @Resource //服务发现Discovery,就是读取关于自己的信息
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("********插入结果:" + result);
        if (result > 0) {
            return new CommonResult(ResultEnum.SUCCESS.getCode(), "插入数据库成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(ResultEnum.FAILED.getCode(), "插入数据库失败", null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果:" + payment + ",end");
        if (payment != null) {
            return new CommonResult(ResultEnum.SUCCESS.getCode(), "查询成功,serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(ResultEnum.FAILED.getCode(), "没有对应记录,查询id:" + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("******element:" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    //演示feign超时
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            //暂停几秒钟线程
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
