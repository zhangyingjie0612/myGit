package com.jxd.follow_sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.follow_sys.mapper.IStudentMapper;
import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.model.Student;
import com.jxd.follow_sys.service.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Map<String, Object>> getStudents(List<Course> courseId,String nameStr,String className,Integer counts, Integer pageSize) {
        return iStudentMapper.getStudents(courseId,nameStr,className,counts,pageSize);
    }

    public List<Map<String, Object>> getStudents2(List<Course> courseId,String nameStr,String className) {
        return iStudentMapper.getStudents2(courseId,nameStr,className);
    }

    public List<Map<String, Object>> studentsListByPage(Integer counts, Integer pageSize, String sName, String dept, String jobStr) {
        return iStudentMapper.studentsListByPage(counts,pageSize,sName,dept,jobStr);
    }

    public List<Map<String, Object>> studentsListByLike(String sName, String dept, String jobStr) {
        return iStudentMapper.studentsListByLike(sName,dept,jobStr);
    }

    public List<Map<String, Object>> getAllClassName() {
        return iStudentMapper.getAllClassName();
    }

    @Transactional(rollbackFor=Exception.class)
    public boolean addStudent(Student student) {
        boolean result =false;
        try {
            iStudentMapper.addStudent(student);
            int num=student.getStuId();
            iStudentMapper.addStudentToScore(num);
//            iStudentMapper.addStuToSchool(num);
            iStudentMapper.addStuToJob(num);
            result = true;
        } catch (Exception e) {
            //事务回滚异常需要抛出来
            throw e;
        }
        return result;
    }

    public int addStudentToScore(int stuId) {
        return iStudentMapper.addStudentToScore(stuId);
    }

    public int addStuToJob(int stuId) {
        return iStudentMapper.addStuToJob(stuId);
    }

    public int updateStudent(Student student) {
        return iStudentMapper.updateStudent(student);
    }

    public int delStudent(int stuId) {
        return iStudentMapper.delStudent(stuId);
    }

    public int delStudents(List<Integer> ids) {
        return iStudentMapper.delStudents(ids);
    }
}
