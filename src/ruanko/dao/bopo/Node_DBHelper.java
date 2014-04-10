package ruanko.dao.bopo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Node_DBHelper extends SQLiteOpenHelper{
	
	public static final String INFO_NAME = "Node.db";
	private static final int VERSION = 1;
	
	public Node_DBHelper(Context context) {
		super(context, INFO_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//创建一张表存储成长记录信息
		String sql = "create table node("+"_id integer primary key autoincrement,"
				+"title text,"+"type text,"+"intext text,"+"date text,"
				+"userid text,"+"reviewid text)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}