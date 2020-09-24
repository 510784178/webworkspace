package com.example.demo.dao;

import java.util.List;


import com.example.demo.pojo.Goods;


public interface GoodsMapper {
	List<Goods> listAllGoods();
	
	List<Goods> selectByGoodsName(String goodsName);
	
	String queryMaxGoodsNo(String prefix);
	
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}