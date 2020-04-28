package com.bdqn.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author qiaopy
 * @date 2020/4/27 14:57
 */

@Service
public class PaymentService {

    /**
     * 正常访问,一定ok
     * @param id
     * @return
     */
    public String PaymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " ,PaymentInfo_OK   id:" + id + "^_^";
    }


    //HystrixCommand注解,如果被注解的方法发生超时或异常,其中的fallbackMethod指定哪个方法作为此方法的兜底(fallback)
    //HystrixProperty注解中的name指定哪一个线程的超时时间是几秒
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String PaymentInfo_TimeOut(Integer id){
        int timeNumber = 5;
     //   int num = 10/0; // 测试报错用
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " ,PaymentInfo_TimeOut   id:" + id + "耗时" + timeNumber;

    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "o(╥﹏╥)o 调用支付接口超时或异常:\t,当前线程名称:"+Thread.currentThread().getName()+" [系统忙,稍后再试] id:"+id;
    //return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOutHandler,id:"+id;
    }
}
