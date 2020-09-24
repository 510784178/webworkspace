package com.example.demo.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CollegeMapper;
import com.example.demo.dao.DeptMapper;
import com.example.demo.dao.GoodsMapper;
import com.example.demo.dao.ShoppcarMapper;
import com.example.demo.dao.StudentMapper;
import com.example.demo.dao.UserinfoMapper;

import com.example.demo.pojo.College;
import com.example.demo.pojo.Dept;
import com.example.demo.pojo.Goods;
import com.example.demo.pojo.Shoppcar;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.Userinfo;
import com.example.demo.util.MD5;
@Service
public class CardServiceImpl  implements ICardService{
	@Autowired
	private DeptMapper deptMapper;
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private CollegeMapper collegeMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private ShoppcarMapper shoppcarMapper;
	
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public Dept selectDeptByDeptId(Integer deptId) {
		return deptMapper.selectByPrimaryKey(deptId);
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public Userinfo selectByNameAndPwd(String uname, String upass) {
		return userinfoMapper.selectByNameAndPwd(uname, MD5.enctypeMD5("haha"+upass));
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<Student> listAllStu() {
		return studentMapper.listAllStu();
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public Student queryStuBystuId(Integer stuId) {
		return studentMapper.selectByPrimaryKey(stuId);
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<College> collegeList() {
		return collegeMapper.collegeList();
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public boolean updateStu(Student record) {
		return studentMapper.updateByPrimaryKeySelective(record)>0 ;
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public boolean addStu(Student record) {
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;
		String monthStr=("0"+month).substring(month>=10?1:0);
		String prefix="STU"+year+monthStr;//结果:STU202008
		String maxStuNo=studentMapper.queryMaxStuNoByMonth(prefix+"%");
		if(maxStuNo==null){//是本月的第一个
			record.setStuNo(prefix+"001");	
		}else{//不是第一个
			String newNo=Integer.parseInt(maxStuNo.substring(maxStuNo.length()-3))+1+"";
			String stuNo=prefix+("00"+newNo).substring(newNo.length()-1);
			record.setStuNo(stuNo);
		}
		//处理姓名
		String maxName=studentMapper.getSameNameMax("^"+record.getStuName()+"[1-9]{0,2}$");
		if(maxName!=null){//存在同名情况
			String newName=record.getStuName()+(Integer.parseInt(maxName.replace(record.getStuName(),"0"))+1);
			record.setStuName(newName);
		}
		String oldpasswd=record.getStuPasswd();
		String newpasswd=MD5.enctypeMD5("haha"+oldpasswd);
		record.setStuPasswd(newpasswd);
		return studentMapper.insertSelective(record)>0;
	}
		
	
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public boolean deleteBystuId(Integer stuId) {
		return studentMapper.deleteByPrimaryKey(stuId)>0;
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<Student> selectByStuName(String stuName) {
		return studentMapper.selectByStuName("%"+stuName+"%");
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<Goods> listAllGoods() {
		return goodsMapper.listAllGoods();
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public Goods queryGoodsBygoodsId(Integer goodsId) {
		return goodsMapper.selectByPrimaryKey(goodsId);
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public boolean updateGoods(Goods record) {
		return goodsMapper.updateByPrimaryKeySelective(record)>0;
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Userinfo updateUserinfo(Userinfo record) {
		Userinfo userinfo=null;
		if(userinfoMapper.updateByPrimaryKeySelective(record)>0) {
			userinfo=userinfoMapper.selectByPrimaryKey(record.getUserId());  
	  }
		return userinfo;
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public boolean addGoods(Goods record) {
		String prefix="Goods";
		String maxGoodsNo=goodsMapper.queryMaxGoodsNo(prefix+"%");
		if(maxGoodsNo==null){//是本月的第一个
			record.setGoodsNo(prefix+"001");	
		}else{//不是第一个
			String newNo=Integer.parseInt(maxGoodsNo.substring(maxGoodsNo.length()-3))+1+"";
			String GoodsNo=prefix+("00"+newNo).substring(newNo.length()-1);
			record.setGoodsNo(GoodsNo);
		}
		return goodsMapper.insertSelective(record)>0;
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public boolean deleteBygoodsId(Integer goodsId) {
		return goodsMapper.deleteByPrimaryKey(goodsId)>0;
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<Goods> selectByGoodsName(String goodsName) {
		return goodsMapper.selectByGoodsName("%"+goodsName+"%");
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public Student selectByLoginAndPwd(String ulogin, String upwd) {
		return studentMapper.selectByLoginAndPwd(ulogin, MD5.enctypeMD5("haha"+upwd));
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public boolean addShoppcar(Shoppcar record) {
		return shoppcarMapper.insertSelective(record)>0;
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<Shoppcar> selectBystuId(Integer stuId) {
		return shoppcarMapper.shoppcarList(stuId);
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public boolean deleteBycarId(Integer carId) {
		return shoppcarMapper.deleteByPrimaryKey(carId)>0;
	}
	

}
