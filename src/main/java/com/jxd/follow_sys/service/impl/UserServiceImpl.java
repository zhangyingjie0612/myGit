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

    public int gotoResetPwd(int userId) {
        return iUserMapper.gotoResetPwd(userId);
    }

    public List<Map<String, Object>> getUserPwd(Integer counts, Integer pageSize,String nameStr) {
        return iUserMapper.getUserPwd(counts,pageSize,nameStr);
    }

    public List<Map<String, Object>> getUserPwd2(String nameStr) {
        return iUserMapper.getUserPwd2(nameStr);
    }

    public List<Map<String, Object>> getAllTeacherName() {
        return iUserMapper.getAllTeacherName();
    }
}
