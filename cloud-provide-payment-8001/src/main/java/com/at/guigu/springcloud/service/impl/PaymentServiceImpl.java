package com.at.guigu.springcloud.service.impl;

import com.at.guigu.springcloud.dao.PaymentDao;
import com.at.guigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.entities.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
   private  PaymentDao paymentDao;
    @Override
    public int create(PaymentEntity entity) {
        return paymentDao.create(entity);
    }

    @Override
    public PaymentEntity getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }
}
