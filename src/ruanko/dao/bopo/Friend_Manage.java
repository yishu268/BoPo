package ruanko.dao.bopo;

import ruanko.model.bopo.Info_Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Friend_Manage implements Friend_ManageDAO{

	private Info_DBHelper iHelper = null;
	private Friend_DBHelper fHelper = null;
	
	/*
	 * ���췽��
	 */
	public Friend_Manage(Context context) {
		iHelper = new Info_DBHelper(context);
		fHelper = new Friend_DBHelper(context);
	}
	/*
	 * ��������������
	 */
	@Override
	public int name(String name) {
		if (name.equals("")||name == null) {
			return 0;
		}
		int id = 0;
		//�õ�һ���ɶ������ݿ�
		SQLiteDatabase db = iHelper.getReadableDatabase();
		//��ѯ�û�����Ӧ������
		String sql = "select *from info where name = ?";
		String params[] = new String[]{name};
		Cursor cursor = db.rawQuery(sql, params);
		//����ѯ�����������õ�Friend_Info��Ӧ��������
		while(cursor.moveToNext()){
			id = cursor.getInt(0);
		}
		//�رղ�ѯ�����ݿ�
		cursor.close();
		db.close();
		return id;
	}
	/*
	 * ��Ӻ��ѷ���
	 */
	@Override
	public boolean add(Info_Data info_Data) {
		//�õ�һ����д�����ݿ�
		String test = "remark";
		SQLiteDatabase db = fHelper.getWritableDatabase();
		if (info_Data!=null) {
			//��������ݿ��в��������Ϣ
			String sql = "insert into friend(name, remark) values "
					+"(?,?)";
			Object[] params = new Object[]{info_Data.getName(),test};
			db.execSQL(sql, params);
			db.close();
			return true;
		}else{
			return false;
		}
	}
	/*
	 * ͨ��id�����Ϣ�ķ���
	 */
	@Override
	public Info_Data getId(int id) {
		Info_Data info_Data = null;
		if (id > 0) {
			//�õ�һ���ɶ������ݿ�
			SQLiteDatabase db = iHelper.getReadableDatabase();
			String sql = "select *from info where _id = ?";
			String[] params = new String[]{String.valueOf(id)}; 
			Cursor cursor = db.rawQuery(sql,params);
			//����cursor���в�ѯ�����������õ�info_Data��Ӧ��������
			if (cursor.moveToNext()) {
				info_Data = new Info_Data();
				info_Data.setId(cursor.getInt(0));
				info_Data.setName(cursor.getString(1));
				info_Data.setMail(cursor.getString(3));
				info_Data.setNode_id(cursor.getInt(4));
				info_Data.setImage(cursor.getString(5));				
			}
			//�رղ�ѯ �ر����ݿ�
			cursor.close();
			db.close();
		}
		return info_Data;
	}
}
