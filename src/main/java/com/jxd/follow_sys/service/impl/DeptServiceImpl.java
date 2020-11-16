package com.jxd.follow_sys.service.impl;

import com.jxd.follow_sys.mapper.IDeptMapper;
import com.jxd.follow_sys.model.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ：humengting
 * @description：TODO
 * @date ：2020/11/2 15:02
 */
@Service
public class DeptServiceImpl {
    @Resource
    IDeptMapper iDeptMapper;

    public int getTotalNumByLike(String deptname,String deptid){
        return iDeptMapper.getTotalNumByLike(deptname,deptid);
    };

    public List<Map<String,Object>> getPageListByLike(int counts, int pagesize, String deptname,String deptid){
        return iDeptMapper.getPageListByLike(counts,pagesize,deptname, deptid);
    };

    public int update(Dept dept){
        return iDeptMapper.update(dept);
    }

    public int deleteById(Integer deptid){
        return iDeptMapper.deleteById(deptid);
    }

    public int deleteByIdFake(Integer deptid){
        return iDeptMapper.deleteByIdFake(deptid);
    }

    public int batchDeleteByIds (List<Integer> list){
        return iDeptMapper.batchDeleteByIds(list);
    }

    public int add(Dept dept){
        return iDeptMapper.add(dept);
    };

    public int ifUserExist ( List<Integer> list){
        return  iDeptMapper.ifUserExist(list);
    }

    public int ifStudentExist (List<Integer> list){
        return iDeptMapper.ifStudentExist(list);
    }

    public int checkAddName (String coursename){
        return iDeptMapper.checkAddName(coursename);
    }

}
