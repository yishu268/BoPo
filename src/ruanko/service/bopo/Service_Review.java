package ruanko.service.bopo;

import java.util.List;

import ruanko.dao.bopo.Review_Manage;
import ruanko.dao.bopo.Review_ManageDAO;
import ruanko.model.bopo.Review_Data;

import android.content.Context;

public class Service_Review {
//声明Review_ManageDAO
private Review_ManageDAO reviewDao = null;	
	
	public Service_Review(Context context){
		//实例化Review_ManageDAO对象
		reviewDao = new Review_Manage(context);
}
	/*
	 * 发布回执的方法
	 * Review_Data 用户信息对象
	 */
	public boolean review(Review_Data review_Data) {
		boolean flag = reviewDao.review(review_Data);
		return flag;
	}
	public String reviewer_name(int id) {
		String flag = reviewDao.reviewer_name(id);
		return flag;
	}
	/*
	 * 显示评论列表方法
	 */
	public List<?> show1(String node_id){
		List<?> list = reviewDao.show1(node_id);
		return list;
	}
	
}