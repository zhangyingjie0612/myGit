package com.jxd.follow_sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName Course
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/30
 * @Version 1.0
 */
@TableName(value = "course")
public class Course {
    @TableId(value = "courseId") //@TableId声明主键，value值对应表的字段名
    private int courseId;
    private String coursename;
    private int flag;//0/1  0为假删，默认为1

    public Course() {
    }

    public Course(int courseId, String coursename) {
        this.courseId = courseId;
        this.coursename = coursename;
    }

    public Course(int courseId, String coursename, int flag) {
        this.courseId = courseId;
        this.coursename = coursename;
        this.flag = flag;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
