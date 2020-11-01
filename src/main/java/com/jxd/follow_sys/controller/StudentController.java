package com.jxd.follow_sys.controller;

import com.jxd.follow_sys.mapper.IStudentMapper;
import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.service.ICourseService;
import com.jxd.follow_sys.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentController
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/30
 * @Version 1.0
 */
@Controller
public class StudentController {
    @Resource
    IStudentService iStudentService;
    @Resource
    ICourseService courseService;

    @RequestMapping("/getStudentList/{curPage}/{pageSize}")
    @ResponseBody
    public List<Map<String,Object>> studentList(@PathVariable("curPage")String curPage,
                                                @PathVariable("pageSize")String pageSize){
        List<Course> courses = courseService.list();
        Integer counts=(Integer.parseInt(curPage)-1)*Integer.parseInt(pageSize);
        List<Map<String,Object>> list=iStudentService.getStudents(courses,counts,Integer.parseInt(pageSize));
        return list;
    }
//    @RequestMapping("/getStudentList")
//    @ResponseBody
//    public List<Map<String,Object>> studentList(){
//        List<Course> courses = courseService.list();
//        List<Map<String,Object>> list=iStudentService.getStudents(courses);
//        return list;
//    }
}
