package com.jxd.follow_sys.model;

/**
 * @ClassName Scholl_evl
 * @Description: TODO
 * @Author GRZ
 * @Date 2020/11/3
 * @Version V1.0
 **/
public class Schoolevl {
    private Integer eId;//id主键
    private Integer stuId;//学生id
    private Integer userId;//用户id
    private String evlScore;//整体分数
    private String evlContent;//评价

    public Schoolevl() {
    }

    public Schoolevl(Integer stuId, Integer userId, String evlScore, String evlContent) {
        this.stuId = stuId;
        this.userId = userId;
        this.evlScore = evlScore;
        this.evlContent = evlContent;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEvlScore() {
        return evlScore;
    }

    public void setEvlScore(String evlScore) {
        this.evlScore = evlScore;
    }

    public String getEvlContent() {
        return evlContent;
    }

    public void setEvlContent(String evlContent) {
        this.evlContent = evlContent;
    }
}
