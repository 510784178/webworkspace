package com.example.demo.service;



import java.util.List;

import com.example.demo.pojo.College;
import com.example.demo.pojo.Dept;
import com.example.demo.pojo.Goods;
import com.example.demo.pojo.Shoppcar;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.Userinfo;

public interface ICardService {
	 Dept selectDeptByDeptId(Integer deptId);
	 Userinfo selectByNameAndPwd(String uname,String upass);
	 List<Student> listAllStu();
	 Student queryStuBystuId(Integer stuId);
	 List<College> collegeList();
	 boolean updateStu(Student record);
	 boolean addStu(Student record);
	 boolean deleteBystuId(Integer stuId);
	 List<Student> selectByStuName(String stuName);
	 List<Goods> listAllGoods();
	 Goods queryGoodsBygoodsId(Integer goodsId);
	 boolean updateGoods(Goods record);
	 Userinfo updateUserinfo(Userinfo record);
	 boolean addGoods(Goods record);
	 boolean deleteBygoodsId(Integer goodsId);
	 List<Goods> selectByGoodsName(String goodsName);
	 Student selectByLoginAndPwd(String ulogin,String upwd);
	 boolean addShoppcar(Shoppcar record);
	 List<Shoppcar> selectBystuId(Integer stuId);
	 boolean deleteBycarId(Integer carId);
}
