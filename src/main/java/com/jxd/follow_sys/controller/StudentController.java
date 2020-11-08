package com.jxd.follow_sys.controller;

import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.model.Student;
import com.jxd.follow_sys.service.ICourseService;
import com.jxd.follow_sys.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
     * @Description:将动态表头的prop和label封装
     * @Date:15:47 2020/11/6
     */
    @RequestMapping("/toDoGetAllCourses/{className}")
    @ResponseBody
    public List<Map<String,Object>> toDoGetAllCourses(@PathVariable("className")String className){
        return iStudentService.toGetAllCourse(className);
    }
    /**
     * @Author: zhangyingjie
     * @Description:管理员看到的学员跟踪表
     * @Date:16:09 2020/11/1
     */
    @RequestMapping("/getStudentList/{curPage}/{pageSize}/{nameStr}/{className}")
    @ResponseBody
    public List<Map<String,Object>> studentTrace(@PathVariable("curPage")String curPage,
                                                @PathVariable("pageSize")String pageSize,
                                                 @PathVariable("nameStr")String nameStr,
                                                 @PathVariable("className")String className){
        List<Course> courses = courseService.list();
        Integer counts=(Integer.parseInt(curPage)-1)*Integer.parseInt(pageSize);
        List<Map<String,Object>> list=iStudentService.getStudents(courses,nameStr,className,counts,Integer.parseInt(pageSize));
        return list;
    }
    @RequestMapping("/getStudentList2/{nameStr}/{className}")
    @ResponseBody
    public List<Map<String,Object>> studentTrace2(@PathVariable("nameStr")String nameStr,
                                                  @PathVariable("className")String className){
        List<Course> courses = courseService.list();
        return iStudentService.getStudents2(courses,nameStr,className);
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
    @RequestMapping("/up")
    @ResponseBody
    public String doUP(@RequestParam("picture") MultipartFile upload)throws Exception{
        System.out.println("ajax文件上传");
        //上传的位置

        String path = "E:\\vueProjects\\follow_sys\\static\\imgs";
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
    /**
     * @Author: zhangyingjie
     * @Description:查询所有班级名称
     * @Date:21:23 2020/11/3
     */
    @RequestMapping("/toGetClassName")
    @ResponseBody
    public List<Map<String,Object>> toGetClassName(){
        return iStudentService.getAllClassName();
    }
    /**
     * @Author: zhangyingjie
     * @Description:新增学生
     * @Description:返回新增学生的主键向分数表中插入
     * @Description:返回新增学生的主键向学校评价表中插入
     * @Description:返回新增学生的主键向工作评价表中插入
     * @Date:17:35 2020/11/3
     */
    @RequestMapping("/toAddStudent/{stuName}/{sex}/{nation}/{birthday}/{birthplace}/{marry}/{telephone}/{idcard}/{university}/{major}/{photo}/{note}/{className}")
    @ResponseBody
    public boolean toAddStudent(@PathVariable("stuName")String stuName,@PathVariable("sex")String sex,@PathVariable("nation")String nation,@PathVariable("birthday")String birthday,@PathVariable("birthplace")String birthplace,
                                @PathVariable("marry")String marry,@PathVariable("telephone")String telephone,@PathVariable("idcard")String idCard,@PathVariable("university")String university,@PathVariable("major")String major,
                                @PathVariable("photo")String photo,@PathVariable("note")String note,@PathVariable("className")String className){
        boolean flag=false;
        if("null".equals(note)){
            note=null;
        }
        String path = "../../static/imgs/";
        Student student=new Student(stuName,sex,nation,birthday,birthplace,marry,telephone,idCard,university,major,photo,note,className);
        String photo2 = path+student.getPhoto();
        student.setPhoto(photo2);
        if(iStudentService.addStudent(student)){
            flag=true;
        }
        return flag;
    }
    /**
     * @Author: zhangyingjie
     * @Description:编辑学生
     * @Date:17:36 2020/11/3
     */
    @RequestMapping("/toUpdateStudent")
    @ResponseBody
    public int toUpdateStudent(@RequestBody Student student){
        String path = "../../static/imgs/";
        String photo = path+student.getPhoto();
        student.setPhoto(photo);
        int num=iStudentService.updateStudent(student);
        return num;
    }
    /**
     * @Author: zhangyingjie
     * @Description:删除单条学生信息
     * @Date:17:37 2020/11/3
     */
    @RequestMapping("/toDelStudent/{stuId}")
    @ResponseBody
    public int toDelStudent(@PathVariable("stuId")String stuId){
        int stuId2=Integer.parseInt(stuId);
        int num=iStudentService.delStudent(stuId2);
        return num;
    }
    /**
     * @Author: zhangyingjie
     * @Description:批量删除学生信息
     * @Date:17:37 2020/11/3
     */
    @RequestMapping("/toDelStudents/{stuIds}")
    @ResponseBody
    public int toDelStudents(@PathVariable("stuIds")String[] stuIds){
        Integer[] ids = new Integer[stuIds.length];
        for(int i = 0;i<stuIds.length;i++) {
            ids[i] = Integer.parseInt(stuIds[i]);
        }
        List<Integer> idsToList= Arrays.asList(ids);
        int num=iStudentService.delStudents(idsToList);
        return num;
    }
}
