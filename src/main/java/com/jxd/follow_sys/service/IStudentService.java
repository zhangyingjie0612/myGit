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
    //封装动态表头的prop和label
    List<Map<String,Object>> toGetAllCourse(String className);
    //管理员看到的学员跟踪表
    List<Map<String,Object>> getStudents(List<Course> courseId,String nameStr,String className,Integer counts, Integer pageSize);
    List<Map<String,Object>> getStudents2(List<Course> courseId,String nameStr,String className);
    //学生基本信息列表分页
    List<Map<String,Object>> studentsListByPage(Integer counts,Integer pageSize, String sName, String dept, String jobStr);
    List<Map<String,Object>> studentsListByLike(String sName,String dept,String jobStr);
    //查询所有班级名称
    List<Map<String,Object>> getAllClassName();
    //新增学生
    boolean addStudent(Student student);
    //编辑学生
    int updateStudent(Student student);
    //删除学生
    int delStudent(int stuId);
    //批量删除学生
    int delStudents(List<Integer> ids);
    //查询所有的部门名称
    List<Map<String,Object>> getAllDeptName();
}
