package cn.hlx_dm.service;

import cn.hlx_dm.vo.HotItemVo;

import java.util.List;

public interface HomeService {
    /**
     * 查询首页轮播图
     * @return
     * @throws Exception
     */
    public List<HotItemVo> queryBanner() throws  Exception;
}
