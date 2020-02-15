package com.bjpowernode.converter;

import com.bjpowernode.dataobject.OrderDetail;
import com.bjpowernode.dto.OrderDto;
import com.bjpowernode.enums.ResultEnum;
import com.bjpowernode.exception.SellException;
import com.bjpowernode.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderForm2OrderDtoConverter
 * @Description: TODO
 * @Author codemi@aliyun.com
 * @Date 2020/1/9
 **/

@Slf4j
public class OrderForm2OrderDtoConverter {

    public static OrderDto convert(OrderForm orderForm){

        Gson gson = new Gson();
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType()
            );
        }catch (Exception e){
            log.error("【对象转换】出翁，string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARM_ERROR);
        }

        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }
}
