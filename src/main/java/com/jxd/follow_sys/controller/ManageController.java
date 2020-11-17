package com.jxd.follow_sys.controller;

import com.jxd.follow_sys.model.User;
import com.jxd.follow_sys.service.IManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClasuserName UserController
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/11/2
 * @Version 1.0
 */
@Controller
public class ManageController {
    @Resource
    IManageService iUserService;

    //管理员看到的经理信息表
    @RequestMapping("/getManagesByPage/{curPage}/{pageSize}/{userName}/{deptName}")
    @ResponseBody
    public List<Map<String,Object>> manageTrace(@PathVariable("curPage")String curPage,
                                                @PathVariable("pageSize")String pageSize,
                                                @PathVariable("userName")String userName,@PathVariable("deptName")String deptName){
        Integer counts=(Integer.parseInt(curPage)-1)*Integer.parseInt(pageSize);
        List<Map<String,Object>> list=iUserService.managesListByPage(counts,Integer.parseInt(pageSize),userName,deptName);
        return list;
    }
    @RequestMapping("/getManagesByLike/{userName}/{deptName}")
    @ResponseBody
    public List<Map<String,Object>> getManagesByLike(@PathVariable("userName")String userName,@PathVariable("deptName")String deptName){
        return iUserService.managesListByLike(userName,deptName);
    }
    //新增用户
    @RequestMapping("/toAddManage")
    @ResponseBody
    public boolean toAddManage(@RequestBody User user1){
        boolean flag1 =false;
        if("".equals(user1.getPhoto())){
            user1.setPhoto("null.jpg");
        }
        String path = "../../static/imgs/";
        String photo = path+user1.getPhoto();
        user1.setPhoto(photo);
        if(iUserService.addManage(user1)>0){
            flag1=true;
        }
        return flag1;
    }
    //用户编辑
    @RequestMapping("/toUpdateManage")
    @ResponseBody
    public int toUpdateManage(@RequestBody User user){
        User user1 = user;
        String path = "../../static/imgs/";
        String photo = path+user.getPhoto();
        user.setPhoto(photo);
        int num=iUserService.updateManage(user);
        return num;
    }
    //批量删除
    @RequestMapping("/toDelManages/{userIds}")
    @ResponseBody
    public int toDelManages(@PathVariable("userIds")String[] userIds){
        Integer[] ids = new Integer[userIds.length];
        for(int i = 0;i<userIds.length;i++) {
            ids[i] = Integer.parseInt(userIds[i]);
        }
        List<Integer> idsToList= Arrays.asList(ids);
        int num=iUserService.delManages(idsToList);
        return num;
    }
    //    修改密码模块
    @RequestMapping("/getManagePwd/{userId}")
    @ResponseBody
    public String getManagePwd(@PathVariable("userId") int userId){
        return iUserService.getManagePwd(userId);
    }
    @RequestMapping("/changeManagePwd/{pwd}/{userId}")
    @ResponseBody
    public boolean changeTeacherPwd(@PathVariable("pwd") String pwd,@PathVariable("userId") int userId){
        boolean flag =false;
        if(iUserService.changeManagePwd(pwd,userId)>0){
            flag=true;
        }
        return flag;
    }
}
