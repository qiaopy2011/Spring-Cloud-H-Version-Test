package com.bdqn.springcloud.service.impl;

import com.bdqn.springcloud.dao.PaymentDao;
import com.bdqn.springcloud.entities.Payment;
import com.bdqn.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qiaopy
 * @date 2020/3/19 09:19
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
