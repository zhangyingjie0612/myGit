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
    private int userId;//用户id
    private String userName;//用户姓名
    private String pwd;//密码
    private String sex;//性别
    private String telephone;//电话
    private String idCard;//身份证
    private String email;//邮箱
    private String note;//备注
    private int flag;//0/1/2  0为删除   默认为1（在职）2离职
    private String birthday;//生日
    private int deptNo;//部门Id
    private int roleId;//角色id
    private String photo;//照片
    private String loginTime;//登陆时间

    public User() {
    }

    public User(String userName, String pwd, String loginTime) {
        this.userName = userName;
        this.pwd = pwd;
        this.loginTime = loginTime;
    }

    public User(int userId, String userName, String pwd, String telephone, String idCard, String email, String note,
                int flag, String birthday, int deptNo, int roleId) {
        this.userId = userId;
        this.userName = userName;
        this.pwd = pwd;
        this.telephone = telephone;
        this.idCard = idCard;
        this.email = email;
        this.note = note;
        this.flag = flag;
        this.birthday = birthday;
        this.deptNo = deptNo;
        this.roleId = roleId;
    }

    public User(String userName, String pwd, String sex, String telephone, String idCard, String email, String note, int flag, String birthday, int deptNo, int roleId, String photo) {
        this.userName = userName;
        this.pwd = pwd;
        this.sex = sex;
        this.telephone = telephone;
        this.idCard = idCard;
        this.email = email;
        this.note = note;
        this.flag = flag;
        this.birthday = birthday;
        this.deptNo = deptNo;
        this.roleId = roleId;
        this.photo = photo;
    }

    public User(int userId, String userName, String pwd, String telephone, String idCard, String email, String note,
                int flag, String birthday, int deptNo, int roleId, String photo, String sex) {
        this.userId = userId;
        this.userName = userName;
        this.pwd = pwd;
        this.telephone = telephone;
        this.idCard = idCard;
        this.email = email;
        this.note = note;
        this.flag = flag;
        this.birthday = birthday;
        this.deptNo = deptNo;
        this.roleId = roleId;
        this.photo = photo;
        this.sex = sex;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
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

    public String getidCard() {
        return idCard;
    }

    public void setidCard(String idCard) {
        this.idCard = idCard;
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
