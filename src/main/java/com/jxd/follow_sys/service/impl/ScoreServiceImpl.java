package com.jxd.follow_sys.service.impl;


import com.jxd.follow_sys.mapper.IScoreMapper;
import com.jxd.follow_sys.model.Score;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ：humengting
 * @description：TODO
 * @date ：2020/11/5 14:40
 */

@Service
public class ScoreServiceImpl {
    @Resource
    IScoreMapper scoreMapper;


    public List<Map<String,Object>> getAllList(Integer classid){
        return scoreMapper.getAllList(classid);
    }

    public int addScoreByClass(List<Score> list){
        return scoreMapper.addScoreByClass(list);
    }

    public List<Map<String,Object>> getClassData(Integer userid){
        return scoreMapper.getClassData(userid);
    }

    public List<Map<String,Object>> getCourseData(Integer classid){
        return scoreMapper.getCourseData(classid);
    }

    public int updateClasscourseFlag (Integer classid,Integer courseid){
        return scoreMapper.updateClasscourseFlag(classid,courseid);
    }
}
