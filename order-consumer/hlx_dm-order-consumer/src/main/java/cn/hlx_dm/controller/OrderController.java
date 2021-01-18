package cn.hlx_dm.controller;

import cn.hlx_dm.common.Dto;
import cn.hlx_dm.service.OrderService;
import cn.hlx_dm.vo.CreateOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/createOrder")
    public Dto createOrder(@RequestBody CreateOrderVo orderVo) throws Exception {
        return orderService.createOrder(orderVo);
    }
}
