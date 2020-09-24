package com.example.demo.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.pojo.College;

@SpringBootTest
public class CollegeMapperTest {
	@Autowired
	private CollegeMapper collegeMapper;
	@Test
	public void testSelecAllCollege()throws Exception{
		List<College> collegeList=collegeMapper.collegeList();
		for(College college:collegeList) {
			System.out.println(college);
		}
		
	}
	
}
