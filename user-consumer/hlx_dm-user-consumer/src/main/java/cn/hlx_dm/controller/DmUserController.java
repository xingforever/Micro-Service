package cn.hlx_dm.controller;

import cn.hlx_dm.common.Dto;
import cn.hlx_dm.common.DtoUtil;
import cn.hlx_dm.common.EmptyUtils;
import cn.hlx_dm.common.MD5;
import cn.hlx_dm.pojo.DmUser;
import cn.hlx_dm.service.DmLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api",method = RequestMethod.POST)
public class DmUserController {
    @Autowired
    private DmLoginService  dmLoginService;
    public Dto loginByPassword(@RequestBody DmUser dmUser) throws Exception {
        dmUser.setPassword(MD5.getMd5(dmUser.getPassword(),32));
        Object[] results=dmLoginService.login(dmUser);
        if(EmptyUtils.isEmpty(results))
            return DtoUtil.returnFail("登录失败", "0000");
        else
        {
           return DtoUtil.returnSuccess("登录成功",results);
        }
    }
}
