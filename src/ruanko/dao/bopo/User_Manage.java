package ruanko.dao.bopo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import ruanko.model.bopo.Info_Data;

public class User_Manage implements User_ManageDAO{
	
	private Info_DBHelper iHelper = null;
	private Friend_DBHelper fHelper = null;
	//private Info_Test_DBHelper tHelper = null;
	
	private String pass = "";
	private int id = 0;
	//private Data data = null;
	
	/*
	 * ���췽��
	 */
	public User_Manage(Context context){
		iHelper = new Info_DBHelper(context);
		fHelper = new Friend_DBHelper(context);
		//tHelper = new Info_Test_DBHelper(context);
	}
	
	/*
	 * �û���¼����
	 */
	@Override
	public int login(String user,String password) {

		if (password.equals("")||password == null) {
			return 0;
		}
		//�õ�һ���ɶ������ݿ�
		SQLiteDatabase db = iHelper.getReadableDatabase();
		//��ѯ�û�����Ӧ������
		String sql = "select *from info where name = ?";
		String params[] = new String[]{user};
		Cursor cursor = db.rawQuery(sql, params);
		while(cursor.moveToNext()){
			id = cursor.getInt(0);
			pass = cursor.getString(2).toString();
		}
		cursor.close();
		db.close();
		//Log.i("test", pass);
		//������֤
		if (pass.equals(password)) {
			return id;
		}else {
			return 0;
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
			String image = "0";
			//�������Ϣ���ݿ��в��������Ϣ
			String sql = "insert into info(name, password, mail, image) values "
					+"(?,?,?,?)";
			Object[] params = new Object[]{info_Data.getName(),
					info_Data.getPassword(),info_Data.getMail(),image};
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
	public boolean update(Info_Data info_Data) {
		if(info_Data != null){
			//�õ�һ����д�����ݿ�
			SQLiteDatabase db = iHelper.getWritableDatabase();
			//�޸����ݱ��ж�Ӧ����ϵ����Ϣ
			String sql ="update info set gender = ?, phone = ?,"
					+"location = ?, birth = ?, age = ?, image = ?,"
					+"mail = ? where _id = ?"					;
			Object[] params = new Object[]{info_Data.getGender(),
					info_Data.getPhone(),info_Data.getLocation(),
					info_Data.getBirth(),info_Data.getAge(),info_Data.getImage(),
					info_Data.getMail(),info_Data.getId()};
			db.execSQL(sql, params);
			db.close();
			
			SQLiteDatabase db1 = fHelper.getWritableDatabase();
			//�޸����ݱ��ж�Ӧ����ϵ����Ϣ
			String sql1 ="update friend set image = ?"					;
			Object[] params1 = new Object[]{info_Data.getImage()};
			db1.execSQL(sql1, params1);
			db1.close();
			return true;
		}else {
			return false;
		}
		// TODO Auto-generated method stub
		
	}
	/*
	 * �����û�����������
	 */
	@Override
	public void input(Info_Data info_Data) {
		//�õ�һ����д�����ݿ�
		SQLiteDatabase db = iHelper.getWritableDatabase();
		//�������Ϣ���ݿ��в��������Ϣ
		String sql = "insert into info_test(name, password, mail, gender,"
				+"phone, image, location, age, birth) values "
				+"(?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[]{info_Data.getName(),
				info_Data.getPassword(),info_Data.getMail(),
				info_Data.getGender(),info_Data.getPhone(),
				info_Data.getImage(),info_Data.getLocation(),
				info_Data.getAge(),info_Data.getBirth()};
		db.execSQL(sql, params);
		//�ر����ݿ�
		db.close();
	}
	/*
	 * ���ע���Ƿ�����
	 */
	@Override
	public boolean check(String name) {
		//���һ���ɶ������ݿ�
		if (name == null||name.equals("")) {
			return true;
		}
		
		String namex = null;
		SQLiteDatabase db = iHelper.getReadableDatabase();
		String sql = "select *from info where name = ?";
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

	@Override
	public String head(int id) {
		if (id != 0) {
			String head = "";
			SQLiteDatabase db = iHelper.getReadableDatabase();
			String sql = "select *from info where _id = ?";
			String[] params = new String[]{String.valueOf(id)};
			Cursor cursor = db.rawQuery(sql, params);
			while (cursor.moveToNext()) {
				head = cursor.getString(6);				
			}
			return head;
		}else {
			return null;
		}
	}
}
