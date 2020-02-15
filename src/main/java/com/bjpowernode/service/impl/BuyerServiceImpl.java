package com.bjpowernode.service.impl;

import com.bjpowernode.dto.OrderDto;
import com.bjpowernode.enums.ResultEnum;
import com.bjpowernode.exception.SellException;
import com.bjpowernode.service.BuyerService;
import com.bjpowernode.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName BuyerServiceImpl
 * @Description: TODO
 * @Author codemi@aliyun.com
 * @Date 2020/1/10
 **/
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDto findOrderOne(String openid, String orderid) {
        return checkOrderOwner(openid,orderid);
    }

    @Override
    public OrderDto cancelOrder(String openid, String orderid) {
        OrderDto orderDto = checkOrderOwner(openid, orderid);
        if (orderDto == null){
            log.error("【取消订单】查不到订单，orderid={}",orderid);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDto);
    }

    private OrderDto checkOrderOwner(String openid, String orderid){
        OrderDto orderDto = orderService.findOne(orderid);
        if (orderDto == null){
            return null;
        }
        //判断是否是当前用户订单
        if (!orderDto.getBuyerOpenid().equals(orderid)){
            log.error("【查询订单】订单的openid不一致，openid={}, orderDto={}",openid,orderDto);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDto;
    }
}
