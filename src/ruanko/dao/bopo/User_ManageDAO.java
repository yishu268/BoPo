package ruanko.dao.bopo;

import ruanko.model.bopo.Info_Data;

//×¢²á½Ó¿Ú
public interface User_ManageDAO {
	
	public int login(String user,String password);
	
	public boolean register(Info_Data info_Data);
		
	public void find_password();
	
	public boolean update(Info_Data info_Data);
	
	public void input(Info_Data info_Data);
	
	public boolean check(String name);
	
	public String head(int id);
}
