package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//��������Ӻ��ѽ��棨Friend_Add_Condition��
public class Friend_Add_Condition extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add_condition);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
	//������ť����¼�
	public void onClick_Search(View view){
		Intent intent = new Intent(this,Friend_Add_Result.class);
		startActivity(intent);
		finish();
	}
}
