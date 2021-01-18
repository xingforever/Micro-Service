package cn.hlx_dm.service;

import cn.hlx_dm.common.Dto;
import cn.hlx_dm.vo.CreateOrderVo;

public interface OrderService {


    /**
     * 下单接口
     *
     * @param orderVo
     * @return
     * @throws Exception
     */
    public Dto createOrder(CreateOrderVo orderVo) throws Exception;
}
