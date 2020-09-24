package com.example.demo.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.pojo.Userinfo;
import com.example.demo.util.MD5;

@SpringBootTest
public class UserinfoMapperTest {
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Test
	public void testSelectByNameAndPwd()throws Exception{
		Userinfo userinfo=userinfoMapper.selectByNameAndPwd("zhangsan",MD5.enctypeMD5("haha"+123456));
		System.out.println(userinfo);
	}
}
