package com.jxd.follow_sys.controller;

import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.service.ICourseService;
import com.jxd.follow_sys.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * @ClassName CourseController
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/30
 * @Version 1.0
 */
/**
 * @ClassName CourseController
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/30
 * @Version 1.0
 */
@Controller
public class CourseController {

    /*hmt*/
    @Autowired
    CourseServiceImpl courseService;
    /**
     * @description: 根据课程id、课程名获取分页数据
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/course/getPageListByLike/{curPage}/{pagesize}/{coursename}/{courseId}")
    @ResponseBody
    public List<Map<String,Object>> getPageListByLike(@PathVariable("curPage")String curPage,
                                                      @PathVariable("pagesize")String pagesize,
                                                      @PathVariable("coursename")String coursename,
                                                      @PathVariable("courseId")String courseId){
        int counts = (Integer.parseInt(curPage) - 1)*Integer.parseInt(pagesize);
        List<Map<String,Object>> list = courseService.getPageListByLike(counts,Integer.parseInt(pagesize),coursename,courseId);
        return list;
    }

    /**
     * @description: 根据课程id、课程名获取总数
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/course/getTotalNumByLike/{coursename}/{courseId}")
    @ResponseBody
    public int getTotalNumByLike(@PathVariable("coursename") String coursename,
                                 @PathVariable("courseId")String courseId){
        return courseService.getTotalNumByLike(coursename,courseId);
    }

    /**
     * @description: 根据课程实体类更新课程
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/course/update")
    @ResponseBody
    public int update(@RequestBody Course course){
        return courseService.update(course);
    }

    /**
     * @description: 根据课程id删除课程
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/course/deleteById/{courseId}")
    @ResponseBody
    public int deleteById(@PathVariable("courseId")Integer courseId ){
        return courseService.deleteById(courseId);
    }

    /**
     * @description: 假删，根据课程id删除课程
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/course/deleteByIdFake/{courseId}")
    @ResponseBody
    public int deleteByIdFake(@PathVariable("courseId")Integer courseId ){
        return courseService.deleteByIdFake(courseId);
    }

    /**
     * @description: 根据课程ids批量删除课程
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/course/batchDeleteByIds/{data}")
    @ResponseBody
    public int batchDeleteByIds(@PathVariable("data") List<Integer> data){
        return courseService.batchDeleteByIds(data);
    }

    /**
     * @description: 假删，根据课程ids批量删除课程
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @GetMapping("/course/add/{coursename}")
    @ResponseBody
    public int add(@PathVariable("coursename")String coursename){
        Course course = new Course(coursename);
        return courseService.add(course);
    }

    /**
     * @description: 根据ids查找该课程是否有班级使用
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @GetMapping("/course/checkIfExist/{data}")
    @ResponseBody
    public boolean checkIfExist(@PathVariable("data")  List<Integer> data){
        Boolean flag =true;
        if (courseService.ifClasscourseExist(data)==0){
            flag=false;
        }
        return flag;
    }

    /**
     * @description: 新增课程时验证该课程名是否存在
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @GetMapping("/course/checkAddName/{data}")
    @ResponseBody
    public String checkAddName(@PathVariable("data")  String data){
        String res = "";
        if (courseService.checkAddName(data)==0){
            res = "ok";//ok表示该名可用
        }
        return res;
    }

}
