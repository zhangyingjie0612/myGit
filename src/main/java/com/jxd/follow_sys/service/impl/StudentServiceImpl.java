package com.jxd.follow_sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.follow_sys.mapper.IStudentMapper;
import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.model.Student;
import com.jxd.follow_sys.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/30
 * @Version 1.0
 */
@Service
public class StudentServiceImpl extends ServiceImpl<IStudentMapper, Student> implements IStudentService {
    @Resource
    IStudentMapper iStudentMapper;
    /**
     * @Author: zhangyingjie
     * @Description:管理员看到的学员跟踪表
     * @Date:14:42 2020/10/31
     */
    public List<Map<String, Object>> getStudents(List<Course> courseId,String nameStr,Integer counts, Integer pageSize) {
        return iStudentMapper.getStudents(courseId,nameStr,counts,pageSize);
    }

    public List<Map<String, Object>> getStudents2(List<Course> courseId,String nameStr) {
        return iStudentMapper.getStudents2(courseId,nameStr);
    }

    public List<Map<String, Object>> studentsListByPage(Integer counts, Integer pageSize, String sName, String dept, String jobStr) {
        return iStudentMapper.studentsListByPage(counts,pageSize,sName,dept,jobStr);
    }

    public List<Map<String, Object>> studentsListByLike(String sName, String dept, String jobStr) {
        return iStudentMapper.studentsListByLike(sName,dept,jobStr);
    }
}
