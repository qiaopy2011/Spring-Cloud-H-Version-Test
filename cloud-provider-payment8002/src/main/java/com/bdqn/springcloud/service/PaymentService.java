package com.bdqn.springcloud.service;

import com.bdqn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;


/**
 * @author qiaopy
 * @date 2020/3/19 09:09
 */

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
