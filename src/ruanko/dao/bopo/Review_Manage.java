package ruanko.dao.bopo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import ruanko.model.bopo.Review_Data;

public class Review_Manage implements Review_ManageDAO {
	private Review_DBHelper rHelper = null;
	private Info_DBHelper iHelper = null;
	
	public Review_Manage(Context context){
		rHelper = new Review_DBHelper(context);
		iHelper = new Info_DBHelper(context);
		
	}

	@Override
	public boolean review(Review_Data review_Data) {
		//�õ�һ����д�����ݿ�
				SQLiteDatabase db = rHelper.getWritableDatabase();
				if (review_Data!=null) {
					
					//�������Ϣ���ݿ��в��������Ϣ
					String sql = "insert into review(reviewer_name, node_id, review_time, review_info) values "
							+"(?,?,?,?)";
					Object[] params = new Object[]{review_Data.getReviewer_name(),
							review_Data.getNode_id(),review_Data.getReview_time(),review_Data.getReview_info()};
					db.execSQL(sql, params);
					//�ر����ݿ�
					db.close();
					return true;
				}else {
					return false;
				}		
	}
	
	
	public List<?> show1(String node_id) {
		//���һ���ɶ������ݿ�
		List<Review_Data> list = null;
		SQLiteDatabase db = rHelper.getReadableDatabase();
		String sql = "select *from friend where node_id = ?";
		String[] params = new String[]{node_id};
		Cursor cursor = db.rawQuery(sql, params);
		//����ѯ�Ľ����ӵ���Ӧ������
		list = new ArrayList<Review_Data>();
		while (cursor.moveToNext()) {
			Review_Data review_Data = new Review_Data();
			review_Data.setId(cursor.getInt(0));
			review_Data.setReviewer_name(cursor.getString(1));
			review_Data.setReview_info(cursor.getString(4));
			review_Data.setReview_time(cursor.getString(3));
			list.add(review_Data);
		}
		cursor.close();
		db.close();
		return list;
	}
	
	
	public String reviewer_name(int id) {
		//�õ�һ���ɶ������ݿ�
		String name = null;
		SQLiteDatabase db = iHelper.getReadableDatabase();
		//��ѯ�û���Ӧ���û���
		String sql = "select *from info where _id = ?";
		String[] params = new String[]{String.valueOf(id)};
		Cursor cursor = db.rawQuery(sql, params);
		//����ѯ�����������õ�Review_Add��Ӧ��������
		while(cursor.moveToNext()){
			name = cursor.getString(1);
		}
		//�رղ�ѯ�����ݿ�
		cursor.close();
		db.close();
		return name;
	}

}