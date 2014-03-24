package ruanko.service.bopo;

import android.content.Context;

import ruanko.dao.bopo.Friend_Manage;
import ruanko.dao.bopo.Friend_ManageDAO;

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
}
