package ruanko.activity.bopo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//�ɳ�����棨Line��
public class Line extends Bottom{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.line);
	}
	//ͷ��ť����¼�
	public void onClick_Info(View view){
		Intent intent = new Intent(this,Info.class);
		startActivity(intent);
	}
	//��Ӱ�ť����¼�
	public void onClick_Add(View view){
		Intent intent = new Intent(this,Node_Add.class);
		startActivity(intent);
	}
}
