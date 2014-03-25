package ruanko.service.bopo;

import android.content.Context;

import ruanko.dao.bopo.Friend_Manage;
import ruanko.dao.bopo.Friend_ManageDAO;
import ruanko.model.bopo.Info_Data;

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
	/*
	 * ��Ӻ��ѷ���
	 */
	public boolean add(Info_Data info_Data){
		boolean flag = fDao.add(info_Data);
		return flag;		
	}
	/*
	 * ͨ��id�����Ϣ�ķ���
	 */
	public Info_Data getId(int id) {
		Info_Data info_Data = fDao.getId(id);
		return info_Data;
	}
}
