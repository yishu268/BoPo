package ruanko.dao.bopo;

import java.util.List;

import ruanko.model.bopo.Info_Data;

//���ѹ���ӿ�
public interface Friend_ManageDAO {
	
	public List<?> condition(String age,String gender,String location);
	
	public int name(String name);
	
	public boolean add(Info_Data info_Data);
	
	public Info_Data getId(int id);
	
}
