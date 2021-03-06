package com.jxd.follow_sys.service.impl;

import com.jxd.follow_sys.mapper.IClassMapper;
import com.jxd.follow_sys.model.ClassCourse;
import com.jxd.follow_sys.model.Classes;
import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.service.IClassService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ClassServiceImpl
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/11/5
 * @Version 1.0
 */
@Service
public class ClassServiceImpl implements IClassService {
    @Resource
    IClassMapper iClassMapper;

    public boolean addClass(Classes classes) {
        return iClassMapper.addClass(classes);
    }

    public boolean addClassCourse(List<ClassCourse> classCourse) {
        return iClassMapper.addClassCourse(classCourse);
    }

    public int delClassCourse(int classId) {
        return iClassMapper.delClassCourse(classId);
    }

    public int updateClass(Classes classes) {
        return iClassMapper.updateClass(classes);
    }

    public List<Map<String, Object>> getClasses(Integer counts, Integer pageSize,String nameStr,String className) {
        return iClassMapper.getClasses(counts,pageSize,nameStr,className);
    }

    public List<Map<String, Object>> getClassesNum(String nameStr,String className) {
        return iClassMapper.getClassesNum(nameStr,className);
    }

    public List<Map<String,Object>> getCourseName() {
        return iClassMapper.getCourseName();
    }

    public Integer getMaxClassId() {
        return iClassMapper.getMaxClassId();
    }

    public String[] getSelectedCourse(String className) {
        return iClassMapper.getSelectedCourse(className);
    }
}
