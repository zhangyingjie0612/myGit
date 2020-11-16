package com.jxd.follow_sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.follow_sys.mapper.ITeacherMapper;
import com.jxd.follow_sys.mapper.IUserMapper;
import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.model.Schoolevl;
import com.jxd.follow_sys.model.User;
import com.jxd.follow_sys.service.ITeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TeacherServiceImpl
 * @Description: TODO
 * @Author GRZ
 * @Date 2020/11/12
 * @Version V1.0
 **/
@Service
public class TeacherServiceImpl extends ServiceImpl<ITeacherMapper, User>  implements ITeacherService {
    @Resource
    ITeacherMapper iTeacherMapper;
    /**
     * @Author: grz
     * @Description:管理员查看教师
     * @Date:10:23 2020/11/4
     */
    public List<Map<String, Object>> getTeacherByLike(String userName) {
        return iTeacherMapper.getTeacherByLike(userName);
    }

    public List<Map<String, Object>> getTeacher(Integer counts, Integer pageSize, String userName) {
        return iTeacherMapper.getTeacher(counts,pageSize,userName);
    }

    /**
     * @Author: grz
     * @Description:新增教师
     * @Date:9:51 2020/11/5
     */
    public int addTeacher(User teacher) {
        return iTeacherMapper.addTeacher(teacher);
    }

    /**
     * @Author: grz
     * @Description:编辑教师
     * @Date:9:51 2020/11/5
     */
    public int updateTeacher(User teacher) {
        return iTeacherMapper.updateTeacher(teacher);
    }

    /**
     * @Author: grz
     * @Description:批量删除老师
     * @Date:11:31 2020/11/5
     */
    public int deleteTeacherByIds(List<Integer> userId) {
        return iTeacherMapper.deleteTeacherByIds(userId);
    }

    /**
     * @Author: grz
     * @Description:老师获取自己教的班期
     * @Date:15:20 2020/11/12
     */
    public List<Map<String, Object>> getClassName(Integer userid) {
        return iTeacherMapper.getClassName(userid);
    }
    /**
     * @Author: grz
     * @Description:老师显示自己学员的列表
     * @Date:15:51 2020/11/12
     */
    public List<Map<String, Object>> getAllStuByPage(Integer counts, Integer pageSize, String stuname,String classname) {
        return iTeacherMapper.getAllStuByPage(counts,pageSize,stuname,classname);
    }

    public List<Map<String, Object>> getAllStuByLike(String stuname, String classname) {
        return iTeacherMapper.getAllStuByLike(stuname,classname);
    }
    /**
     * @Author: grz
     * @Description:教师获取评价列表
     * @Date:9:22 2020/11/3
     */
    public List<Map<String, Object>> getSchoolEvlByPage(Integer counts, Integer pageSize, String stuname, Integer userid, String classname) {
        return iTeacherMapper.getSchoolEvlByPage(counts,pageSize,stuname,userid,classname);
    }

    public List<Map<String, Object>> getSchoolEvlByLike(String stuname, Integer userid, String classname) {
        return iTeacherMapper.getSchoolEvlByLike(stuname,userid,classname);
    }
    /**
     * @Author: grz
     * @Description:教师评价
     * @Date:0:36 2020/11/5
     */
    public int insertSchoolEvl(Schoolevl schoolEvl) {
        return iTeacherMapper.insertSchoolEvl(schoolEvl);
    }
    /**
     * @Author: grz
     * @Description:教师修改评价
     * @Date:14:56 2020/11/5
     */
    public int updateSchoolEvl(Schoolevl schoolEvl) {
        return iTeacherMapper.updateSchoolEvl(schoolEvl);
    }
/**
 * @Author: grz
 * @Description:获取学生信息成绩
 * @Date:12:11 2020/11/16
 */
    public List<Map<String, Object>> getStudents3(List<Course> courseId, String nameStr, String className) {
        return iTeacherMapper.getStudents3(courseId,nameStr,className);
    }
}
