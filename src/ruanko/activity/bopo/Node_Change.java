package ruanko.activity.bopo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//�ɳ���Ϣ�޸Ľ��棨Node_Change��
public class Node_Change extends Bottom{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.node_change);
	}
	//��ɰ�ť����¼�
	public void onClick_Finish(View view){
		Intent intent = new Intent(this,Node_View.class);
		startActivity(intent);
		finish();
	}
}
