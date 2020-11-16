package com.jxd.follow_sys.controller;

import com.jxd.follow_sys.model.Dept;
import com.jxd.follow_sys.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ：humengting
 * @description：TODO
 * @date ：2020/11/2 13:45
 */

@Controller
public class DeptController {
    @Autowired
    DeptServiceImpl deptService;

    /**
     * @description: 根据部门d、部门名获取分页数据
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/dept/getPageListByLike/{curPage}/{pagesize}/{deptName}/{deptId}")
    @ResponseBody
    public List<Map<String,Object>> getPageListByLike(@PathVariable("curPage")String curPage,
                                                      @PathVariable("pagesize")String pagesize,
                                                      @PathVariable("deptName")String deptName,
                                                      @PathVariable("deptId")String deptId){
        int counts = (Integer.parseInt(curPage) - 1)*Integer.parseInt(pagesize);
        List<Map<String,Object>> list = deptService.getPageListByLike(counts,Integer.parseInt(pagesize),deptName,deptId);
        return list;
    }

    /**
     * @description: 根据部门d、部门名获取总数
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/dept/getTotalNumByLike/{deptName}/{deptId}")
    @ResponseBody
    public int getTotalNumByLike(@PathVariable("deptName") String deptName,
                                 @PathVariable("deptId")String deptId){
        return deptService.getTotalNumByLike(deptName,deptId);
    }

    /**
     * @description: 根据部门id和名称更新部门
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/dept/update")
    @ResponseBody
    public int update(@RequestBody Map<String,Object> map){
        int deptId = (Integer) map.get("deptId");
        String deptName = (String) map.get("deptName");
        Dept dept = new Dept(deptId,deptName);
        return deptService.update(dept);
    }

    /**
     * @description: 根据课程id删除部门
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/dept/deleteById/{deptId}")
    @ResponseBody
    public int deleteById(@PathVariable("deptId")Integer deptId ){
        return deptService.deleteById(deptId);
    }

    /**
     * @description: 假删，根据课程id删除部门
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/dept/deleteByIdFake/{deptId}")
    @ResponseBody
    public int deleteByIdFake(@PathVariable("deptId")Integer deptId ){
        return deptService.deleteByIdFake(deptId);
    }

    /**
     * @description: 根据课程ids批量删除部门
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/dept/batchDeleteByIds/{data}")
    @ResponseBody
    public int batchDeleteByIds(@PathVariable("data") List<Integer> data){
        return deptService.batchDeleteByIds(data);
    }

    /**
     * @description: 根据部门名称新增部门
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @GetMapping("/dept/add/{deptName}")
    @ResponseBody
    public int add(@PathVariable("deptName")String deptName){

        Dept dept = new Dept(deptName);
        return deptService.add(dept);
    }

    /**
     * @description: 根据ids查找该部门是否有成员存在
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @GetMapping("/dept/checkIfExist/{data}")
    @ResponseBody
    public boolean checkIfExist(@PathVariable("data")  List<Integer> data){
        Boolean flag =true;
        if (deptService.ifStudentExist(data)==0&&deptService.ifUserExist(data)==0){
            flag=false;
        }
        return flag;
    }

    /**
     * @description: 新增部门时验证该部门名是否存在
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @GetMapping("/dept/checkAddName/{data}")
    @ResponseBody
    public String checkAddName(@PathVariable("data")  String data){
        String res = "";
        if (deptService.checkAddName(data)==0){
            res = "ok";//ok表示该名可用
        }
        return res;
    }

}
