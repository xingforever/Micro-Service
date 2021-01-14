package cn.hlx_dm.service;

import cn.hlx_dm.common.EmptyUtils;
import cn.hlx_dm.common.MD5;
import cn.hlx_dm.pojo.DmUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

//Token 管理服务
@RestController
public class RestDmTokenService {
    private String tokenPrefix="token";
    @RequestMapping(value = "/generateToken",method = RequestMethod.POST)
     public String generateToken(@RequestBody DmUser dmUser){
            StringBuilder sb=new StringBuilder();
            sb.append("PC-");
            sb.append("tokenPrefix");
            String info= MD5.getMd5(EmptyUtils.isEmpty(dmUser.getPhone())?dmUser.getWxUserId():dmUser.getPhone(),32);
            sb.append(info);
            sb.append(new SimpleDateFormat("yyMMddHHmmss").format(new Date())+"-");
            sb.append(UUID.randomUUID().toString().substring(0,6));
            return sb.toString();
  }

}
