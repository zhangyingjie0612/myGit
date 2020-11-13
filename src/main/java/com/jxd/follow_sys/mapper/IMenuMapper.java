package com.jxd.follow_sys.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IMenuMapper {
    List<Map<String, Object>> queryAllMenu(@Param("userid") String userid);
//    List<Map<String, Object>> getChild(String id, List<Map<String, Object>> allMenu);
}
