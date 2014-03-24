package ruanko.service.bopo;

import android.content.Context;
import ruanko.dao.bopo.User_Manage;
import ruanko.dao.bopo.User_ManageDAO;
import ruanko.model.bopo.Info_Data;

public class Service_User {
	
	//����User_ManageDAO
	private User_ManageDAO uerDao = null;	
	
	public Service_User(Context context){
		//ʵ����User_Manage����
		uerDao = new User_Manage(context);
	}
	
	/*
	 * ע���û��ķ���
	 * Info_Data �û���Ϣ����
	 */
	public boolean register(Info_Data info_Data) {
		boolean flag = uerDao.register(info_Data);
		return flag;
	}
	
	/*
	 * ע���û��ķ���
	 * Info_Data �û���Ϣ����
	 */
	public boolean login(String user,String password){
		boolean flag = uerDao.login(user,password);
		return flag;
	}
}
