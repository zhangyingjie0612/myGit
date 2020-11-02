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
    //管理员看到的学员跟踪表
    List<Map<String,Object>> getStudents(@Param("list")List<Course> courseId, @Param("counts")Integer counts,
                                         @Param("pageSize")Integer pageSize);
    List<Map<String,Object>> getStudents2(List<Course> courseId);
    //学生基本信息列表分页
    List<Map<String,Object>> studentsListByPage(@Param("counts") Integer counts, @Param("pageSize")Integer pageSize,
                                                @Param("sName")String sName,@Param("dept")String dept,@Param("jobStr")String jobStr);

    List<Map<String,Object>> studentsListByLike(@Param("sName")String sName,@Param("dept")String dept,@Param("jobStr")String jobStr);
}
