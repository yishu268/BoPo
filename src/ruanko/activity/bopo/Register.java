package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//ע����棨Register��
public class Register extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view) {
		Intent intent = new Intent(this,Login.class);
		startActivity(intent);
		finish();
	}
	//ע�ᰴť����¼�
	public void onClick_Register(View view) {
		Intent intent = new Intent(this,Login.class);
		startActivity(intent);
		finish();
	}
}
