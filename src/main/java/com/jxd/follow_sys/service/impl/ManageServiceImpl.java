package com.jxd.follow_sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.follow_sys.mapper.IManageMapper;
import com.jxd.follow_sys.model.User;
import com.jxd.follow_sys.service.IManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClasuserName UserServiceImpl
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/11/2
 * @Version 1.0
 */
@Service
public class ManageServiceImpl extends ServiceImpl<IManageMapper, User> implements IManageService {

    @Resource
    IManageMapper iUserMapper;


    @Override
    public List<Map<String, Object>> managesListByPage(Integer counts, Integer pageSize, String userName, String deptName) {
        return iUserMapper.managesListByPage(counts, pageSize, userName, deptName);
    }


    @Override
    public List<Map<String, Object>> managesListByLike(String userName, String deptName) {
        return iUserMapper.managesListByLike(userName, deptName);
    }

    @Override
    public int addManage(User user) {
        return iUserMapper.addManage(user);
    }

    @Override
    public int updateManage(User user) {
        return iUserMapper.updateManage(user);
    }

    @Override
    public int delManages(List<Integer> ids) {
        return iUserMapper.delManages(ids);
    }

    @Override
    public String getManagePwd(Integer userId) {
        return iUserMapper.getManagePwd(userId);
    }

    @Override
    public int changeManagePwd(String pwd, Integer userId) {
        return iUserMapper.changeManagePwd(pwd, userId);
    }
}
