package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//ͨ���û�����Ӻ��ѽ��棨Friend_Add_Name��
public class Friend_Add_Name extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add_name);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Friend_Add.class);
		startActivity(intent);
		finish();
	}
	//������ť����¼�
	public void onClick_Search(View view){
		Intent intent = new Intent(this,Friend_Add_Result.class);
		startActivity(intent);
		finish();
	}
}
