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
	public int login(String user,String password){
		int flag = uerDao.login(user,password);
		return flag;
	}
	/*
	 * �����û�����������
	 */
	public void input(Info_Data info_Data){
		uerDao.input(info_Data);
	}
}
