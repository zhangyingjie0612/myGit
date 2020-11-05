package com.jxd.follow_sys.service;

import com.jxd.follow_sys.model.ClassCourse;
import com.jxd.follow_sys.model.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IClassService
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/11/5
 * @Version 1.0
 */
public interface IClassService {
    //新增班期信息
    int addClass(Classes classes);
    //向classcourse表里添加该班级对应的课程信息
    int addClassCourse(List<ClassCourse> classCourse);
    //删除班级对应的课程的信息
    int delClassCourse(int classId);
    //修改班级信息
    int updateClass(Classes classes);
    //查询班期信息
    List<Map<String,Object>> getClasses(Integer counts, Integer pageSize,String nameStr,String className);
    List<Map<String,Object>> getClassesNum(String nameStr,String className);
    //查询授课老师列表
    List<Map<String,Object>> getAllTeacherName();
}
