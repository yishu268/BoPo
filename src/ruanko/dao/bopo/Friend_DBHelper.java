package ruanko.dao.bopo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Friend_DBHelper extends SQLiteOpenHelper{
	
	public static final String FRIEND_NAME = "Friend.db";
	private static final int VERSION = 1;
	
	//���췽��
	public Friend_DBHelper(Context context) {
		super(context, FRIEND_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//����һ�ű��������Ϣ
		String sql = "create table friend("+"_id integer primary key autoincrement,"
				+"name text,"+"remark text)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
