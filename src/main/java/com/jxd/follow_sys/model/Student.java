package com.jxd.follow_sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName Student
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/30
 * @Version 1.0
 */
@TableName(value = "student")
public class Student {
    @TableId(value = "stuId") //@TableId声明主键，value值对应表的字段名
    private int stuId;
    @TableField(value = "stuName")
    private String stuName;
    private String sex;
    private String nation;
    private String birthday;
    private String birthplace;
    private String marry;
    private int telephone;
    private String idCard;
    private String university;
    private String major;
    private String photo;
    private String note;
    private int state;//0/1/2/3 培训/转正1年/2年/3年  默认为0
    private String className;
    private String deptName;

    public Student() {
    }

    public Student(int stuId, String stuName, String sex, String nation, String birthday, String birthplace, String marry,
                   int telephone, String idCard, String university, String major, String photo, String note, int state, String className, String deptName) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.sex = sex;
        this.nation = nation;
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.marry = marry;
        this.telephone = telephone;
        this.idCard = idCard;
        this.university = university;
        this.major = major;
        this.photo = photo;
        this.note = note;
        this.state = state;
        this.className = className;
        this.deptName = deptName;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getMarry() {
        return marry;
    }

    public void setMarry(String marry) {
        this.marry = marry;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
