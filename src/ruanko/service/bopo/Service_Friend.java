package ruanko.service.bopo;

import java.util.List;

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
	 * ��������������
	 */
	public List<?> condition(String age,String gender,String location){
		List<?> id = fDao.condition(age, gender, location);
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
	/*
	 * ��ʾ���ѷ���
	 */
	public List<?> show(){
		List<?> list = fDao.show();
		return list;
	}
	/*
	 * ��������������
	 */
	public boolean check(String name){
		boolean flag = fDao.check(name);
		return flag;
	}

}
