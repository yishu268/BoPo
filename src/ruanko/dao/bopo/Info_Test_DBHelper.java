package ruanko.dao.bopo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Info_Test_DBHelper extends SQLiteOpenHelper{
	
	public static final String FRIEND_NAME = "Info_Test.db";
	private static final int VERSION = 1;

	public Info_Test_DBHelper(Context context) {
		super(context, FRIEND_NAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//创建一张表 存储用户信息
		String sql = "create table info_test("+"_id integer primary key autoincrement,"
				+"name text,"+"password text,"+"mail text,"+"gender text,"
				+"phone text,"+"image text,"+"location text,"+"age text,"
				+"birth text)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
