package com.jxd.follow_sys.controller;

import com.jxd.follow_sys.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author:grz
 * @Description:Todo
 * @Date:2019/11/20
 */
@Controller
public class DemoController {
    @Autowired
    IMenuService iMenuService;
/**
 * @Author: grz
 * @Description:
 * @Date:16:25 2020/11/1
 */
    @RequestMapping("/getMenu/{userid}")
    @ResponseBody
    public List<Map<String, Object>> getAllDeptByLike(@PathVariable("userid") String userid) {
        List<Map<String, Object>> a =iMenuService.queryMenuInfo(userid);
        return a;
    }
}
