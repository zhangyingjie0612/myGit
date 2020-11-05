package com.jxd.follow_sys.test;

import com.jxd.follow_sys.Application;
import com.jxd.follow_sys.mapper.IStudentMapper;
import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.service.IClassService;
import com.jxd.follow_sys.service.ICourseService;
import com.jxd.follow_sys.service.IStudentService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/30
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)
public class Test {
    @Resource
    IStudentService iStudentService;
    @Resource
    ICourseService courseService;
    @Resource
    IClassService iClassService;

    @org.junit.Test
    public void test(){
//        List<Course> courses = courseService.list();
//        for(Course c:courses){
//            System.out.println(c.getCourseId());
//        }
//        List<Map<String,Object>> list=iStudentService.getStudents(courses);
//        for(Map map:list){
//            System.out.println(map.get("sex"));
//        }

    }
}
