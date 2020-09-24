package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Student;


public interface StudentMapper {
	Student selectByLoginAndPwd(@Param("ulogin")String ulogin,@Param("upwd")String upwd);
	
	String  getSameNameMax(String name);
	
	String queryMaxStuNoByMonth(String prefix);
	
	List<Student> listAllStu();
	
    int deleteByPrimaryKey(Integer stuId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stuId);
    
    List<Student>  selectByStuName(String stuName);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}