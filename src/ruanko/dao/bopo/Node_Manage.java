package ruanko.dao.bopo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import ruanko.model.bopo.Line_Data;
import ruanko.model.bopo.Node_Data;

public class Node_Manage implements Node_ManageDAO{

	private Node_DBHelper nHelper = null;
	/*
	 * ���췽��
	 */
	public Node_Manage(Context context){
		nHelper = new Node_DBHelper(context);
	}
	/*
	 * ����name��ȡ���ѳɳ���
	 */
	public List<?> line(int id){
		//���һ���ɶ������ݿ�
		SQLiteDatabase db = nHelper.getReadableDatabase();		
		List<Line_Data> list = null;
		if (id != 0){
			String sql = "select *from node where userid = ? order by date";
			String[] params = new String[]{String.valueOf(id)};
			Cursor cursor = db.rawQuery(sql, params);
			list = new ArrayList<Line_Data>();
			while (cursor.moveToNext()) {
				Line_Data line_Data = new Line_Data();
				line_Data.setNodeid(cursor.getInt(0));
				line_Data.setTitle(cursor.getString(1));
				list.add(line_Data);
			}
			cursor.close();
			db.close();
			return list;
		}else {
			return null;
		}
	}
	/*
	 * ����id��ȡ�ɳ���¼��Ϣ
	 */
	public Node_Data show(int id){
		//���һ���ɶ������ݿ�
		SQLiteDatabase db = nHelper.getReadableDatabase();
		if (id != 0) {
			Node_Data node_Data = new Node_Data();
			String sql = "select *from node where _id = ?";
			String[] params = new String[]{String.valueOf(id)};
			Cursor cursor = db.rawQuery(sql, params);
			while (cursor.moveToNext()) {
				node_Data.setId(cursor.getInt(0));		
				node_Data.setTitle(cursor.getString(1));
				node_Data.setType(cursor.getString(2));
				node_Data.setText(cursor.getString(3));
				node_Data.setDate(cursor.getString(4));
				node_Data.setReview_id(cursor.getString(6));
			}
			return node_Data;
		}else {
			return null;
		}		
	}
	/*
	 * �����û�����������
	 */
	@Override
	public void input(Node_Data node_Data) {
		//�õ�һ����д�����ݿ�
		SQLiteDatabase db = nHelper.getWritableDatabase();
		//�������Ϣ���ݿ��в��������Ϣ
		String sql = "insert into node(title, type, intext, date,"
				+"userid, reviewid) values "
				+"(?,?,?,?,?,?)";
		Object[] params = new Object[]{node_Data.getTitle(),node_Data.getType(),
				node_Data.getText(),node_Data.getDate(),node_Data.getUser_id(),
				node_Data.getReview_id()};
		db.execSQL(sql, params);
		//�ر����ݿ�
		db.close();
	}
	public void delete(){
		SQLiteDatabase db = nHelper.getWritableDatabase();
		String sql = "delete from node";
		db.execSQL(sql);
		db.close();
	}
}
