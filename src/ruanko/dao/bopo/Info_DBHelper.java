package ruanko.dao.bopo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Info_DBHelper extends SQLiteOpenHelper{
	
	public static final String INFO_NAME = "Info.db";
	private static final int VERSION = 1;
	
	//���췽��
	public Info_DBHelper(Context context) {
		super(context,INFO_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//����һ�ű� �洢�û���Ϣ
		String sql = "create table info("+"_id integer primary key autoincrement,"
				+"name text,"+"password text,"+"mail text,"+"gender text,"
				+"phone text,"+"image text,"+"location text,"+"age text,"
				+"birth text,"+"node_id text)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
