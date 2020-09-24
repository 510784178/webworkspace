package com.example.demo.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.pojo.Dept;

@SpringBootTest
public class DeptMapperTest {
	@Autowired
	private DeptMapper deptMapper;
	@Test
	public void testSelectByPrimaryKey()throws Exception{
		Dept dept=deptMapper.selectByPrimaryKey(1);
		System.out.println(dept);
	}
	
}
