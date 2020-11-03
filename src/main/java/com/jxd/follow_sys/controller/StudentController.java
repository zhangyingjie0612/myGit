package com.jxd.follow_sys.controller;

import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.service.ICourseService;
import com.jxd.follow_sys.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;


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
    @RequestMapping("/getStudentList/{curPage}/{pageSize}/{nameStr}")
    @ResponseBody
    public List<Map<String,Object>> studentTrace(@PathVariable("curPage")String curPage,
                                                @PathVariable("pageSize")String pageSize,
                                                 @PathVariable("nameStr")String nameStr){
        List<Course> courses = courseService.list();
        Integer counts=(Integer.parseInt(curPage)-1)*Integer.parseInt(pageSize);
        List<Map<String,Object>> list=iStudentService.getStudents(courses,nameStr,counts,Integer.parseInt(pageSize));
        return list;
    }
    @RequestMapping("/getStudentList2/{nameStr}")
    @ResponseBody
    public List<Map<String,Object>> studentTrace2(@PathVariable("nameStr")String nameStr){
        List<Course> courses = courseService.list();
        return iStudentService.getStudents2(courses,nameStr);
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

    /**
     * @Author: zhangyingjie
     * @Description:上传学生头像
     * @Date:17:09 2020/11/2
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String doUP(@RequestParam("upload") MultipartFile upload)throws Exception{
        //上传的位置
        String path = "E:\\IdeaProjects\\follow_sys\\src\\main\\webapp\\static\\images\\";
        System.out.println("path:"+path);
        //判断，该路径是否存在
        File file =new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //上传文件项
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        System.out.println("filename:"+filename);
        //把文件名称设置唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename=uuid+"-"+filename;
        System.out.println("filename:"+filename);
        //完成上传文件
        File newFile = new File(path,filename);
        upload.transferTo(newFile);
        //返回文件名
        return filename;
    }
}
