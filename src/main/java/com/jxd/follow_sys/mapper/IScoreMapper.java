package com.jxd.follow_sys.mapper;

import com.jxd.follow_sys.model.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IScoreMapper {


    /*根据班级名称来获得分页学生数据，包括姓名和id*/
    List<Map<String,Object>> getAllList(@Param("classId") Integer classId);

    /*给整个班级新增一门课的成绩*/
    int addScoreByClass(@Param("list") List<Score> list);

    List<Map<String,Object>> getClassData(@Param("userId") Integer userId);

    List<Map<String,Object>> getCourseData(@Param("classId") Integer classId);

    int updateClasscourseFlag(@Param("classId") Integer classId, @Param("courseId") Integer courseId);

}
