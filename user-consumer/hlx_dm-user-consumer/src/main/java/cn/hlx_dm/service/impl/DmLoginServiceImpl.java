package cn.hlx_dm.service.impl;

import cn.hlx_dm.client.RestDmImageClient;
import cn.hlx_dm.client.RestDmUserClient;
import cn.hlx_dm.common.Constants;
import cn.hlx_dm.common.EmptyUtils;
import cn.hlx_dm.common.RedisUtils;
import cn.hlx_dm.pojo.DmImage;
import cn.hlx_dm.pojo.DmUser;
import cn.hlx_dm.service.DmLoginService;
import cn.hlx_dm.vo.DmUserVO;
import cn.hlx_dm.vo.TokenVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;

@Component
public class DmLoginServiceImpl implements DmLoginService {
    @Autowired
    private RestDmUserClient restDmUserClient;
    @Autowired
    private RestDmImageClient restDmImageClient;
   @Autowired
   private RedisUtils redisUtils;

    @Override
    public Object[] login(DmUser user) throws Exception {
        //验证用户登录是否成功
        DmUser dmUser=  restDmUserClient.checkLoginByPassWord(user);
        if(EmptyUtils.isEmpty(dmUser)){
            return null;
        }
        //组装信息
        DmUserVO dmUserVO =new DmUserVO();
        BeanUtils.copyProperties(dmUser,dmUserVO);
        dmUserVO.setUserId(dmUser.getId());
         //更新用户头像
       List<DmImage> dmImageList= restDmImageClient.queryDmImageList(
                dmUser.getId(),
                Constants.Image.ImageType.normal,
                Constants.Image.ImageCategory.user);
       if (EmptyUtils.isNotEmpty(dmImageList)){
           dmUserVO.setImageId((dmImageList.get(0).getId()));
           dmUserVO.setImgUrl((dmImageList.get(0).getImgUrl()));

       }
       //生成Token
      String token= this.generateToken(dmUser);
       //保存Token到redis
      this.saveToken(token,dmUserVO);
      TokenVO tokenVO=new TokenVO(token,Constants.Redis_Expire.SESSION_TIMEOUT,new Date().getTime());

        return new Object[]{dmUserVO,tokenVO};
    }
    @Override
    public DmUserVO loadCurrentUserByTokenAsDmUserVo(String tokenString) throws Exception {
        String tokenUser = null;
        if ((tokenUser = (String) redisUtils.get(tokenString)) == null) {
            //抛出异常
            return null;
        }
        return JSONObject.parseObject(tokenUser, DmUserVO.class);
    }


    @Override
    public String generateToken(DmUser dmUser) throws Exception {
         return  restDmUserClient.generateToken(dmUser);
    }

    @Override
    public void saveToken(String token, DmUserVO dmUserVO) {
        String tokenKey=Constants.USER_TOKEN_PREFIX+dmUserVO.getUserId();
        String tokenValue=null;
       // 检查是否已经登录，如果还在登录有效期内 就需要删除掉原来的登录信息
        if ((tokenValue=(String) redisUtils.get(tokenKey))!=null){
            //代表用户已经登录。
            redisUtils.delete(tokenKey);
        }
        //缓存用户token
        redisUtils.set(tokenKey,Constants.Redis_Expire.SESSION_TIMEOUT,token);
        //缓存用户详细信息
        redisUtils.set(token,Constants.Redis_Expire.SESSION_TIMEOUT, JSON.toJSONString(dmUserVO));



    }
}
