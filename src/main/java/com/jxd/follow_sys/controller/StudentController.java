package com.jxd.follow_sys.controller;

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
    /**
     * @Author: zhangyingjie
     * @Description:管理员看到的学员跟踪表
     * @Date:16:09 2020/11/1
     */
    @RequestMapping("/getStudentList/{curPage}/{pageSize}")
    @ResponseBody
    public List<Map<String,Object>> studentTrace(@PathVariable("curPage")String curPage,
                                                @PathVariable("pageSize")String pageSize){
        List<Course> courses = courseService.list();
        Integer counts=(Integer.parseInt(curPage)-1)*Integer.parseInt(pageSize);
        List<Map<String,Object>> list=iStudentService.getStudents(courses,counts,Integer.parseInt(pageSize));
        return list;
    }
    @RequestMapping("/getStudentList2")
    @ResponseBody
    public List<Map<String,Object>> studentTrace2(){
        List<Course> courses = courseService.list();
        return iStudentService.getStudents2(courses);
    }
    /**
     * @Author: zhangyingjie
     * @Description:管理员看到的学生基本信息列表
     * @Date:16:09 2020/11/1
     */
    @RequestMapping("/getStudentsByPage/{curPage}/{pageSize}/{sName}/{dept}/{jobStr}")
    @ResponseBody
    public List<Map<String,Object>> getStudentsByPage(@PathVariable("curPage")String curPage,@PathVariable("pageSize")String pageSize,
                                                      @PathVariable("sName")String sName,@PathVariable("dept")String dept,@PathVariable("jobStr")String jobStr){
        Integer counts=(Integer.parseInt(curPage)-1)*Integer.parseInt(pageSize);
        List<Map<String,Object>> resultValue=iStudentService.studentsListByPage(counts,Integer.parseInt(pageSize),sName,dept,jobStr);
        return resultValue;
    }

    @RequestMapping("/getStudentsByLike/{sName}/{dept}/{jobStr}")
    @ResponseBody
    public List<Map<String,Object>> getStudentsByLike(@PathVariable("sName")String sName,@PathVariable("dept")String dept,@PathVariable("jobStr")String jobStr){
        return iStudentService.studentsListByLike(sName,dept,jobStr);
    }
}
