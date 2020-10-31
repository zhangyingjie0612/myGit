package com.jxd.follow_sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.model.Student;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IStudentService
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/30
 * @Version 1.0
 */
public interface IStudentService extends IService<Student> {
//    //管理员看到的学生列表
//    List<Map<String,Object>> getStudents(List<Course> courseId,Integer counts, Integer pageSize, String sName,String cName);
    //管理员看到的学生列表
    List<Map<String,Object>> getStudents(List<Course> courseId);
}
