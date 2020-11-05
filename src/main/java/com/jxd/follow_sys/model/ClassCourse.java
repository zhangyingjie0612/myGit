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
    private String classname;
    private int courseid;
    private int flag;

    public ClassCourse() {
    }

    public ClassCourse(String classname, int courseid, int flag) {
        this.classname = classname;
        this.courseid = courseid;
        this.flag = flag;
    }

    public ClassCourse(String classname, int courseid) {
        this.classname = classname;
        this.courseid = courseid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
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
