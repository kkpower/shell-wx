package com.bjpowernode.service;

import com.bjpowernode.dto.OrderDto;

/**
 * @ClassName BuyerService
 * @Description: TODO
 * @Author codemi@aliyun.com
 * @Date 2020/1/10
 **/
public interface BuyerService {

    //查询一个订单
    OrderDto findOrderOne(String openid, String orderid);

    //取消订单
    OrderDto cancelOrder(String openid, String orderid);
}
