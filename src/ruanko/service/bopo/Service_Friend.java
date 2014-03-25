package ruanko.service.bopo;

import android.content.Context;

import ruanko.dao.bopo.Friend_Manage;
import ruanko.dao.bopo.Friend_ManageDAO;
import ruanko.model.bopo.Info_Data;

public class Service_Friend {
	
	//声明Friend_ManageDAO
	private Friend_ManageDAO fDao = null;
	
	public Service_Friend(Context context){
		//实例化Friend_Manage对象
		fDao = new Friend_Manage(context);
	}
	
	/*
	 * 按用户名搜索方法
	 */
	public int name(String name) {
		int id = fDao.name(name);
		return id;
	}
	/*
	 * 添加好友方法
	 */
	public boolean add(Info_Data info_Data){
		boolean flag = fDao.add(info_Data);
		return flag;		
	}
	/*
	 * 通过id获得信息的方法
	 */
	public Info_Data getId(int id) {
		Info_Data info_Data = fDao.getId(id);
		return info_Data;
	}
}
