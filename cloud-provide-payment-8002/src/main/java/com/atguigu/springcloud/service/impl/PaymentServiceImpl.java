package com.atguigu.springcloud.service.impl;


import com.atguigu.springcloud.entities.PaymentEntity;
import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
   private PaymentDao paymentDao;
    @Override
    public int create(PaymentEntity entity) {
        return paymentDao.create(entity);
    }
    @Override
    public PaymentEntity getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }
}
