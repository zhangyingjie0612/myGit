package com.jxd.follow_sys.controller;
import com.jxd.follow_sys.model.JobEvlOption;
import com.jxd.follow_sys.service.impl.JobEvlOptionServiceImpl;
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
public class JobEvlOptionController {
    @Autowired
    JobEvlOptionServiceImpl jobEvlOptionService;

    /**
     * @description: 根据部门d、部门名获取分页数据
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/jobEvlOption/getPageListByLike/{curPage}/{pagesize}/{optionName}/{optionId}")
    @ResponseBody
    public List<Map<String,Object>> getPageListByLike(@PathVariable("curPage")String curPage,
                                                      @PathVariable("pagesize")String pagesize,
                                                      @PathVariable("optionName")String optionName,
                                                      @PathVariable("optionId")String optionId){
        int counts = (Integer.parseInt(curPage) - 1)*Integer.parseInt(pagesize);
        List<Map<String,Object>> list = jobEvlOptionService.getPageListByLike(counts,Integer.parseInt(pagesize),optionName,optionId);
        return list;
    }

    /**
     * @description: 根据部门d、部门名获取总数
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/jobEvlOption/getTotalNumByLike/{optionName}/{optionId}")
    @ResponseBody
    public int getTotalNumByLike(@PathVariable("optionName") String optionName,
                                 @PathVariable("optionId")String optionId){
        return jobEvlOptionService.getTotalNumByLike(optionName,optionId);
    }

    /**
     * @description: 根据部门id和名称更新部门
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/jobEvlOption/update")
    @ResponseBody
    public int update(@RequestBody Map<String,Object> map){
        int optionId = (Integer) map.get("optionId");
        String optionName = (String) map.get("optionName");
        JobEvlOption jobEvlOption = new JobEvlOption(optionId,optionName);
        return jobEvlOptionService.update(jobEvlOption);
    }

    /**
     * @description: 根据课程id删除部门
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/jobEvlOption/deleteById/{optionId}")
    @ResponseBody
    public int deleteById(@PathVariable("optionId")Integer optionId ){
        return jobEvlOptionService.deleteById(optionId);
    }

    /**
     * @description: 假删，根据课程id删除部门
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/jobEvlOption/deleteByIdFake/{optionId}")
    @ResponseBody
    public int deleteByIdFake(@PathVariable("optionId")Integer optionId ){
        return jobEvlOptionService.deleteByIdFake(optionId);
    }

    /**
     * @description: 根据课程ids批量删除部门
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/jobEvlOption/batchDeleteByIds/{data}")
    @ResponseBody
    public int batchDeleteByIds(@PathVariable("data") List<Integer> data){
        return jobEvlOptionService.batchDeleteByIds(data);
    }

    /**
     * @description: 根据部门名称新增部门
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @GetMapping("/jobEvlOption/add/{optionName}")
    @ResponseBody
    public int add(@PathVariable("optionName")String optionName){

        JobEvlOption jobEvlOption = new JobEvlOption(optionName);
        return jobEvlOptionService.add(jobEvlOption);
    }
    

    /**
     * @description: 新增部门时验证该部门名是否存在
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @GetMapping("/jobEvlOption/checkAddName/{data}")
    @ResponseBody
    public String checkAddName(@PathVariable("data")  String data){
        String res = "";
        if (jobEvlOptionService.checkAddName(data)==0){
            res = "ok";//ok表示该名可用
        }
        return res;
    }

}
