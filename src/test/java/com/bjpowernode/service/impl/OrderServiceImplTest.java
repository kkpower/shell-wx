package com.bjpowernode.service.impl;

import com.bjpowernode.dataobject.OrderDetail;
import com.bjpowernode.dto.OrderDto;
import com.bjpowernode.enums.OrderStatusEnum;
import com.bjpowernode.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";

    @Test
    public void create() {

        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName("张三");
        orderDto.setBuyerAddress("大族企业湾");
        orderDto.setBuyerPhone("12345678912");
        orderDto.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123457");
        o1.setProductQuantity(10);
        orderDetailList.add(o1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123456");
        o2.setProductQuantity(2);
        orderDetailList.add(o2);

        orderDto.setOrderDetailList(orderDetailList);

        OrderDto result = orderService.create(orderDto);
        log.info("【创建订单】result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDto result = orderService.findOne("1578493738461807564");
        log.info("【查询单个订单】result={}",result);
        Assert.assertEquals("1578493738461807564",result.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDto> orderDtoPage = orderService.findList(BUYER_OPENID,request);
        Assert.assertNotEquals(0,orderDtoPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDto orderDto = orderService.findOne("1578493738461807564");
        OrderDto result = orderService.cancel(orderDto);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finsish() {
        OrderDto orderDto = orderService.findOne("1578493738461807564");
        OrderDto result = orderService.finsish(orderDto);
        Assert.assertEquals(OrderStatusEnum.FINSHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDto orderDto = orderService.findOne("1578493738461807564");
        OrderDto result = orderService.paid(orderDto);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }
}