package cn.tedu.sp01.service;

import java.util.List;

import cn.tedu.sp01.pojo.Item;

public interface ItemService {
	//���ݶ����ţ���ȡ������Ʒ�б�
	List<Item> getItems(String orderId);
	
	//������Ʒ���
	void decreaseNumber(List<Item> items);
}
