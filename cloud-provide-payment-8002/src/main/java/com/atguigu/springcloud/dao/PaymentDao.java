package com.atguigu.springcloud.dao;


import com.atguigu.springcloud.entities.PaymentEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentDao {
    //读
    public int create(PaymentEntity entity);
    //写
    public PaymentEntity getPaymentById(@Param("id") long id);
}
