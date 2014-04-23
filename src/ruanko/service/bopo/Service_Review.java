package ruanko.service.bopo;

import java.util.List;

import ruanko.dao.bopo.Review_Manage;
import ruanko.dao.bopo.Review_ManageDAO;
import ruanko.model.bopo.Review_Data;

import android.content.Context;

public class Service_Review {
//����Review_ManageDAO
private Review_ManageDAO reviewDao = null;	
	
	public Service_Review(Context context){
		//ʵ����Review_ManageDAO����
		reviewDao = new Review_Manage(context);
}
	/*
	 * ������ִ�ķ���
	 * Review_Data �û���Ϣ����
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
	 * ��ʾ�����б���
	 */
	public List<?> show1(String node_id){
		List<?> list = reviewDao.show1(node_id);
		return list;
	}
	
}