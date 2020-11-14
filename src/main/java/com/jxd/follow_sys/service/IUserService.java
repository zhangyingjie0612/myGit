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
    List<Map<String,Object>> getUserPwd(Integer counts,Integer pageSize,String nameStr);
    List<Map<String,Object>> getUserPwd2(String nameStr);
    //查询授课老师列表
    List<Map<String,Object>> getAllTeacherName();
    //    修改密码模块
    /**
     * @Author: grz
     * @Description:获取老师密码
     * @Date:15:46 2020/11/5
     */
    String getTeacherPwd(Integer userId);
    /**
     * @Author: grz
     * @Description:修改老师密码
     * @Date:16:56 2020/11/5
     */
    int changeTeacherPwd(String pwd,Integer userId);

    /*hmt*/

    Map<String, Object> getLogin(User user);

    int updateLoginTime(User user);



}
