package ruanko.dao.bopo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import ruanko.model.bopo.Info_Data;

public class User_Manage implements User_ManageDAO{
	
	private Info_DBHelper iHelper = null;
	
	private String pass = null;
	
	/*
	 * ���췽��
	 */
	public User_Manage(Context context){
		iHelper = new Info_DBHelper(context);
	}
	
	/*
	 * �û���¼����
	 */
	@Override
	public boolean login(String user,String password) {
		
		if (user.equals("")||user == null) {
			return false;
		}
		
		//�õ�һ���ɶ������ݿ�
		SQLiteDatabase db = iHelper.getReadableDatabase();
		//��ѯ�û�����Ӧ������
		String sql = "select *from info where name = ?";
		String params[] = new String[]{user};
		Cursor cursor = db.rawQuery(sql, params);
		while(cursor.moveToNext()){
			pass = cursor.getString(2).toString();
		}
		cursor.close();
		db.close();
		Log.i("test", pass);
		//������֤
		if (pass.equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * �û�ע�᷽��
	 */
	@Override
	public boolean register(Info_Data info_Data) {
		//�õ�һ����д�����ݿ�
		SQLiteDatabase db = iHelper.getWritableDatabase();
		if (info_Data!=null) {
			//
			//�������Ϣ���ݿ��в��������Ϣ
			String sql = "insert into info(name, password, mail) values "
					+"(?,?,?)";
			Object[] params = new Object[]{info_Data.getName(),
					info_Data.getPassword(),info_Data.getMail()};
			db.execSQL(sql, params);
			//�ر����ݿ�
			db.close();
			return true;
		}else {
			return false;
		}		
	}
	
	/*
	 * �һ����뷽��
	 */
	@Override
	public void find_password() {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * �û���Ϣ�޸ķ���
	 */
	@Override
	public void info_change() {
		// TODO Auto-generated method stub
		
	}

}
