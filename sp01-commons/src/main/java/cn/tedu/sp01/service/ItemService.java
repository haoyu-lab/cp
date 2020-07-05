package cn.tedu.sp01.service;

import java.util.List;

import cn.tedu.sp01.pojo.Item;

public interface ItemService {
	//根据订单号，获取订单商品列表
	List<Item> getItems(String orderId);
	
	//减少商品库存
	void decreaseNumber(List<Item> items);
}
