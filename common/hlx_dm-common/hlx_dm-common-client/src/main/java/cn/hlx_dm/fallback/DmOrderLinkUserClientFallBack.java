package cn.hlx_dm.fallback;

import cn.hlx_dm.pojo.DmOrderLinkUser;

import cn.hlx_dm.client.RestDmOrderLinkUserClient;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
@Component
public class DmOrderLinkUserClientFallBack implements RestDmOrderLinkUserClient {


    @Override
    public DmOrderLinkUser getDmOrderLinkUserById(Long id)throws Exception{
        return null;
    }

    @Override
    public List<DmOrderLinkUser>	getDmOrderLinkUserListByMap(Map<String,Object> param)throws Exception{
        return null;
    }

    @Override
    public Integer getDmOrderLinkUserCountByMap(Map<String,Object> param)throws Exception{
        return null;
    }

    @Override
    public Integer qdtxAddDmOrderLinkUser(DmOrderLinkUser dmOrderLinkUser)throws Exception{
        return null;
    }

    @Override
    public Integer qdtxModifyDmOrderLinkUser(DmOrderLinkUser dmOrderLinkUser)throws Exception{
        return null;
    }
}
