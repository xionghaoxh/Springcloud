package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.PaymentEntity;

public interface PaymentService {
    //读
    public int create(PaymentEntity entity);
    //写
    public PaymentEntity getPaymentById(long id);
}
