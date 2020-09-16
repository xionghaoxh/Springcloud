package com.at.guigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.PaymentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
   // private static final String PAYMENT_URL="http://localhost:8001";  //单机版
    private static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE/";//因为支付服务集群了，所以这里要集群服务的名字
     @Autowired
    private RestTemplate restTemplate;
     @GetMapping ("/consumer/payment/create")
     public CommonResult<PaymentEntity> create(PaymentEntity entity)throws Exception{
         return  restTemplate.postForObject(PAYMENT_URL+"payment/create",entity, CommonResult.class);
     }
     @GetMapping("/consumer/payment/get/{id}")
     public CommonResult<PaymentEntity> getPayment(@PathVariable("id") long id) throws Exception{
         return  restTemplate.getForObject(PAYMENT_URL+"payment/get/"+id,CommonResult.class);
     }
}
