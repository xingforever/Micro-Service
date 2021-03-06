package cn.hlx_dm.client;
import cn.hlx_dm.pojo.DmCinemaSeat;

import cn.hlx_dm.fallback.DmCinemaSeatClientFallBack;
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
@FeignClient(name = "hlx_dm-item-provider", configuration = DmConfiguration.class, fallback = DmCinemaSeatClientFallBack.class)
public interface RestDmCinemaSeatClient {

@RequestMapping(value = "/getDmCinemaSeatById",method = RequestMethod.POST)
public DmCinemaSeat getDmCinemaSeatById(@RequestParam("id") Long id)throws Exception;

@RequestMapping(value = "/getDmCinemaSeatListByMap",method = RequestMethod.POST)
public List<DmCinemaSeat>	getDmCinemaSeatListByMap(@RequestParam Map<String,Object> param)throws Exception;

@RequestMapping(value = "/getDmCinemaSeatCountByMap",method = RequestMethod.POST)
public Integer getDmCinemaSeatCountByMap(@RequestParam Map<String,Object> param)throws Exception;

@RequestMapping(value = "/qdtxAddDmCinemaSeat",method = RequestMethod.POST)
public Integer qdtxAddDmCinemaSeat(@RequestBody DmCinemaSeat dmCinemaSeat)throws Exception;

@RequestMapping(value = "/qdtxModifyDmCinemaSeat",method = RequestMethod.POST)
public Integer qdtxModifyDmCinemaSeat(@RequestBody DmCinemaSeat dmCinemaSeat)throws Exception;
}
