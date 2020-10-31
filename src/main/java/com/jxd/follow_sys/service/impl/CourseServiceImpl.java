package com.jxd.follow_sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.follow_sys.mapper.ICourseMapper;
import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.service.ICourseService;
import org.springframework.stereotype.Service;

/**
 * @ClassName CourseServiceImpl
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/30
 * @Version 1.0
 */
@Service
public class CourseServiceImpl extends ServiceImpl<ICourseMapper, Course> implements ICourseService {
}
