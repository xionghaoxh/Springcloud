package com.at.guigu.springcloud.controller;


import com.at.guigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.PaymentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private  PaymentService service;
  //读取配置文件的port
    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody PaymentEntity entity)throws Exception{
        int i = service.create(entity);
       log.info("插入结果"+i);
        if(i>0){
            return new CommonResult(200,"插入成功+serverPort:"+serverPort,i);
        }else{
            return new CommonResult(444,"插入失败",null);
        }

    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id)throws Exception{
        PaymentEntity entity = service.getPaymentById(id);
        log.info("******查询结果"+entity+"xh");
        if(null!=entity){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,entity);
        }else {
            return new CommonResult(444,"查询失败",null);
        }
    }
}
