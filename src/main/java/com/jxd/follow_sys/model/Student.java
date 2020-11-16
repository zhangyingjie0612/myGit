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
    private int stuId;//学生Id
    @TableField(value = "stuName")
    private String stuName;//学生姓名
    private String sex;//学生性别
    private String nation;//民族
    private String birthday;//生日
    private String birthplace;//籍贯
    private String marry;//是否结婚
    private String telephone;//电话
    private String idCard;//身份证
    private String university;//毕业院校
    private String major;//专业
    private String photo;//照片
    private String note;//备注
    private int state;//0/1/2/3/4/5 培训/转正1年/2年/3年/删除/转正  默认为0
    private String className;//班期名称
    private String deptName;//部门名称
    private String job;//工作名称
    private String jobtime;//入职时间

    public Student() {
    }

    public Student(String stuName, String sex, String nation, String birthday, String birthplace, String marry, String telephone, String idCard, String university, String major, String photo, String note, String className) {
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
        this.className = className;
    }

    public Student(int stuId, String stuName, String sex, String nation, String birthday, String birthplace,
                   String marry, String telephone, String idCard, String university, String major, String photo,
                   String note, int state, String className, String deptName, String job, String jobtime) {
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
        this.job = job;
        this.jobtime = jobtime;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobtime() {
        return jobtime;
    }

    public void setJobtime(String jobtime) {
        this.jobtime = jobtime;
    }
}
