package com.jxd.follow_sys.controller;

import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.model.Schoolevl;
import com.jxd.follow_sys.model.User;
import com.jxd.follow_sys.service.ICourseService;
import com.jxd.follow_sys.service.IStudentService;
import com.jxd.follow_sys.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName TeacherController
 * @Description: TODO
 * @Author GRZ
 * @Date 2020/11/12
 * @Version V1.0
 **/
@Controller
public class TeacherController {
    @Autowired
    ITeacherService iTeacherService;
    @Resource
    ICourseService courseService;
    /**
     * @Author: grz
     * @Description:管理员查看教师
     * @Date:10:23 2020/11/4
     */
    @RequestMapping("/getTeacherByLike/{userName}")
    @ResponseBody
    public List<Map<String,Object>> getTeacherByLike(@PathVariable("userName") String userName){
        return iTeacherService.getTeacherByLike(userName);
    }
    @RequestMapping("/getTeacher/{curPage}/{pageSize}/{userName}")
    @ResponseBody
    public List<Map<String,Object>> getTeacher(@PathVariable("curPage") String curPage, @PathVariable("pageSize") String pageSize,@PathVariable("userName") String userName){
        Integer counts = (Integer.parseInt(curPage) - 1) * Integer.parseInt(pageSize);
        return iTeacherService.getTeacher(counts,Integer.parseInt(pageSize),userName);
    }
    /**
     * @Author: grz
     * @Description:新增教师
     * @Date:17:04 2020/11/4
     */
    @RequestMapping("/addTeacher")
    @ResponseBody
    public boolean addTeacher(@RequestBody User teacherDate1){
        boolean flag1 =false;
        if("".equals(teacherDate1.getPhoto())){
            teacherDate1.setPhoto("null.jpg");
        }
//        String path = "../../static/imgs/";
        String path = "http://localhost:8080/images/";

        String photo = path+teacherDate1.getPhoto();
        teacherDate1.setPhoto(photo);
        if(iTeacherService.addTeacher(teacherDate1)>0){
            flag1=true;
        }
        return flag1;
    }
    /**
     * @Author: grz
     * @Description:编辑老师
     * @Date:9:59 2020/11/5
     */
    @RequestMapping("/updateTeacher")
    @ResponseBody
    public boolean updateTeacher(@RequestBody User teacherDate){
        boolean flag1 =false;
        String path = "http://localhost:8080/images/";
        String photo = path+teacherDate.getPhoto();
        teacherDate.setPhoto(photo);
        if(iTeacherService.updateTeacher(teacherDate)>0){
            flag1=true;
        }
        return flag1;
    }
    /**
     * @Author: grz
     * @Description:批量删除老师
     * @Date:11:31 2020/11/5
     */
    @RequestMapping("/deleteTeacherByIds/{userIds}")
    @ResponseBody
    public boolean deleteTeacherByIds(@PathVariable("userIds")  String[] userIds){
        boolean flag =false;

        Integer[] userId1 = new Integer[userIds.length];
        for(int i = 0;i<userIds.length;i++) {
            userId1[i] = Integer.parseInt(userIds[i]);
        }
        List<Integer> userId= Arrays.asList(userId1);
        if(iTeacherService.deleteTeacherByIds(userId)>0){
            flag=true;
        }
        return flag;
    }
    /**
     * @Author: grz
     * @Description:老师获取自己教的班期
     * @Date:15:20 2020/11/12
     */
    @RequestMapping("/getClassName/{userid}")
    @ResponseBody
    public List<Map<String,Object>> getClassName(@PathVariable("userid") int userid){
        return iTeacherService.getClassName(userid);
    }
    /**
     * @Author: grz
     * @Description:老师显示自己学员的列表
     * @Date:15:51 2020/11/12
     */
    @RequestMapping("/getAllStuByPage/{curPage}/{pageSize}/{stuname}/{classname}")
    @ResponseBody
    public List<Map<String,Object>> getAllEmpByPage(@PathVariable("curPage") String curPage, @PathVariable("pageSize") String pageSize,
                                                    @PathVariable("stuname") String stuname,@PathVariable("classname") String classname){
        Integer counts = (Integer.parseInt(curPage) - 1) * Integer.parseInt(pageSize);
        List<Map<String,Object>> resultValue = iTeacherService.getAllStuByPage(counts,Integer.parseInt(pageSize),stuname,classname);
        return resultValue;
    }
    @RequestMapping("/getAllStuByLike/{stuname}/{classname}")
    @ResponseBody
    public List<Map<String,Object>> getAllEmpByLike(@PathVariable("stuname") String stuname,@PathVariable("classname") String classname){
        return iTeacherService.getAllStuByLike(stuname,classname);
    }
    /**
     * @Author: grz
     * @Description:教师获取评价列表
     * @Date:9:22 2020/11/3
     */
    @RequestMapping("/getSchoolEvl/{curPage}/{pageSize}/{stuname}/{userid}/{classname}")
    @ResponseBody
    public List<Map<String,Object>> getSchoolEvl(@PathVariable("curPage") String curPage, @PathVariable("pageSize") String pageSize,
                                                 @PathVariable("stuname") String stuname,@PathVariable("userid") int userid,@PathVariable("classname") String classname){
        Integer counts = (Integer.parseInt(curPage) - 1) * Integer.parseInt(pageSize);
        return iTeacherService.getSchoolEvlByPage(counts,Integer.parseInt(pageSize),stuname,userid,classname);
    }
    @RequestMapping("/getSchoolEvlByLike/{stuname}/{userid}/{classname}")
    @ResponseBody
    public List<Map<String,Object>> getSchoolEvlByLike(@PathVariable("stuname") String stuname,@PathVariable("userid") int userid,@PathVariable("classname") String classname){
        return iTeacherService.getSchoolEvlByLike(stuname,userid,classname);
    }
    /**
     * @Author: grz
     * @Description:教师评价
     * @Date:0:36 2020/11/5
     */
    @RequestMapping("/insertSchoolEvl")
    @ResponseBody
    public String insertSchoolEvl(@RequestBody Schoolevl schoolEvl){
        String flag = "评价失败";
        if (iTeacherService.insertSchoolEvl(schoolEvl)>0){
            flag = "评价成功";
        }
        return flag;
    }
    /**
     * @Author: grz
     * @Description:教师修改评价
     * @Date:14:56 2020/11/5
     */
    @RequestMapping("/updateSchoolEvl")
    @ResponseBody
    public String updateSchoolEvl(@RequestBody Schoolevl schoolEvl){
        String flag = "修改失败";
        if (iTeacherService.updateSchoolEvl(schoolEvl)>0){
            flag = "修改成功";
        }
        return flag;
    }
    /**
     * @Author: grz
     * @Description:图片上传
     * @Date:19:26 2020/11/12
     */
    @RequestMapping("/up")
    @ResponseBody
    public String doUP(@RequestParam("picture") MultipartFile upload)throws Exception{
        System.out.println("ajax文件上传");
        //上传的位置

//        String path = "E:\\WebstormProjects\\workspace\\follow_vue\\static\\imgs";
        String path = "D:\\JinXianDai\\files";

//        String path = "F:\\springmvc\\";
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
    @RequestMapping("/getStudentList3/{nameStr}/{className}")
    @ResponseBody
    public List<Map<String,Object>> studentTrace3(@PathVariable("nameStr")String nameStr,
                                                  @PathVariable("className")String className){
        List<Course> courses = courseService.list();
        return iTeacherService.getStudents3(courses,nameStr,className);
    }
}
