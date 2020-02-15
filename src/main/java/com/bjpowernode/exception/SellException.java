package com.bjpowernode.exception;

import com.bjpowernode.enums.ResultEnum;

/**
 * @ClassName SellException
 * @Description: TODO
 * @Author codemi@aliyun.com
 * @Date 2020/1/8
 **/
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
