package com.example.demo.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.pojo.Student;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.example.demo.pojo.Dept;
import com.example.demo.service.ICardService;
import com.example.demo.util.MD5;

@RestController//相当于@Controller+@ResponseBody
@RequestMapping("/card")
@CrossOrigin(allowCredentials="true", allowedHeaders="*")
public class StuController {
	@Autowired
	private ICardService cardService;
	@RequestMapping(path="/stulogin",method= {RequestMethod.GET,RequestMethod.POST})
	public  boolean verifyLogin(@RequestBody Student student,HttpSession session) {
		Boolean rt=false;
		Student stu=cardService.selectByLoginAndPwd(student.getStuLogin(), student.getStuPasswd());
		if(stu!=null) {
			session.setAttribute("stu", stu);
			rt=true;
		}
		return rt;
	}
	@RequestMapping(path="/stuname",method= {RequestMethod.GET,RequestMethod.POST})
	public  String getStuName(HttpSession session) {
		Student student=(Student)session.getAttribute("stu");
		if(student!=null) {
			return student.getStuName();
		}
		return null;
	}
	@RequestMapping(path="/stulist",method= {RequestMethod.GET,RequestMethod.POST})
	public  List<Student> listStu(HttpSession session) {
		List<Student> stuList=cardService.listAllStu();
		return stuList;	
	}
	@RequestMapping(path="/querystu",method= {RequestMethod.GET,RequestMethod.POST})
	public Student queryStudent (Integer stuId) {
		return cardService.queryStuBystuId(stuId);
	}
	@RequestMapping(path="/savestu",method= {RequestMethod.GET,RequestMethod.POST})
	public Boolean saveStudent (@RequestBody Student student) {
			return cardService.updateStu(student);	
	}
	@RequestMapping(path="/addstu",method= {RequestMethod.GET,RequestMethod.POST})
	public Boolean addStudent (@RequestBody Student student) {
		return cardService.addStu(student);
	}
	@RequestMapping(path="/delestu",method= {RequestMethod.GET,RequestMethod.POST})
	public Boolean deleStudent (Integer stuId) {
		return cardService.deleteBystuId(stuId);
	}
	@RequestMapping(path="/deleAllstu",method= {RequestMethod.GET,RequestMethod.POST})
	public Boolean deleAllStudent (Integer[] id) {
		boolean rt=false;
		for(Integer stuId:id) {
			rt=cardService.deleteBystuId(stuId);
		}
		return rt;
	}
	@RequestMapping(path="/querystuName",method= {RequestMethod.GET,RequestMethod.POST})
	public List<Student> queryStudent (String stuName) {
		return cardService.selectByStuName(stuName);
	}
	@RequestMapping(path="/editpwd",method= {RequestMethod.GET,RequestMethod.POST})
	public  Boolean modifyPwd(String  oldPasswd,String newPasswd,HttpSession session) {
		boolean rt=false;
		Student student=(Student)session.getAttribute("stu");
		String oldPwd=student.getStuPasswd();
		String oldPasswd1=MD5.enctypeMD5("haha"+oldPasswd);
		if(oldPwd.equals(oldPasswd1)){
			String newPwd=MD5.enctypeMD5("haha"+newPasswd);
			student.setStuPasswd(newPwd);
			if(cardService.updateStu(student)) {
				Student	stu=cardService.queryStuBystuId(student.getStuId());
				if(stu!=null){
					rt=true;
					session.invalidate();//强制失效
				}
			};	
		}	
		return rt;
	}
	

}
