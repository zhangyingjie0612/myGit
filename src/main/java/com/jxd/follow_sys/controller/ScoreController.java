package com.jxd.follow_sys.controller;

import com.jxd.follow_sys.service.impl.ScoreServiceImpl;
import com.jxd.follow_sys.model.Score;
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
 * @author ：humengting
 * @description：TODO
 * @date ：2020/11/5 14:45
 */
@Controller
public class ScoreController {
    @Autowired
    ScoreServiceImpl scoreServiceImpl;

    /**
     * @description: 根据班级名获取学生信息
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/score/getAllList/{classId}")
    @ResponseBody
    public List<Map<String,Object>> getPageListByLike(@PathVariable("classId")String classId){
        return scoreServiceImpl.getAllList(Integer.parseInt(classId));
    }

    /**
     * @description: 接收courseId和data，用于录入成绩
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/score/addScores/{classId}/{courseId}")
    @ResponseBody
    public int addScores(@PathVariable("classId")String classId,@PathVariable("courseId")String courseId,@RequestBody String data){
        //将data转换为jsonArray
        JSONArray jsonArray = JSONArray.fromObject(data);
        List<Score> list = new ArrayList<>();
        //遍历jsonArray每个对象，获取需要信息封装成score，添加到list
        if (jsonArray.size()>0){
            for (int i = 0;i<jsonArray.size();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Integer stuId = (Integer) jsonObject.get("stuId");
                Integer courseId1 = Integer.parseInt(courseId);
                String score = null;
                if (null!=jsonObject.get("score")){
                    score =  jsonObject.get("score").toString();
                }
                Score score1 = new Score(stuId,courseId1,score);
                list.add(score1);
            }
        }
        //设置该classcourse为已打分状态
        scoreServiceImpl.updateClasscourseFlag(Integer.parseInt(classId),Integer.parseInt(courseId));
        //根据list来新增成绩
        return scoreServiceImpl.addScoreByClass(list);
    }


    /**
     * @description: 根据userId获取课程*
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/score/getClassData/{userId}")
    @ResponseBody
    public List<Map<String,Object>> getClassData(@PathVariable("userId")String userId){
        return scoreServiceImpl.getClassData(Integer.parseInt(userId));
    }


    /**
     * @description: 根据classid,在classcourse表获取一个确定班级的course
     * @Author humengting
     * @date: 2020/11/14 8:27
     * @return
     */
    @RequestMapping("/score/getCourseData/{classId}")
    @ResponseBody
    public List<Map<String,Object>> getCourseData(@PathVariable("classId")String classId){
        return scoreServiceImpl.getCourseData(Integer.parseInt(classId));
    }

}
