package com.jxd.follow_sys.controller;

import com.jxd.follow_sys.model.Job_evaluation;
import com.jxd.follow_sys.service.impl.EvlServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @ClassName CourseController
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/30
 * @Version 1.0
 */
@Controller
public class EvlController {

    /*hmt*/
    @Autowired
    EvlServiceImpl evlService;
    /**
     * @description: 根据课程id、课程名获取分页数据
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/evl/getPageListByLike/{curPage}/{pagesize}/{stuname}/{deptName}")
    @ResponseBody
    public List<Map<String,Object>> getPageListByLike(@PathVariable("curPage")String curPage,
                                                      @PathVariable("pagesize")String pagesize,
                                                      @PathVariable("stuname")String stuname,
                                                      @PathVariable("deptName")String deptName){
        int counts = (Integer.parseInt(curPage) - 1)*Integer.parseInt(pagesize);
        List<Map<String,Object>> list = evlService.getPageListByLike(counts,Integer.parseInt(pagesize),deptName,stuname);
        return list;
    }

    /**
     * @description: 根据课程id、课程名获取总数
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/evl/getTotalNumByLike/{stuname}/{deptName}")
    @ResponseBody
    public int getTotalNumByLike(@PathVariable("stuname") String stuname,
                                 @PathVariable("deptName")String deptName){
        int a = evlService.getTotalNumByLike(deptName,stuname);
        return evlService.getTotalNumByLike(deptName,stuname);
    }



    @RequestMapping("/evl/getFormData")
    @ResponseBody
    public List<Map<String,Object>> getFormData () {
        return evlService.getFormData();
    }

    @RequestMapping("/evl/addEvl/{userId}/{dateId}/{stuId}/{sumscore}/{jobEvlContent}")
    @ResponseBody
    public int addEvl (@PathVariable("userId")String userId,
                       @PathVariable("dateId")String dateId,
                       @PathVariable("stuId")String stuId,
                       @PathVariable("sumscore")String sumscore,
                       @PathVariable("jobEvlContent")String jobEvlContent,
                       @RequestBody String data){
        JSONArray jsonArray = JSONArray.fromObject(data);
        List<Job_evaluation> list = new ArrayList<>();
        //遍历jsonArray每个对象，获取需要信息封装成score，添加到list
        if (jsonArray.size()>0){
            for (int i = 0;i<jsonArray.size();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Integer evlScore = Integer.parseInt(jsonObject.get("model").toString()) ;
                String optionName = (String) jsonObject.get("prop");
                Job_evaluation job_evaluation = new Job_evaluation(Integer.parseInt(dateId),Integer.parseInt(stuId),optionName,Integer.parseInt(userId),evlScore,jobEvlContent,Integer.parseInt(sumscore));
                list.add(job_evaluation);
            }
        }
        return evlService.addEvl(list);
    }

    @RequestMapping("/evl/getDeptName/{userId}")
    @ResponseBody
    public String getDeptName(@PathVariable("userId")String  userId){
        return evlService.getDeptName(Integer.parseInt(userId));
    }
}
