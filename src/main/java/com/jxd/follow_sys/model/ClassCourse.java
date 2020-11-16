package com.jxd.follow_sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName ClassCourse
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/11/5
 * @Version 1.0
 */
public class ClassCourse {
    private int id;//主键
    private int classid;//班期id
    private int courseid;//课程id
    private int flag;//是否打分flag=1未打分；flag=0已打分

    public ClassCourse() {
    }

    public ClassCourse(int id, int classid, int courseid, int flag) {
        this.id = id;
        this.classid = classid;
        this.courseid = courseid;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassCourse(int classid, int courseid, int flag) {
        this.classid = classid;
        this.courseid = courseid;
        this.flag = flag;
    }

    public ClassCourse(int classid, int courseid) {
        this.classid = classid;
        this.courseid = courseid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
