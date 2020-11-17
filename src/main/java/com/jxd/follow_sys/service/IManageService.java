package com.jxd.follow_sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.follow_sys.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClasuserName IUserService
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/11/2
 * @Version 1.0
 */
public interface IManageService extends IService<User> {
    //管理员看到的经理信息表
    List<Map<String,Object>> managesListByPage(Integer counts, Integer pageSize,
                                               String userName, String deptName);
    List<Map<String,Object>> managesListByLike(String userName, String deptName);
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
