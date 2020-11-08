package com.jxd.follow_sys.controller;

import com.jxd.follow_sys.model.Classes;
import com.jxd.follow_sys.service.IClassService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
     * @Description:向classcourse表里添加该班级对应的课程信息
     * @Date:15:47 2020/11/5
     */
    @RequestMapping("/toAddClass/{className}/{userId}")
    @ResponseBody
    public int toAddClass(@PathVariable("className")String className,
                              @PathVariable("userId")String userId){
        int userId2=Integer.parseInt(userId);
        Classes classes=new Classes(className,userId2);
        iClassService.addClass(classes);
        int cId=classes.getClassId();
        //批量新增对应课程信息
        return cId;
    }
    @RequestMapping(value = "/toAddClassCourse",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public boolean toAddClassCourse(@RequestBody List<String> classCourse){
        boolean flag=false;
        if(iClassService.addClassCourse(classCourse)){
            flag=true;
        }
        return flag;
    }
    /**
     * @Author: zhangyingjie
     * @Description:修改班级信息/课程（删除班级对应的课程的信息，新增）
     * @Date:15:47 2020/11/5
     */
    @RequestMapping("/toUpdateClasses/{classId}/{className}/{userId}")
    @ResponseBody
    @Transactional(rollbackFor=Exception.class)//事务
    public boolean toUpdateClasses(@PathVariable("classId")String classId,
                               @PathVariable("className")String className,
                               @PathVariable("userId")String userId){
        boolean flag=false;
        int classId2=Integer.parseInt(classId);
        int userId2=Integer.parseInt(userId);
        try {
            Classes classes=new Classes(classId2,className,userId2);
            int num=iClassService.updateClass(classes);//更新班级信息
            //删除课程信息
            iClassService.delClassCourse(classId2);
            flag=true;
        } catch (Exception e) {
            //事务回滚异常需要抛出来
            throw e;
        }
        return flag;
    }

    /**
     * @Author: zhangyingjie
     * @Description:获取全部的课程名称
     * @Date:18:58 2020/11/5
     */
    @RequestMapping("/getAllCourseName")
    @ResponseBody
    public List<Map<String,Object>> getAllCourseName(){
        List<Map<String,Object>> a = iClassService.getCourseName();
        return a;
    }
    /**
     * @Author: zhangyingjie
     * @Description:得到最大的班期id
     * @Date:15:32 2020/11/7
     */
    @RequestMapping("/toGetMaxClassId")
    @ResponseBody
    public int toGetMaxClassId(){
        return iClassService.getMaxClassId();
    }
    /**
     * @Author: zhangyingjie
     * @Description:获取班期的选课课程
     * @Date:16:04 2020/11/7
     */
    @RequestMapping("/toGetSelectedCourse/{className}")
    @ResponseBody
    public String[] toGetSelectedCourse(@PathVariable("className")String className){
        return iClassService.getSelectedCourse(className);
    }
}
