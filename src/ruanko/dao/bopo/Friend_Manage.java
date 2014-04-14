package ruanko.dao.bopo;

import java.util.ArrayList;
import java.util.List;

import ruanko.model.bopo.Friend_Data;
import ruanko.model.bopo.Info_Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Friend_Manage implements Friend_ManageDAO{

	private Info_DBHelper iHelper = null;
	private Friend_DBHelper fHelper = null;
	//��������
	//private Info_Test_DBHelper tHelper = null;
	
	/*
	 * ���췽��
	 */
	public Friend_Manage(Context context) {
		iHelper = new Info_DBHelper(context);
		fHelper = new Friend_DBHelper(context);
		
		//tHelper = new Info_Test_DBHelper(context);
	}
	/*
	 * ��������������
	 */
	@Override
	public int name(String name) {
		if (name.equals("")||name == null) {
			return -1;
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
	 * ����������
	 */
	@Override
	public List<String> condition(String age, String gender, String location) {
		if (age.equals("")||age == null) {
			return null;
		}
		List<String> list = null;
		//int[] id = new int[10];
		int i = 0;
		//�õ�һ���ɶ������ݿ�
		SQLiteDatabase db = iHelper.getReadableDatabase();
		//��������ѯ
		String sql = "select *from info where age = ? and gender = ? and location = ?";
		String params[] = new String[]{age,gender,location};
		Cursor cursor = db.rawQuery(sql, params);
		//����ѯ�����������õ�������
		
		list = new ArrayList<String>();
		
		while (cursor.moveToNext()) {
			i = cursor.getInt(0);
			String s = "";
			s = String.valueOf(i);
			list.add(s);
		}
		//�رղ�ѯ�����ݿ�
		cursor.close();
		db.close();
		return list;
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
		if (id != 0) {
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
					info_Data.setGender(cursor.getString(4));
					info_Data.setPhone(cursor.getString(5));
					info_Data.setImage(cursor.getString(6));
					info_Data.setLocation(cursor.getString(7));
					info_Data.setAge(cursor.getString(8));
					info_Data.setBirth(cursor.getString(9));
				}
				//�رղ�ѯ �ر����ݿ�
				cursor.close();
				db.close();
			}
			return info_Data;
		}else {
			return null;
		}
	}
	@Override
	public List<?> show() {
		//���һ���ɶ������ݿ�
		List<Friend_Data> list = null;
		SQLiteDatabase db = fHelper.getReadableDatabase();
		String sql = "select *from friend";
		Cursor cursor = db.rawQuery(sql, null);
		//����ѯ�Ľ����ӵ���Ӧ������
		list = new ArrayList<Friend_Data>();
		while (cursor.moveToNext()) {
			Friend_Data friend_Data = new Friend_Data();
			friend_Data.setId(cursor.getInt(0));
			friend_Data.setName(cursor.getString(1));
			list.add(friend_Data);
		}
		cursor.close();
		db.close();
		return list;
	}
	/*
	 * ����������
	 */
	@Override
	public boolean check(String name) {
		//�õ�һ���ɶ������ݿ�
		if (name == null||name.equals("")) {
			return true;
		}
		String namex = null;
		SQLiteDatabase db = fHelper.getReadableDatabase();
		String sql = "select *from friend where name = ?";
		String[] params = new String[]{name};
		Cursor cursor = db.rawQuery(sql, params);
		while (cursor.moveToNext()) {
			namex = cursor.getString(1);	
		}
		if (namex == null||namex.equals("")) {
			return true;
		}else {
			return false;
		}
	}
}
