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
    //管理员看到的学员跟踪表
    List<Map<String,Object>> getStudents(List<Course> courseId,Integer counts, Integer pageSize);
    List<Map<String,Object>> getStudents2(List<Course> courseId);
    //学生基本信息列表分页
    List<Map<String,Object>> studentsListByPage(Integer counts,Integer pageSize, String sName, String dept, String jobStr);
    List<Map<String,Object>> studentsListByLike(String sName,String dept,String jobStr);
}
