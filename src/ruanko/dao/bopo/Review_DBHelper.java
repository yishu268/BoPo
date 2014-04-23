package ruanko.dao.bopo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Review_DBHelper extends SQLiteOpenHelper {
	public static final String REVIEW_NAME = "Review.db";
	private static final int VERSION = 1;
	
	//构造方法
	public Review_DBHelper(Context context) {
		super(context, REVIEW_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//创建一张表储存回执信息
		String sql = "create table review("+"_id integer primary key autoincrement,"
				+"reviewer_name text,"+"node_id text,"+"review_time,"+"review_info)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}