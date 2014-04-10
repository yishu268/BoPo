package ruanko.service.bopo;

import java.util.List;

import ruanko.dao.bopo.Node_Manage;
import ruanko.dao.bopo.Node_ManageDAO;
import ruanko.model.bopo.Node_Data;
import android.content.Context;

public class Service_Node {
	//声明Friend_ManageDAO
	private Node_ManageDAO nDao = null;
	
	public Service_Node(Context context){
		//实例化Friend_Manage对象
		nDao = new Node_Manage(context);
	}
	/*
	 * 成长轴显示
	 */
	public List<?> line(int id){
		List<?> list = nDao.line(id);
		return list;
	}
	/*
	 * 成长记录显示
	 */
	public Node_Data show(int id){
		Node_Data node_Data = nDao.show(id);
		return node_Data;
	}
	/*
	 * 测试数据输入
	 */
	public void input(Node_Data node_Data){
		nDao.input(node_Data);
	}
	/*
	 * 成长记录删除
	 */
	public void delete(){
		nDao.delete();
	}
}
