package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private String message;
    private Integer code;
    private T data;
    public   CommonResult( Integer code,String message){
        this(code,message,null);
    }

    public CommonResult(Integer code, String message, T data) {
        this.code=code;
        this.data=data;
        this.message=message;
    }
}
