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
    List<Map<String,Object>> getStudents(@Param("list")List<Course> courseId, @Param("nameStr")String nameStr,@Param("className")String className,@Param("counts")Integer counts,
                                         @Param("pageSize")Integer pageSize);
    List<Map<String,Object>> getStudents2(@Param("list")List<Course> courseId, @Param("nameStr")String nameStr,@Param("className")String className);
    //学生基本信息列表分页
    List<Map<String,Object>> studentsListByPage(@Param("counts") Integer counts, @Param("pageSize")Integer pageSize,
                                                @Param("sName")String sName,@Param("dept")String dept,@Param("jobStr")String jobStr);

    List<Map<String,Object>> studentsListByLike(@Param("sName")String sName,@Param("dept")String dept,@Param("jobStr")String jobStr);
    //查询所有班级名称
    List<Map<String,Object>> getAllClassName();
    //新增学生
    boolean addStudent(Student student);
//    boolean addStudent(@Param("stuName")String stuName,@Param("sex")String sex,@Param("nation")String nation,@Param("birthday")String birthday,@Param("birthplace")String birthplace,@Param("marry")String marry,
//    @Param("telephone")String telephone,@Param("idCard")String idCard,@Param("university")String university,@Param("major")String major,@Param("photo")String photo,@Param("note")String note,@Param("className")String className);
    //向分数表中插入学生Id
    int addStudentToScore(int stuId);
    //向学校评价school_evl表里插入学生id
    int addStuToSchool(int stuId);
    //向job_evaluation工作评价表里插入学生id
    int addStuToJob(int stuId);
    //编辑学生
    int updateStudent(Student student);
    //删除学生
    int delStudent(int stuId);
    //批量删除学生
    int delStudents(List<Integer> ids);
}
