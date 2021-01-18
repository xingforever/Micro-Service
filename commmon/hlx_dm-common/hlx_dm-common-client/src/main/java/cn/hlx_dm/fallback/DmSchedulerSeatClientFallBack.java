package cn.hlx_dm.fallback;

import cn.hlx_dm.pojo.DmScheduler;
import cn.hlx_dm.pojo.DmSchedulerSeat;

import cn.hlx_dm.client.RestDmSchedulerSeatClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
@Component
public class DmSchedulerSeatClientFallBack implements RestDmSchedulerSeatClient {


    @Override
    public DmSchedulerSeat getDmSchedulerSeatById(Long id)throws Exception{
        return null;
    }

    @Override
    public List<DmSchedulerSeat>	getDmSchedulerSeatListByMap(Map<String,Object> param)throws Exception{
        return null;
    }

    @Override
    public Integer getDmSchedulerSeatCountByMap(Map<String,Object> param)throws Exception{
        return null;
    }

    @Override
    public Integer qdtxAddDmSchedulerSeat(DmSchedulerSeat dmSchedulerSeat)throws Exception{
        return null;
    }

    @Override
    public Integer qdtxModifyDmSchedulerSeat(DmSchedulerSeat dmSchedulerSeat)throws Exception{
        return null;
    }


    @RequestMapping(value = "/getDmSchedulerSeatByOrder",method = RequestMethod.POST)
    public DmSchedulerSeat getDmSchedulerSeatByOrder(@RequestParam long scheduleId, @RequestParam Integer x, @RequestParam Integer y)throws Exception{
        return null;
    }

}
