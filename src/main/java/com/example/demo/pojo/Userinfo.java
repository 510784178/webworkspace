package com.example.demo.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value= {"handler"}) 
public class Userinfo implements Serializable{
 
	private static final long serialVersionUID = 1L;

	private Integer userId;

	private String userName;

    private String userLogin;

    private String userPasswd;

    public Integer getUserId() {
        return userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin == null ? null : userLogin.trim();
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd == null ? null : userPasswd.trim();
    }

  
	public String toString() {
		return "Userinfo [userId=" + userId + ", userName=" + userName + ", userLogin=" + userLogin + ", userPasswd="
				+ userPasswd + "]";
	}
}