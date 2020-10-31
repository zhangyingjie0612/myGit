package com.jxd.follow_sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName Score
 * @Description TODO
 * @Author hmt
 * @Date 2020/10/30
 * @Version 1.0
 */
@TableName(value = "score")
public class Score {
    @TableId(value = "id")
    private int id;//主键-自增
    private int stuId;//学生id-外键
    private int courseId;//课程id-外键
    private String score;//成绩

    public Score() {
    }

    public Score(int id, int stuId, int courseId, String score) {
        this.id = id;
        this.stuId = stuId;
        this.courseId = courseId;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
