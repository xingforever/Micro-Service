package cn.hlx_dm.service;

import cn.hlx_dm.pojo.DmUser;
import cn.hlx_dm.vo.DmUserVO;

//账户密码登录
public interface DmLoginService {
    public Object[] login(DmUser dmUser) throws  Exception;


    public String generateToken(DmUser dmUser) throws Exception;

    public DmUserVO loadCurrentUserByTokenAsDmUserVo(String tokenString) throws Exception;

    public void saveToken(String token, DmUserVO dmUserVO);
}
