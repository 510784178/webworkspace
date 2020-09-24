package com.example.demo.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Userinfo;
import com.example.demo.service.ICardService;
import com.example.demo.util.MD5;

@RestController//相当于@Controller+@ResponseBody
@RequestMapping("/card")
@CrossOrigin(allowCredentials="true", allowedHeaders="*")
public class UserinfoController {
	@Autowired
	private ICardService cardService;
	@RequestMapping(path="/login",method= {RequestMethod.GET,RequestMethod.POST})
	public  boolean verifyLogin(@RequestBody Userinfo userinfo,HttpSession session) {
		Boolean rt=false;
		Userinfo user=cardService.selectByNameAndPwd(userinfo.getUserLogin(), userinfo.getUserPasswd());
		if(user!=null) {
			session.setAttribute("user", user);
			rt=true;
		}
		return rt;
	}
	@RequestMapping(path="/username",method= {RequestMethod.GET,RequestMethod.POST})
	public  String getUserName(HttpSession session) {
		Userinfo user=(Userinfo)session.getAttribute("user");
		if(user!=null) {
			return user.getUserName();
		}
		return null;
	}
	@RequestMapping(path="/modifypwd",method= {RequestMethod.GET,RequestMethod.POST})
	public  Boolean modifyPwd(String  oldPasswd,String newPasswd,HttpSession session) {
		boolean rt=false;
		Userinfo userInfo = (Userinfo)session.getAttribute("user");
		String oldPwd=userInfo.getUserPasswd();
		String oldPasswd1=MD5.enctypeMD5("haha"+oldPasswd);
		if(oldPwd.equals(oldPasswd1)){
			String newPwd=MD5.enctypeMD5("haha"+newPasswd);
			userInfo.setUserPasswd(newPwd);
			Userinfo user=cardService.updateUserinfo(userInfo);
			if(user!=null){
				rt=true;
				session.invalidate();//强制失效
			}
		}	
		return rt;
	}
}
