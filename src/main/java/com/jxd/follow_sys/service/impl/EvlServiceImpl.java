package com.jxd.follow_sys.service.impl;

import com.jxd.follow_sys.mapper.IEvlMapper;
import com.jxd.follow_sys.model.Job_evaluation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ：humengting
 * @description：TODO
 * @date ：2020/11/16 16:50
 */
@Service
public class EvlServiceImpl {
    @Resource
    IEvlMapper iEvlMapper;
    public int getTotalNumByLike( String deptName,  String stuname){
        return iEvlMapper.getTotalNumByLike(deptName,stuname);
    }

    public List<Map<String,Object>> getPageListByLike( int counts,  int pagesize,  String deptName,  String stuname){
        return iEvlMapper.getPageListByLike(counts,pagesize,deptName,stuname);
    }

    public List<Map<String,Object>> getFormData () {
        return iEvlMapper.getFormData();
    }

    public int addEvl( List<Job_evaluation> list){
        return iEvlMapper.addEvl(list);
    }

    public String getDeptName(int userId){
        return iEvlMapper.getDeptName(userId);
    }
}
