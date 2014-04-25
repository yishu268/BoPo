package ruanko.activity.bopo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//�ɳ���Ϣ���棨Node_View��
public class Node_View extends Bottom{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.node_view);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
	//�༭��ť����¼�
	public void onClick_Edit(View view){
		Intent intent = new Intent(this,Node_Change.class);
		startActivity(intent);
	}
	//ɾ����ť����¼�
	public void onClick_Delete(View view){
		Intent intent = new Intent(this,Line.class);
		startActivity(intent);
		finish();
	}
	//���۰�ť����¼�
	public void onClick_Review(View view){
		Intent intent = new Intent(this,Review_Add.class);
		startActivity(intent);
	}
}
