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
		//得到一个可写的数据库
				SQLiteDatabase db = rHelper.getWritableDatabase();
				if (review_Data!=null) {
					
					//向个人信息数据库中插入个人信息
					String sql = "insert into review(reviewer_name, node_id, review_time, review_info) values "
							+"(?,?,?,?)";
					Object[] params = new Object[]{review_Data.getReviewer_name(),
							review_Data.getNode_id(),review_Data.getReview_time(),review_Data.getReview_info()};
					db.execSQL(sql, params);
					//关闭数据库
					db.close();
					return true;
				}else {
					return false;
				}		
	}
	
	
	public List<?> show1(String node_id) {
		//获得一个可读的数据库
		List<Review_Data> list = null;
		SQLiteDatabase db = rHelper.getReadableDatabase();
		String sql = "select *from friend where node_id = ?";
		String[] params = new String[]{node_id};
		Cursor cursor = db.rawQuery(sql, params);
		//将查询的结果添加到对应属性上
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
		//得到一个可读的数据库
		String name = null;
		SQLiteDatabase db = iHelper.getReadableDatabase();
		//查询用户对应的用户名
		String sql = "select *from info where _id = ?";
		String[] params = new String[]{String.valueOf(id)};
		Cursor cursor = db.rawQuery(sql, params);
		//将查询到的数据设置到Review_Add对应的属性中
		while(cursor.moveToNext()){
			name = cursor.getString(1);
		}
		//关闭查询和数据库
		cursor.close();
		db.close();
		return name;
	}

}