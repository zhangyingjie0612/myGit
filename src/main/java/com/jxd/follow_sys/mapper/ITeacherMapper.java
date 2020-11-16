package com.jxd.follow_sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.model.Schoolevl;
import com.jxd.follow_sys.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ITeacherMapper  extends BaseMapper<User> {
    /**
     * @Author: grz
     * @Description:管理员查看教师
     * @Date:10:23 2020/11/4
     */
    List<Map<String,Object>> getTeacher(@Param("counts") Integer counts, @Param("pageSize") Integer pageSize, @Param("userName") String userName);
    List<Map<String,Object>> getTeacherByLike(@Param("userName") String userName);
    /**
     * @Author: grz
     * @Description:新增教师
     * @Date:17:22 2020/11/4
     */
    int addTeacher(@Param("teacher") User teacher);
    /**
     * @Author: grz
     * @Description:编辑教师
     * @Date:9:51 2020/11/5
     */
    int updateTeacher(@Param("teacher") User teacher);
    /**
     * @Author: grz
     * @Description:批量删除老师
     * @Date:11:31 2020/11/5
     */
    int deleteTeacherByIds(@Param("userId") List<Integer> userId);
    /**
     * @Author: grz
     * @Description:老师获取自己教的班期
     * @Date:15:20 2020/11/12
     */
    List<Map<String,Object>> getClassName(@Param("userid") Integer userid);
    /**
     * @Author: grz
     * @Description:老师显示自己学员的列表
     * @Date:15:51 2020/11/12
     */
    List<Map<String,Object>> getAllStuByPage(@Param("counts") Integer counts, @Param("pageSize") Integer pageSize, @Param("stuname") String stuname,@Param("classname") String classname);
    List<Map<String,Object>> getAllStuByLike(@Param("stuname") String stuname,@Param("classname") String classname);
    /**
     * @Author: grz
     * @Description:教师获取评价列表
     * @Date:9:22 2020/11/3
     */
    List<Map<String,Object>> getSchoolEvlByPage(@Param("counts") Integer counts, @Param("pageSize") Integer pageSize,
                                                @Param("stuname") String stuname,@Param("userid") Integer userid,@Param("classname") String classname);
    List<Map<String,Object>> getSchoolEvlByLike(@Param("stuname") String stuname,@Param("userid") Integer userid,@Param("classname") String classname);
    /**
     * @Author: grz
     * @Description:教师评价
     * @Date:0:36 2020/11/5
     */
    int insertSchoolEvl(@Param("schoolEvl") Schoolevl schoolEvl);
    /**
     * @Author: grz
     * @Description:教师修改评价
     * @Date:14:56 2020/11/5
     */
    int updateSchoolEvl(@Param("schoolEvl") Schoolevl schoolEvl);
    /**
     * @Author: grz
     * @Description:获取学生信息成绩
     * @Date:12:11 2020/11/16
     */
    List<Map<String,Object>> getStudents3(@Param("list")List<Course> courseId, @Param("nameStr")String nameStr,@Param("className")String className);
}
