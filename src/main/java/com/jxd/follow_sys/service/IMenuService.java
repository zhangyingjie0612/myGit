package com.jxd.follow_sys.service;

import java.util.List;
import java.util.Map;

public interface IMenuService {
    List<Map<String, Object>> queryMenuInfo(String userid);
//    List<Map<String, Object>> getChild(String id, List<Map<String, Object>> allMenu);
}
