package ruanko.service.bopo;

import android.content.Context;
import ruanko.dao.bopo.User_Manage;
import ruanko.dao.bopo.User_ManageDAO;
import ruanko.model.bopo.Info_Data;

public class Service_User {
	
	//声明User_ManageDAO
	private User_ManageDAO uerDao = null;	
	
	public Service_User(Context context){
		//实例化User_Manage对象
		uerDao = new User_Manage(context);
	}
	
	/*
	 * 注册用户的方法
	 * Info_Data 用户信息对象
	 */
	public boolean register(Info_Data info_Data) {
		boolean flag = uerDao.register(info_Data);
		return flag;
	}
	
	/*
	 * 注册用户的方法
	 * Info_Data 用户信息对象
	 */
	public boolean login(String user,String password){
		boolean flag = uerDao.login(user,password);
		return flag;
	}
}
