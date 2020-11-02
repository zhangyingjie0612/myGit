package com.jxd.follow_sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.follow_sys.mapper.IUserMapper;
import com.jxd.follow_sys.model.User;
import com.jxd.follow_sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/11/2
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {
    @Resource
    IUserMapper iUserMapper;

    public int gotoResetPwd(String pwd, int userId) {
        return iUserMapper.gotoResetPwd(pwd,userId);
    }

    public List<Map<String, Object>> getUserPwd(Integer counts, Integer pageSize) {
        return iUserMapper.getUserPwd(counts,pageSize);
    }

    public List<Map<String, Object>> getUserPwd2() {
        return iUserMapper.getUserPwd2();
    }
}
