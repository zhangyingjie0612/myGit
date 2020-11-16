package com.jxd.follow_sys.controller;

import com.jxd.follow_sys.model.User;
import com.jxd.follow_sys.service.IUserService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    //    修改密码模块
    /**
     * @Author: grz
     * @Description:获取用户密码
     * @Date:15:46 2020/11/5
     */
    @RequestMapping("/getTeacherPwd/{userId}")
    @ResponseBody
    public String getTeacherPwd(@PathVariable("userId") int userId){
        return iUserService.getTeacherPwd(userId);
    }
    /**
     * @Author: grz
     * @Description:修改密码
     * @Date:15:46 2020/11/5
     */
    @RequestMapping("/changeTeacherPwd/{pass}/{userId}")
    @ResponseBody
    public boolean changeTeacherPwd(@PathVariable("pass") String pwd,@PathVariable("userId") int userId){
        boolean flag =false;
        if(iUserService.changeTeacherPwd(pwd,userId)>0){
            flag=true;
        }
        return flag;
    }

    /**
     * @description: 登录验证
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/user/getLogin")
    @ResponseBody
    public Map<String, Object> getLogin(@RequestBody String data){
        //将data转换为json对象
        JSONObject jsonObject = JSONObject.fromObject(data);
        //获取用户名、密码和登录时间
        String userName = jsonObject.getString("userName");
        String pwd = jsonObject.getString("pwd");
        String loginTime = jsonObject.getString("loginTime");
        //封装成user
        User user1= new User(userName,pwd,loginTime);
        //根据user登录验证
        Map<String, Object> map = iUserService.getLogin(user1);
        if (null!=map){
            //登录验证成功则更新登录时间
            iUserService.updateLoginTime(user1);
        }
        //返回用户id，用户角色
        return map;
    }
}
