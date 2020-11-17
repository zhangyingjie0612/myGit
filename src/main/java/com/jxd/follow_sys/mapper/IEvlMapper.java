package com.jxd.follow_sys.mapper;

import com.jxd.follow_sys.model.Job_evaluation;
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
public interface IEvlMapper {

    /**
     * @description: 根据课程id、课程名获取总数
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    int getTotalNumByLike(@Param("deptName") String deptName, @Param("stuname") String stuname);

    /**
     * @description: 根据课程id、课程名获取分页数据
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    List<Map<String,Object>> getPageListByLike(@Param("counts") int counts, @Param("pagesize") int pagesize, @Param("deptName") String deptName, @Param("stuname") String stuname);


    List<Map<String,Object>> getFormData();

    int addEvl(@Param("list") List<Job_evaluation> list);

    String getDeptName(int userId);
}
