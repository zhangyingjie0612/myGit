package com.jxd.follow_sys.mapper;

import com.jxd.follow_sys.model.ClassCourse;
import com.jxd.follow_sys.model.Classes;
import com.jxd.follow_sys.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IClassMapper
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/11/5
 * @Version 1.0
 */
public interface IClassMapper {
    //新增班期信息
    boolean addClass(Classes classes);
    //向classcourse表里添加该班级对应的课程信息
    boolean addClassCourse(List<ClassCourse> classCourse);
    //删除班级对应的课程的信息
    int delClassCourse(int classId);
    //修改班级信息
    int updateClass(Classes classes);
    //查询班期信息
    List<Map<String,Object>> getClasses(@Param("counts")Integer counts, @Param("pageSize")Integer pageSize,@Param("nameStr")String nameStr,@Param("className")String className);
    List<Map<String,Object>> getClassesNum(@Param("nameStr")String nameStr,@Param("className")String className);
    //获取课程名称
    List<Map<String,Object>> getCourseName();
}