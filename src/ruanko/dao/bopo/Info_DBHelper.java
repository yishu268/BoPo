package ruanko.dao.bopo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Info_DBHelper extends SQLiteOpenHelper{
	
	public static final String INFO_NAME = "Info.db";
	private static final int VERSION = 1;
	
	//构造方法
	public Info_DBHelper(Context context) {
		super(context,INFO_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//创建一张表 存储用户信息
		String sql = "create table info("+"_id integer primary key autoincrement,"+"name text,"
				+"password text,"+"mail text,"+"node_id text,"+"image text)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
