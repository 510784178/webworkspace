package com.example.demo.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value= {"handler"}) 
public class Dept implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private Integer deptId;

    
	private String deptName;

	public Integer getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
}