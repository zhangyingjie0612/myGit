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
    int gotoResetPwd(@Param("pwd") String pwd, @Param("userId") int userId);
    //查询用户信息
    List<Map<String,Object>> getUserPwd(@Param("counts")Integer counts, @Param("pageSize")Integer pageSize);
    List<Map<String,Object>> getUserPwd2();
}
