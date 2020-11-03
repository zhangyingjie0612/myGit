package com.jxd.follow_sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName User
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/11/2
 * @Version 1.0
 */
@TableName(value = "user")
public class User {
    @TableId(value = "userId") //@TableId声明主键，value值对应表的字段名
    private int userId;
    private String userName;
    private String pwd;
    private String telephone;
    private String phone;
    private String email;
    private String note;
    private int flag;
    private String loginTime;
    private int deptNo;
    private int roleId;

    public User() {
    }

    public User(int userId, String userName, String pwd, String telephone, String phone, String email, String note,
                int flag, String loginTime, int deptNo, int roleId) {
        this.userId = userId;
        this.userName = userName;
        this.pwd = pwd;
        this.telephone = telephone;
        this.phone = phone;
        this.email = email;
        this.note = note;
        this.flag = flag;
        this.loginTime = loginTime;
        this.deptNo = deptNo;
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
