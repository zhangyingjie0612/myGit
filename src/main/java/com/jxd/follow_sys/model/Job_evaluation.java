package com.jxd.follow_sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "job_evaluation")
public class Job_evaluation {
    @TableId(value = "optionId")
    private int id;
    private int dateId;
    private int stuId;
    private String optionName;
    private int userId;
    private int evlScore;
    private String jobEvlContent;
    private int sumscore;

    public Job_evaluation() {
    }

    public Job_evaluation(int dateId, int stuId, String optionName, int userId, int evlScore, String jobEvlContent, int sumscore) {
        this.dateId = dateId;
        this.stuId = stuId;
        this.optionName = optionName;
        this.userId = userId;
        this.evlScore = evlScore;
        this.jobEvlContent = jobEvlContent;
        this.sumscore = sumscore;
    }

    public Job_evaluation(int id, int dateId, int stuId, String optionName, int userId, int evlScore, String jobEvlContent, int sumscore) {
        this.id = id;
        this.dateId = dateId;
        this.stuId = stuId;
        this.optionName = optionName;
        this.userId = userId;
        this.evlScore = evlScore;
        this.jobEvlContent = jobEvlContent;
        this.sumscore = sumscore;
    }

    public int getSumscore() {
        return sumscore;
    }

    public void setSumscore(int sumscore) {
        this.sumscore = sumscore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDateId() {
        return dateId;
    }

    public void setDateId(int dateId) {
        this.dateId = dateId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEvlScore() {
        return evlScore;
    }

    public void setEvlScore(int evlScore) {
        this.evlScore = evlScore;
    }

    public String getJobEvlContent() {
        return jobEvlContent;
    }

    public void setJobEvlContent(String jobEvlContent) {
        this.jobEvlContent = jobEvlContent;
    }
}
