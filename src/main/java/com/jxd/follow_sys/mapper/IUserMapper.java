package com.jxd.follow_sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.follow_sys.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IUserMapper
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/11/2
 * @Version 1.0
 */
public interface IUserMapper extends BaseMapper<User> {
    //重置密码
    int gotoResetPwd(int userId);
    //查询用户信息
    List<Map<String,Object>> getUserPwd(@Param("counts")Integer counts, @Param("pageSize")Integer pageSize,@Param("nameStr")String nameStr);
    List<Map<String,Object>> getUserPwd2(@Param("nameStr")String nameStr);
    //查询授课老师列表
    List<Map<String,Object>> getAllTeacherName();
}
