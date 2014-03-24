package ruanko.service.bopo;

import android.content.Context;

import ruanko.dao.bopo.Friend_Manage;
import ruanko.dao.bopo.Friend_ManageDAO;

public class Service_Friend {
	
	//����Friend_ManageDAO
	private Friend_ManageDAO fDao = null;
	
	public Service_Friend(Context context){
		//ʵ����Friend_Manage����
		fDao = new Friend_Manage(context);
	}
	
	/*
	 * ���û�����������
	 */
	public int name(String name) {
		int id = fDao.name(name);
		return id;
	}
}
