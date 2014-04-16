package ruanko.dao.bopo;

import java.util.List;

import ruanko.model.bopo.Info_Data;

//好友管理接口
public interface Friend_ManageDAO {
	
	public List<?> condition(String age,String gender,String location);
	
	public int name(String name);
	
	public boolean add(Info_Data info_Data,int userid,int friendid);
	
	public Info_Data getId(int id);
	
	public List<?> show(int id);
	
	public boolean check(String name,int id);
	
}
