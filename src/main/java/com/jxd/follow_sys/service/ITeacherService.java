package com.jxd.follow_sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.follow_sys.model.Schoolevl;
import com.jxd.follow_sys.model.User;

import java.util.List;
import java.util.Map;

public interface ITeacherService extends IService<User> {
    /**
     * @Author: grz
     * @Description:管理员查看教师
     * @Date:10:23 2020/11/4
     */
    List<Map<String,Object>> getTeacherByLike(String userName);
    List<Map<String,Object>> getTeacher(Integer counts, Integer pageSize,String userName);
    /**
     * @Author: grz
     * @Description:新增教师
     * @Date:17:22 2020/11/4
     */
    int addTeacher(User teacher);
    /**
     * @Author: grz
     * @Description:编辑教师
     * @Date:9:51 2020/11/5
     */
    int updateTeacher(User teacher);
    /**
     * @Author: grz
     * @Description:批量删除老师
     * @Date:11:31 2020/11/5
     */
    int deleteTeacherByIds(List<Integer> userId);
    /**
     * @Author: grz
     * @Description:老师获取自己教的班期
     * @Date:15:20 2020/11/12
     */
    List<Map<String,Object>> getClassName(Integer userid);
    /**
     * @Author: grz
     * @Description:老师显示自己学员的列表
     * @Date:15:51 2020/11/12
     */
    List<Map<String,Object>> getAllStuByPage(Integer counts, Integer pageSize, String stuname,String classname);
    List<Map<String,Object>> getAllStuByLike(String stuname,String classname);
    /**
     * @Author: grz
     * @Description:教师获取评价列表
     * @Date:9:22 2020/11/3
     */
    List<Map<String,Object>> getSchoolEvlByPage(Integer counts, Integer pageSize, String stuname,Integer userid, String classname);
    List<Map<String,Object>> getSchoolEvlByLike(String stuname,Integer userid, String classname);
    /**
     * @Author: grz
     * @Description:教师评价
     * @Date:0:36 2020/11/5
     */
    int insertSchoolEvl(Schoolevl schoolEvl);
    /**
     * @Author: grz
     * @Description:教师修改评价
     * @Date:14:56 2020/11/5
     */
    int updateSchoolEvl(Schoolevl schoolEvl);
}
