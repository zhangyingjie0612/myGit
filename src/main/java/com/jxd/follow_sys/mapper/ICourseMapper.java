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
    /**
     * @description: 根据课程id、课程名获取总数
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    int getTotalNumByLike(@Param("coursename") String coursename, @Param("courseId") String courseId);

    /**
     * @description: 根据课程id、课程名获取分页数据
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    List<Map<String,Object>> getPageListByLike(@Param("counts") int counts, @Param("pagesize") int pagesize, @Param("coursename") String coursename, @Param("courseId") String courseId);

    /**
     * @description: 根据课程实体类更新课程
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    int update(Course course);

    /**
     * @description: 根据课程id删除课程
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    int deleteById(Integer courseId);

    /**
     * @description: 假删，根据课程id删除课程
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    int deleteByIdFake(Integer courseId);

    /**
     * @description: 根据课程ids批量删除课程
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    int batchDeleteByIds(@Param("list") List<Integer> list);

    /**
     * @description: 假删，根据课程ids批量删除课程
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    int add(Course course);

    /**
     * @description: 根据ids查找该课程是否有班级使用
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    int ifClasscourseExist(@Param("list") List<Integer> list);

    /**
     * @description: 新增课程时验证该课程名是否存在
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    int checkAddName(@Param("coursename") String coursename);

}
