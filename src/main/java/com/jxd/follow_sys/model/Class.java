package com.jxd.follow_sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author hmt
 * @Date 2020/10/30
 * @Version 1.0
 */
@TableName(value = "class")
public class Class {
    @TableId(value = "classId")
    private int classId ;//班级id-主键自增
    private String className;//班级名称
    private int userId;//老师id

    public Class() {
    }

    public Class(String className, int userId) {
        this.className = className;
        this.userId = userId;
    }

    public Class(int classId, String className, int userId) {
        this.classId = classId;
        this.className = className;
        this.userId = userId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
