package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.PaymentEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentOpenFeignService {
    @GetMapping("/payment/get/{id}")
    CommonResult<PaymentEntity> getPaymentById(@PathVariable("id") long id);
}
