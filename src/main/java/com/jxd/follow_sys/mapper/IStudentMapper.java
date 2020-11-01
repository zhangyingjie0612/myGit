package com.jxd.follow_sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IStudentMapper
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/30
 * @Version 1.0
 */
public interface IStudentMapper extends BaseMapper<Student> {
    //管理员看到的学生列表
    List<Map<String,Object>> getStudents(@Param("list")List<Course> courseId, @Param("counts")Integer counts,
                                         @Param("pageSize")Integer pageSize);
//    //管理员看到的学生列表
//    List<Map<String,Object>> getStudents(List<Course> courseId);
}
