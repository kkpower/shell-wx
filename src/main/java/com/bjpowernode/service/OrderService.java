package com.bjpowernode.service;

import com.bjpowernode.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @ClassName OrderService
 * @Description: TODO
 * @Author 876666981@qq.com
 * @Date 2020/1/8
 **/
public interface OrderService {

    /**
     * 创建订单
     */
    OrderDto create(OrderDto orderDto);

    /**
     * 查询单个订单
     */
    OrderDto findOne(String orderId);

    /**
     * 查询订单列表
     */
    Page<OrderDto> findList(String buyerOpenid, Pageable pageable);

    /**
     * 取消订单
     */
    OrderDto cancel(OrderDto orderDto);

    /**
     * 完结订单
     */
    OrderDto finsish(OrderDto orderDto);

    /**
     * 支付订单
     */
    OrderDto paid(OrderDto orderDto);
}
