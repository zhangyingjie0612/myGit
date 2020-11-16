package com.jxd.follow_sys.mapper;

import com.jxd.follow_sys.model.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author hmt
 * @date 2020/10/21
 */
public interface IDeptMapper {

    int getTotalNumByLike(@Param("deptName") String deptName, @Param("deptId") String deptId);

    List<Map<String,Object>> getPageListByLike(@Param("counts") int counts, @Param("pagesize") int pagesize, @Param("deptName") String deptName, @Param("deptId") String deptId);

    int update(Dept dept);

    int deleteById(Integer deptId);

    int deleteByIdFake(Integer deptId);

    int batchDeleteByIds(@Param("list") List<Integer> list);

    int add(Dept dept);

    int ifUserExist(@Param("list") List<Integer> list);

    int ifStudentExist(@Param("list") List<Integer> list);

    int checkAddName(@Param("deptName") String deptName);
}
