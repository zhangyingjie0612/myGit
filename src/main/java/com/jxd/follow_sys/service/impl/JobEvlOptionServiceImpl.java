package com.jxd.follow_sys.service.impl;

import com.jxd.follow_sys.mapper.IJobEvlOptionMapper;
import com.jxd.follow_sys.model.JobEvlOption;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ：humengting
 * @description：TODO
 * @date ：2020/11/2 15:02
 */
@Service
public class JobEvlOptionServiceImpl {
    @Resource
    IJobEvlOptionMapper iJobEvlOptionMapper;

    public int getTotalNumByLike(String optionName,String optionId){
        return iJobEvlOptionMapper.getTotalNumByLike(optionName,optionId);
    };

    public List<Map<String,Object>> getPageListByLike(int counts, int pagesize, String optionName,String optionId){
        return iJobEvlOptionMapper.getPageListByLike(counts,pagesize,optionName, optionId);
    };

    public int update(JobEvlOption jobEvlOption){
        return iJobEvlOptionMapper.update(jobEvlOption);
    }

    public int deleteById(Integer optionId){
        return iJobEvlOptionMapper.deleteById(optionId);
    }

    public int deleteByIdFake(Integer optionId){
        return iJobEvlOptionMapper.deleteByIdFake(optionId);
    }

    public int batchDeleteByIds (List<Integer> list){
        return iJobEvlOptionMapper.batchDeleteByIds(list);
    }

    public int add(JobEvlOption jobEvlOption){
        return iJobEvlOptionMapper.add(jobEvlOption);
    };


    public int checkAddName (String optionName){
        return iJobEvlOptionMapper.checkAddName(optionName);
    }

}
