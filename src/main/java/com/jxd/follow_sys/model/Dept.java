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
@TableName("dept")
public class Dept {
    @TableId("deptId")
    private int deptId;//主键，部门id
    private String deptName;//部门名称
    private int flag;//假删

    public Dept() {
    }

    public Dept(int deptId, String deptName, int flag) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.flag = flag;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
