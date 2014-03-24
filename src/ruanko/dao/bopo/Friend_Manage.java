package ruanko.dao.bopo;

import java.util.ArrayList;
import java.util.List;

import ruanko.model.bopo.Friend_Info_Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Friend_Manage implements Friend_ManageDAO{

	private Info_DBHelper helper = null;
	
	/*
	 * ���췽��
	 */
	public Friend_Manage(Context context) {
		helper = new Info_DBHelper(context);
	}

	@Override
	public int name(String name) {
		if (name.equals("")||name == null) {
			return 0;
		}
		List<Friend_Info_Data> list = null;
		int id = 0;
		//�õ�һ���ɶ������ݿ�
		SQLiteDatabase db = helper.getReadableDatabase();
		//��ѯ�û�����Ӧ������
		String sql = "select *from info where name = ?";
		String params[] = new String[]{name};
		Cursor cursor = db.rawQuery(sql, params);
		list = new ArrayList<Friend_Info_Data>();
		//����ѯ�����������õ�Friend_Info��Ӧ��������
		while(cursor.moveToNext()){
			Friend_Info_Data friend_Info_Data = new Friend_Info_Data();
			friend_Info_Data.setId(cursor.getInt(0));
			friend_Info_Data.setName(cursor.getString(1));
			friend_Info_Data.setMail(cursor.getString(3));
			friend_Info_Data.setNode_id(cursor.getString(4));
			friend_Info_Data.setImage(cursor.getString(5));
			list.add(friend_Info_Data);
			id = cursor.getInt(0);
		}
		//�رղ�ѯ�����ݿ�
		cursor.close();
		db.close();
		return id;
	}

}
