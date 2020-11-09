package com.jxd.follow_sys.controller;

import com.jxd.follow_sys.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/11/2
 * @Version 1.0
 */
@Controller
public class UserController {
    @Resource
    IUserService iUserService;

    /**
     * @Author: zhangyingjie
     * @Description:查询用户密码列表
     * @Date:19:09 2020/11/2
     */
    @RequestMapping("/getUser/{curPage}/{pageSize}/{nameStr}")
    @ResponseBody
    public List<Map<String,Object>> getUser(@PathVariable("curPage")String curPage,
                                            @PathVariable("pageSize")String pageSize,
                                            @PathVariable("nameStr")String nameStr){
        Integer counts=(Integer.parseInt(curPage)-1)*Integer.parseInt(pageSize);
        List<Map<String,Object>> list=iUserService.getUserPwd(counts,Integer.parseInt(pageSize),nameStr);
        return list;
    }
    @RequestMapping("/getUser2/{nameStr}")
    @ResponseBody
    public List<Map<String,Object>> getUser2(@PathVariable("nameStr")String nameStr){
        return iUserService.getUserPwd2(nameStr);
    }
    /**
     * @Author: zhangyingjie
     * @Description:重置密码
     * @Date:19:11 2020/11/2
     */
    @RequestMapping("/gotoResetPwd/{userId}")
    @ResponseBody
    public int gotoResetPwd(@PathVariable("userId")String userId){
        int id=Integer.parseInt(userId);
        int num=iUserService.gotoResetPwd(id);
        return num;
    }
    /**
     * @Author: zhangyingjie
     * @Description:获得所有的教师姓名列表
     * @Date:17:09 2020/11/5
     */
    @RequestMapping("/getAllTeacherName")
    @ResponseBody
    public List<Map<String, Object>> getAllTeacherName(){
        return iUserService.getAllTeacherName();
    }
}
