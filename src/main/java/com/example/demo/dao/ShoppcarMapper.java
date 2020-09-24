package com.example.demo.dao;

import java.util.List;

import com.example.demo.pojo.Shoppcar;

public interface ShoppcarMapper {
    int deleteByPrimaryKey(Integer shoppcarId);

    int insert(Shoppcar record);

    int insertSelective(Shoppcar record);

    Shoppcar selectByPrimaryKey(Integer shoppcarId);

    int updateByPrimaryKeySelective(Shoppcar record);

    int updateByPrimaryKey(Shoppcar record);
    
    List<Shoppcar> shoppcarList(Integer stuId);
}