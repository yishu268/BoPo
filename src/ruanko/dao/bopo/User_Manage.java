package ruanko.dao.bopo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import ruanko.model.bopo.Info_Data;

public class User_Manage implements User_ManageDAO{
	
	private Info_DBHelper iHelper = null;
	private Info_Test_DBHelper tHelper = null;
	
	private String pass = null;
	
	/*
	 * 构造方法
	 */
	public User_Manage(Context context){
		iHelper = new Info_DBHelper(context);
		tHelper = new Info_Test_DBHelper(context);
	}
	
	/*
	 * 用户登录方法
	 */
	@Override
	public boolean login(String user,String password) {
		
		if (user.equals("")||user == null) {
			return false;
		}
		
		//得到一个可读的数据库
		SQLiteDatabase db = iHelper.getReadableDatabase();
		//查询用户名对应的密码
		String sql = "select *from info where name = ?";
		String params[] = new String[]{user};
		Cursor cursor = db.rawQuery(sql, params);
		while(cursor.moveToNext()){
			pass = cursor.getString(2).toString();
		}
		cursor.close();
		db.close();
		Log.i("test", pass);
		//密码验证
		if (pass.equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * 用户注册方法
	 */
	@Override
	public boolean register(Info_Data info_Data) {
		//得到一个可写的数据库
		SQLiteDatabase db = iHelper.getWritableDatabase();
		if (info_Data!=null) {
			//
			//向个人信息数据库中插入个人信息
			String sql = "insert into info(name, password, mail) values "
					+"(?,?,?)";
			Object[] params = new Object[]{info_Data.getName(),
					info_Data.getPassword(),info_Data.getMail()};
			db.execSQL(sql, params);
			//关闭数据库
			db.close();
			return true;
		}else {
			return false;
		}		
	}
	
	/*
	 * 找回密码方法
	 */
	@Override
	public void find_password() {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * 用户信息修改方法
	 */
	@Override
	public void info_change() {
		// TODO Auto-generated method stub
		
	}
	/*
	 * 输入用户测试用数据
	 */
	@Override
	public void input(Info_Data info_Data) {
		//得到一个可写的数据库
		SQLiteDatabase db = tHelper.getWritableDatabase();
		//向个人信息数据库中插入个人信息
		String sql = "insert into info_test(name, password, mail, gender,"
				+"phone, image, location, age, birth) values "
				+"(?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[]{info_Data.getName(),
				info_Data.getPassword(),info_Data.getMail(),
				info_Data.getGender(),info_Data.getPhone(),
				info_Data.getImage(),info_Data.getLocation(),
				info_Data.getAge(),info_Data.getBirth()};
		db.execSQL(sql, params);
		//关闭数据库
		db.close();
	}

}
