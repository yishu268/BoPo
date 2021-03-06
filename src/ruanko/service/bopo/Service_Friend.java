package ruanko.service.bopo;

import java.util.List;

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
	 * 按条件搜索方法
	 */
	public List<?> condition(String age,String gender,String location){
		List<?> id = fDao.condition(age, gender, location);
		return id;
	}
	/*
	 * 添加好友方法
	 */
	public boolean add(Info_Data info_Data,int userid,int friendid){
		boolean flag = fDao.add(info_Data,userid,friendid);
		return flag;		
	}
	/*
	 * 通过id获得信息的方法
	 */
	public Info_Data getId(int id) {
		Info_Data info_Data = fDao.getId(id);
		return info_Data;
	}
	/*
	 * 显示好友方法
	 */
	public List<?> show(int id){
		List<?> list = fDao.show(id);
		return list;
	}
	/*
	 * 检测好友重名方法
	 */
	public boolean check(String name,int id){
		boolean flag = fDao.check(name,id);
		return flag;
	}
	public boolean delete(int userid,int friendid){
		boolean flag = fDao.delete(userid, friendid);
		return flag;
	}

}
