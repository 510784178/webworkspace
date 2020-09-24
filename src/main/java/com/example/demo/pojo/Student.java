package com.example.demo.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value= {"handler"}) 
public class Student implements Serializable {
   
	private static final long serialVersionUID = 1L;

	private Integer stuId;

	private String stuNo;

    private String stuName;

    private String stuLogin;

    private String stuPasswd;

    private String stuPhone;

    private Integer stuLimit;

    private Integer stuRemain;

    private String stuNote;

    private Integer collegeId;

    public Integer getCollegeId() {
        return collegeId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public Integer getStuLimit() {
        return stuLimit;
    }

    public String getStuLogin() {
        return stuLogin;
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuNo() {
        return stuNo;
    }

    public String getStuNote() {
        return stuNote;
    }

    public String getStuPasswd() {
        return stuPasswd;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public Integer getStuRemain() {
        return stuRemain;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public void setStuLimit(Integer stuLimit) {
        this.stuLimit = stuLimit;
    }

    public void setStuLogin(String stuLogin) {
        this.stuLogin = stuLogin == null ? null : stuLogin.trim();
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo == null ? null : stuNo.trim();
    }

    public void setStuNote(String stuNote) {
        this.stuNote = stuNote == null ? null : stuNote.trim();
    }

    public void setStuPasswd(String stuPasswd) {
        this.stuPasswd = stuPasswd == null ? null : stuPasswd.trim();
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone == null ? null : stuPhone.trim();
    }

    public void setStuRemain(Integer stuRemain) {
        this.stuRemain = stuRemain;
    }

    @Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuNo=" + stuNo + ", stuName=" + stuName + ", stuLogin=" + stuLogin
				+ ", stuPasswd=" + stuPasswd + ", stuPhone=" + stuPhone + ", stuLimit=" + stuLimit + ", stuRemain="
				+ stuRemain + ", stuNote=" + stuNote + ", collegeId=" + collegeId + "]";
	}
}