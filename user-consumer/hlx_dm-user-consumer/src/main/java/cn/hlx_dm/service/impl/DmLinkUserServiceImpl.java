package cn.hlx_dm.service.impl;

import cn.hlx_dm.client.RestDmLinkUserClient;
import cn.hlx_dm.pojo.DmLinkUser;
import cn.hlx_dm.service.DmLinkUserService;
import cn.hlx_dm.vo.QueryLinkUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DmLinkUserServiceImpl implements DmLinkUserService {

    @Autowired
    private RestDmLinkUserClient restDmLinkUserClient;

    @Override
    public List<QueryLinkUserVo> findLinkUserByUserId(Long userId) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        List<DmLinkUser> dmLinkUsers = restDmLinkUserClient.getDmLinkUserListByMap(params);
        List<QueryLinkUserVo> queryLinkUserVos = new ArrayList<>();
        if (dmLinkUsers.size() > 0) {
            //组装数据
            for (DmLinkUser dmLinkUser : dmLinkUsers) {
                QueryLinkUserVo queryLinkUserVo = new QueryLinkUserVo();
                BeanUtils.copyProperties(dmLinkUser, queryLinkUserVo);
                queryLinkUserVos.add(queryLinkUserVo);
            }
            return queryLinkUserVos;
        }
        return null;
    }
}