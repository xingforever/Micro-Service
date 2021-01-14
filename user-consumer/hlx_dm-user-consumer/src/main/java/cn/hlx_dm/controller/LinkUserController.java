package cn.hlx_dm.controller;
import cn.hlx_dm.common.Dto;
import cn.hlx_dm.common.DtoUtil;
import cn.hlx_dm.service.DmLinkUserService;
import cn.hlx_dm.service.DmLoginService;
import cn.hlx_dm.vo.DmUserVO;
import cn.hlx_dm.vo.QueryLinkUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LinkUserController {

    @Autowired
    private DmLoginService dmLoginService;
    @Autowired
    private DmLinkUserService dmLinkUserService;

    @RequestMapping(value = "/v/queryLinkUser", method = RequestMethod.POST)
    public Dto queryLinkUserByUserId(HttpServletRequest request) throws Exception {
        String tokenString = request.getHeader("token");
        //根据用户TOKEN获取当前联系人的信息
        DmUserVO dmUserVO = null;
        //  dmLoginService.loadCurrentUserByTokenAsDmUserVo(tokenString);
        //根据当前登陆的用户ID获取常用联系人
        List<QueryLinkUserVo> queryLinkUserVos = dmLinkUserService.findLinkUserByUserId(dmUserVO.getUserId());
        return DtoUtil.returnDataSuccess(queryLinkUserVos);
    }
}