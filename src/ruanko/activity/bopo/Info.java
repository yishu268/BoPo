package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//������Ϣ���棨Info��
public class Info extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);
	}
	
	//�޸İ�ť����¼�
	public void onClick_Change(View view){
		Intent intent = new Intent(this,Info_Change.class);
		startActivity(intent);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Line.class);
		startActivity(intent);
		finish();
	}
}
