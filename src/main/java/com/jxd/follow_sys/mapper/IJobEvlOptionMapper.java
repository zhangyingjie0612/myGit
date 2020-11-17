package com.jxd.follow_sys.mapper;

import com.jxd.follow_sys.model.JobEvlOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author hmt
 * @date 2020/10/21
 */
public interface IJobEvlOptionMapper {

    /**
     * @description: 根据部门d、部门名获取总数
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    int getTotalNumByLike(@Param("optionName") String optionName, @Param("optionId") String optionId);

    /**
     * @description: 根据部门d、部门名获取分页数据
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    List<Map<String,Object>> getPageListByLike(@Param("counts") int counts, @Param("pagesize") int pagesize, @Param("optionName") String optionName, @Param("optionId") String optionId);

    /**
     * @description: 根据部门id和名称更新部门
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    int update(JobEvlOption JobEvlOption);

    /**
     * @description: 根据课程id删除部门
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    int deleteById(Integer optionId);

    /**
     * @description: 假删，根据课程id删除部门
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    int deleteByIdFake(Integer optionId);

    /**
     * @description: 根据课程ids批量删除部门
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    int batchDeleteByIds(@Param("list") List<Integer> list);


    int add(JobEvlOption JobEvlOption);



    int checkAddName(@Param("optionName") String optionName);
}
