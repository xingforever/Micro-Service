package cn.hlx_dm.client;
import cn.hlx_dm.pojo.DmLinkUser;

import cn.hlx_dm.fallback.DmLinkUserClientFallBack;
import java.util.List;
import java.util.Map;

import cn.hlx_dm.config.DmConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
/**
* Created by shang-pc on 2018/5/15.
*/
@FeignClient(name = "hlx_dm-user-provider", configuration = DmConfiguration.class, fallback = DmLinkUserClientFallBack.class)
public interface RestDmLinkUserClient {
@RequestMapping(value = "/getDmLinkUserById",method = RequestMethod.POST)
public DmLinkUser getDmLinkUserById(@RequestParam("id") Long id)throws Exception;

@RequestMapping(value = "/getDmLinkUserListByMap",method = RequestMethod.POST)
public List<DmLinkUser>	getDmLinkUserListByMap(@RequestParam Map<String,Object> param)throws Exception;

@RequestMapping(value = "/getDmLinkUserCountByMap",method = RequestMethod.POST)
public Integer getDmLinkUserCountByMap(@RequestParam Map<String,Object> param)throws Exception;

@RequestMapping(value = "/qdtxAddDmLinkUser",method = RequestMethod.POST)
public Integer qdtxAddDmLinkUser(@RequestBody DmLinkUser dmLinkUser)throws Exception;

@RequestMapping(value = "/qdtxModifyDmLinkUser",method = RequestMethod.POST)
public Integer qdtxModifyDmLinkUser(@RequestBody DmLinkUser dmLinkUser)throws Exception;
}

