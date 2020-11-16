package com.jxd.follow_sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.follow_sys.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ICourseMapper
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/30
 * @Version 1.0
 */
public interface ICourseMapper extends BaseMapper<Course> {

    int getTotalNumByLike(@Param("coursename") String coursename, @Param("courseid") String courseid);

    List<Map<String,Object>> getPageListByLike(@Param("counts") int counts, @Param("pagesize") int pagesize, @Param("coursename") String coursename, @Param("courseid") String courseid);

    int update(Course course);

    int deleteById(Integer courseid);

    int deleteByIdFake(Integer courseid);

    int batchDeleteByIds(@Param("list") List<Integer> list);

    int add(Course course);

    int ifClasscourseExist(@Param("list") List<Integer> list);

    int checkAddName(@Param("coursename") String coursename);

}
