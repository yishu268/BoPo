package ruanko.activity.bopo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//��Ӻ��ѽ��棨Friend_Add��
public class Friend_Add extends Bottom{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add);
	}
	
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Friend.class);
		startActivity(intent);
		finish();
	}
	//��Ӻ��Ѱ�ť����¼�
	public void onClick_Add_Name(View view){
		Intent intent = new Intent(this,Friend_Add_Name.class);
		startActivity(intent);
	}
	//������������ť����¼�
	public void onClick_Add_Condition(View view){
		Intent intent = new Intent(this,Friend_Add_Condition.class);
		startActivity(intent);
	}
}
