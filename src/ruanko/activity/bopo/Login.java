package ruanko.activity.bopo;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

//��½���棨Login��
public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	}
	
	//��¼��ť����¼�
	public void onClick_Login(View view){
		Intent intent = new Intent(this,Line.class);
		startActivity(intent);
		finish();
	}	
	//ע�ᰴť����¼�
	public void onClick_Register(View view){
		Intent intent = new Intent(this,Register.class);
		startActivity(intent);
	}
	//�һ����밴ť����¼�
	public void onClick_Find(View view){
		Intent intent = new Intent(this,Find_Password.class);
		startActivity(intent);
	}	
}
