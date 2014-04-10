package ruanko.service.bopo;

import java.util.List;

import ruanko.dao.bopo.Node_Manage;
import ruanko.dao.bopo.Node_ManageDAO;
import ruanko.model.bopo.Node_Data;
import android.content.Context;

public class Service_Node {
	//����Friend_ManageDAO
	private Node_ManageDAO nDao = null;
	
	public Service_Node(Context context){
		//ʵ����Friend_Manage����
		nDao = new Node_Manage(context);
	}
	/*
	 * �ɳ�����ʾ
	 */
	public List<?> line(int id){
		List<?> list = nDao.line(id);
		return list;
	}
	/*
	 * �ɳ���¼��ʾ
	 */
	public Node_Data show(int id){
		Node_Data node_Data = nDao.show(id);
		return node_Data;
	}
	/*
	 * ������������
	 */
	public void input(Node_Data node_Data){
		nDao.input(node_Data);
	}
	/*
	 * �ɳ���¼ɾ��
	 */
	public void delete(){
		nDao.delete();
	}
}
