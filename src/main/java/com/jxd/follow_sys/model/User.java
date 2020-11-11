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
    private String idcard;
    private String email;
    private String note;
    private int flag;
    private String birthday;
    private int deptNo;
    private int roleId;
    private String photo;
    private String sex;

    public User() {
    }

    public User(int userId, String userName, String pwd, String telephone, String idcard, String email, String note,
                int flag, String birthday, int deptNo, int roleId) {
        this.userId = userId;
        this.userName = userName;
        this.pwd = pwd;
        this.telephone = telephone;
        this.idcard = idcard;
        this.email = email;
        this.note = note;
        this.flag = flag;
        this.birthday = birthday;
        this.deptNo = deptNo;
        this.roleId = roleId;
    }

    public User(int userId, String userName, String pwd, String telephone, String idcard, String email, String note,
                int flag, String birthday, int deptNo, int roleId, String photo, String sex) {
        this.userId = userId;
        this.userName = userName;
        this.pwd = pwd;
        this.telephone = telephone;
        this.idcard = idcard;
        this.email = email;
        this.note = note;
        this.flag = flag;
        this.birthday = birthday;
        this.deptNo = deptNo;
        this.roleId = roleId;
        this.photo = photo;
        this.sex = sex;
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

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
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

    public String getbirthday() {
        return birthday;
    }

    public void setbirthday(String birthday) {
        this.birthday = birthday;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
