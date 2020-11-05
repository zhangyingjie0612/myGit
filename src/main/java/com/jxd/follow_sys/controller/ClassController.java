package com.jxd.follow_sys.controller;

import com.jxd.follow_sys.service.IClassService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ClassController
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/11/5
 * @Version 1.0
 */
@Controller
public class ClassController {
    @Resource
    IClassService iClassService;

    /**
     * @Author: zhangyingjie
     * @Description:查询班期列表
     * @Date:16:02 2020/11/5
     */
    @RequestMapping("/getClassesList/{curPage}/{pageSize}/{nameStr}/{className}")
    @ResponseBody
    public List<Map<String,Object>> getClassesList(@PathVariable("curPage")String curPage,
                                                   @PathVariable("pageSize")String pageSize,
                                                   @PathVariable("nameStr")String nameStr,
                                                   @PathVariable("className")String className){
        Integer counts=(Integer.parseInt(curPage)-1)*Integer.parseInt(pageSize);
        List<Map<String,Object>> list=iClassService.getClasses(counts,Integer.parseInt(pageSize),nameStr,className);
        return list;
    }
    @RequestMapping("/getClassesCount/{nameStr}/{className}")
    @ResponseBody
    public List<Map<String,Object>> getClassesCount(@PathVariable("nameStr")String nameStr,
                                                    @PathVariable("className")String className){
        return iClassService.getClassesNum(nameStr,className);
    }
    /**
     * @Author: zhangyingjie
     * @Description:向class表里添加班期信息
     * @Date:15:47 2020/11/5
     */
//    @RequestMapping("/toGetClassName")
//    @ResponseBody
//    public List<Map<String,Object>> toGetClassName(){
//        return iStudentService.getAllClassName();
//    }
    /**
     * @Author: zhangyingjie
     * @Description:向classcourse表里添加该班级对应的课程信息
     * @Date:15:47 2020/11/5
     */
//    @RequestMapping("/toGetClassName")
//    @ResponseBody
//    public List<Map<String,Object>> toGetClassName(){
//        return iStudentService.getAllClassName();
//    }
    /**
     * @Author: zhangyingjie
     * @Description:删除班级对应的课程的信息
     * @Date:15:47 2020/11/5
     */
//    @RequestMapping("/toGetClassName")
//    @ResponseBody
//    public List<Map<String,Object>> toGetClassName(){
//        return iStudentService.getAllClassName();
//    }
    /**
     * @Author: zhangyingjie
     * @Description:修改班级信息
     * @Date:15:47 2020/11/5
     */
//    @RequestMapping("/toGetClassName")
//    @ResponseBody
//    public List<Map<String,Object>> toGetClassName(){
//        return iStudentService.getAllClassName();
//    }
}
