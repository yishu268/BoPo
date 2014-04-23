package ruanko.dao.bopo;

import java.util.List;

import ruanko.model.bopo.Review_Data;

//×¢²á½Ó¿Ú
public interface Review_ManageDAO {
	public boolean review(Review_Data review_Data);
	
	public String reviewer_name(int id);
	
	public List<?> show1(String node_id);

}