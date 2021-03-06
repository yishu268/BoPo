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
	//测试数据
	//private Info_Test_DBHelper tHelper = null;
	
	/*
	 * 构造方法
	 */
	public Friend_Manage(Context context) {
		iHelper = new Info_DBHelper(context);
		fHelper = new Friend_DBHelper(context);
		
		//tHelper = new Info_Test_DBHelper(context);
	}
	/*
	 * 按姓名搜索方法
	 */
	@Override
	public int name(String name) {
		if (name.equals("")||name == null) {
			return -1;
		}
		int id = 0;
		//得到一个可读的数据库
		SQLiteDatabase db = iHelper.getReadableDatabase();
		//查询用户名对应的密码
		String sql = "select *from info where name = ?";
		String params[] = new String[]{name};
		Cursor cursor = db.rawQuery(sql, params);
		//将查询到的数据设置到Friend_Info对应的属性中
		while(cursor.moveToNext()){
			id = cursor.getInt(0);
		}
		//关闭查询和数据库
		cursor.close();
		db.close();
		return id;
	}
	/*
	 * 按条件搜索
	 */
	@Override
	public List<String> condition(String age, String gender, String location) {
		if (age.equals("")||age == null) {
			return null;
		}
		List<String> list = null;
		//int[] id = new int[10];
		int i = 0;
		//得到一个可读的数据库
		SQLiteDatabase db = iHelper.getReadableDatabase();
		//按条件查询
		String sql = "select *from info where age = ? and gender = ? and location = ?";
		String params[] = new String[]{age,gender,location};
		Cursor cursor = db.rawQuery(sql, params);
		//将查询到的数据设置到变量中
		
		list = new ArrayList<String>();
		
		while (cursor.moveToNext()) {
			i = cursor.getInt(0);
			String s = "";
			s = String.valueOf(i);
			list.add(s);
		}
		//关闭查询和数据库
		cursor.close();
		db.close();
		return list;
	}
	/*
	 * 添加好友方法
	 */
	@Override
	public boolean add(Info_Data info_Data,int userid,int friendid) {
		//得到一个可写的数据库
		String test = "remark";
		SQLiteDatabase db = fHelper.getWritableDatabase();
		if (info_Data!=null) {
			//向好友数据库中插入好友信息
			String sql = "insert into friend(image, name, userid, friendid, remark) values "
					+"(?,?,?,?,?)";
			Object[] params = new Object[]{info_Data.getImage(),info_Data.getName(),String.valueOf(userid),String.valueOf(friendid),test};
			db.execSQL(sql, params);
			db.close();
			return true;
		}else{
			return false;
		}
	}
	/*
	 * 通过id获得信息的方法
	 */
	@Override
	public Info_Data getId(int id) {
		if (id != 0) {
			Info_Data info_Data = null;
			if (id > 0) {
				//得到一个可读的数据库
				SQLiteDatabase db = iHelper.getReadableDatabase();
				String sql = "select *from info where _id = ?";
				String[] params = new String[]{String.valueOf(id)}; 
				Cursor cursor = db.rawQuery(sql,params);
				//利用cursor进行查询并将属性设置到info_Data对应的属性中
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
				//关闭查询 关闭数据库
				cursor.close();
				db.close();
			}
			return info_Data;
		}else {
			return null;
		}
	}
	@Override
	public List<?> show(int id) {
		//获得一个可读的数据库
		List<Friend_Data> list = null;
		SQLiteDatabase db = fHelper.getReadableDatabase();
		String sql = "select *from friend where userid = ?";
		String[] params = new String[]{String.valueOf(id)};
		Cursor cursor = db.rawQuery(sql, params);
		//将查询的结果添加到对应属性上
		list = new ArrayList<Friend_Data>();
		while (cursor.moveToNext()) {
			Friend_Data friend_Data = new Friend_Data();
			friend_Data.setId(cursor.getInt(0));
			friend_Data.setImage(cursor.getString(1));
			friend_Data.setName(cursor.getString(2));
			friend_Data.setFriendid(cursor.getInt(4));
			list.add(friend_Data);
		}
		cursor.close();
		db.close();
		return list;
	}
	/*
	 * 
	 */
	public boolean delete(int userid,int friendid){
		if (userid != 0 && friendid != 0) {
			SQLiteDatabase db = fHelper.getWritableDatabase();
			String sql = "delete from friend where userid = ? and friendid = ?";
			//String sql = "delete *from friend where userid = ?";
			String[] params = new String[]{String.valueOf(userid),String.valueOf(friendid)};
			//String[] params = new String[]{String.valueOf(userid)};
			db.execSQL(sql,params);
			db.close();
			return true;
		}else {
			return false;
		}	
	}
	/*
	 * 检测好友重名
	 */
	@Override
	public boolean check(String name,int id) {
		//得到一个可读的数据库
		if (name == null||name.equals("")) {
			return true;
		}
		String namex = null;
		SQLiteDatabase db = fHelper.getReadableDatabase();
		String sql = "select *from friend where name = ? and userid = ?";
		String[] params = new String[]{name,String.valueOf(id)};
		Cursor cursor = db.rawQuery(sql, params);
		while (cursor.moveToNext()) {
			namex = cursor.getString(2);	
		}
		if (namex == null||namex.equals("")) {
			return true;
		}else {
			return false;
		}
	}
}
