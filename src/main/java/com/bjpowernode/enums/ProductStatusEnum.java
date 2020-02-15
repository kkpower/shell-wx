package com.bjpowernode.enums;

import lombok.Getter;

/**
 * @ClassName ProductStatusEnum
 * @Description: TODO
 * @Author codemi@aliyun.com
 * @Date 2020/1/5
 **/

@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
