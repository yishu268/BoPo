package ruanko.dao.bopo;

import ruanko.model.bopo.Info_Data;

//���ѹ���ӿ�
public interface Friend_ManageDAO {
	
	public int name(String name);
	
	public boolean add(Info_Data info_Data);
	
	public Info_Data getId(int id);
	
}
