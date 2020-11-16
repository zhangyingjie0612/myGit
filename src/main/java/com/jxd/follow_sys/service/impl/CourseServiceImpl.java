package com.jxd.follow_sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.follow_sys.mapper.ICourseMapper;
import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.service.ICourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CourseServiceImpl
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/30
 * @Version 1.0
 */
@Service
public class CourseServiceImpl extends ServiceImpl<ICourseMapper, Course> implements ICourseService {

    /*hmt*/
    @Resource
    ICourseMapper iCourseMapper;

    public int getTotalNumByLike(String coursename,String courseid){
        return iCourseMapper.getTotalNumByLike(coursename,courseid);
    };

    public List<Map<String,Object>> getPageListByLike(int counts, int pagesize, String coursename, String courseid){
        return iCourseMapper.getPageListByLike(counts,pagesize,coursename, courseid);
    };

    public int update(Course course){
        return iCourseMapper.update(course);
    }

    public int deleteById(Integer courseid){
        return iCourseMapper.deleteById(courseid);
    }

    public int deleteByIdFake(Integer courseid){
        return iCourseMapper.deleteByIdFake(courseid);
    }

    public int batchDeleteByIds (List<Integer> list){
        return iCourseMapper.batchDeleteByIds(list);
    }

    public int add(Course course){
        return iCourseMapper.add(course);
    };

    public  int ifClasscourseExist (List<Integer> list){
        return iCourseMapper.ifClasscourseExist(list);
    }

    public int checkAddName (String coursename){
        return iCourseMapper.checkAddName(coursename);
    }

}
