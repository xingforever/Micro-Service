package cn.hlx_dm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hlx_dm.mapper.DmSchedulerSeatPriceMapper;
import cn.hlx_dm.pojo.DmSchedulerSeatPrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * Created by dm
 */
@RestController
public class RestDmSchedulerSeatPriceService {

     @Autowired
     private DmSchedulerSeatPriceMapper dmSchedulerSeatPriceMapper;

     @RequestMapping(value = "/getDmSchedulerSeatPriceById",method = RequestMethod.POST)
     public DmSchedulerSeatPrice getDmSchedulerSeatPriceById(@RequestParam("id") Long id)throws Exception{
        return dmSchedulerSeatPriceMapper.getDmSchedulerSeatPriceById(id);
     }

     @RequestMapping(value = "/getDmSchedulerSeatPriceListByMap",method = RequestMethod.POST)
     public List<DmSchedulerSeatPrice>	getDmSchedulerSeatPriceListByMap(@RequestParam Map<String,Object> param)throws Exception{
        return dmSchedulerSeatPriceMapper.getDmSchedulerSeatPriceListByMap(param);
     }

     @RequestMapping(value = "/getDmSchedulerSeatPriceCountByMap",method = RequestMethod.POST)
     public Integer getDmSchedulerSeatPriceCountByMap(@RequestParam Map<String,Object> param)throws Exception{
        return dmSchedulerSeatPriceMapper.getDmSchedulerSeatPriceCountByMap(param);
     }

     @RequestMapping(value = "/qdtxAddDmSchedulerSeatPrice",method = RequestMethod.POST)
     public Integer qdtxAddDmSchedulerSeatPrice(@RequestBody DmSchedulerSeatPrice dmSchedulerSeatPrice)throws Exception{
        dmSchedulerSeatPrice.setCreatedTime(new Date());
        return dmSchedulerSeatPriceMapper.insertDmSchedulerSeatPrice(dmSchedulerSeatPrice);
     }

     @RequestMapping(value = "/qdtxModifyDmSchedulerSeatPrice",method = RequestMethod.POST)
     public Integer qdtxModifyDmSchedulerSeatPrice(@RequestBody DmSchedulerSeatPrice dmSchedulerSeatPrice)throws Exception{
        dmSchedulerSeatPrice.setUpdatedTime(new Date());
        return dmSchedulerSeatPriceMapper.updateDmSchedulerSeatPrice(dmSchedulerSeatPrice);
     }
    @RequestMapping(value = "/getDmSchedulerSeatPriceBySchedulerIdAndArea",method = RequestMethod.POST)
    public DmSchedulerSeatPrice getDmSchedulerSeatPriceBySchedulerIdAndArea(@RequestParam("scheduleId") Long scheduleId,
                                                                            @RequestParam("areaLevel") Integer areaLevel)throws Exception{

        return dmSchedulerSeatPriceMapper.getDmSchedulerSeatPriceBySchedulerIdAndArea(areaLevel,scheduleId);
    }
}
