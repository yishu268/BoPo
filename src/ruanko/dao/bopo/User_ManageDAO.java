package ruanko.dao.bopo;

import ruanko.model.bopo.Info_Data;

//ע��ӿ�
public interface User_ManageDAO {
	
	public int login(String user,String password);
	
	public boolean register(Info_Data info_Data);
		
	public void find_password();
	
	public void info_change();
	
	public void input(Info_Data info_Data);
}
