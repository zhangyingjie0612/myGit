package com.jxd.follow_sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.follow_sys.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClasuserName IUserMapper
 * @Description TODO
 * @Author zhangjie
 * @Date 2020/11/4
 * @Version 1.0
 */
public interface IManageMapper extends BaseMapper<User> {

    //管理员看到的经理信息表
    List<Map<String,Object>> managesListByPage(@Param("counts") Integer counts, @Param("pageSize") Integer pageSize,
                                               @Param("userName") String userName, @Param("deptName") String deptName);
    List<Map<String,Object>> managesListByLike(@Param("userName") String userName, @Param("deptName") String deptName);

    //新增经理
    int addManage(@Param("user") User user);
    //编辑经理
    int updateManage(User user);
    //批量删除经理
    int delManages(List<Integer> ids);
    //经理修改自己密码
    String getManagePwd(@Param("userId") Integer userId);
    int changeManagePwd(@Param("pwd") String pwd, @Param("userId") Integer userId);

}
