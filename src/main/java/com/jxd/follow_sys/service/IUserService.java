package com.jxd.follow_sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.follow_sys.model.User;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IUserService
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/11/2
 * @Version 1.0
 */
public interface IUserService extends IService<User> {
    //重置密码
    int gotoResetPwd(int userId);
    //查询用户信息
    List<Map<String,Object>> getUserPwd(Integer counts,Integer pageSize);
    List<Map<String,Object>> getUserPwd2();
    //查询授课老师列表
    List<Map<String,Object>> getAllTeacherName();
}
