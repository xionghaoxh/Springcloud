package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystirxService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentHystirxService service;
    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="10000")
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = service.paymentInfo_TimeOut(id);
        log.info("*******result:"+result);
        return result;
    }
    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id){
        return "id:"+id+"需要降级处理";
    }
}
