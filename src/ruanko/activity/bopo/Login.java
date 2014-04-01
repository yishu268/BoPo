package ruanko.activity.bopo;

import ruanko.model.bopo.Data;
import ruanko.service.bopo.Service_User;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

//��¼���棨Login��
public class Login extends Activity {

	//�����ؼ�
	private EditText user = null;
	private EditText password = null;
	
	private Service_User service_User = null;
	
	private Data data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		service_User = new Service_User(this);
		data = (Data)getApplication();
		init();
	}
	
	//��¼��ť����¼�
	public void onClick_Login(View view){
		getContent();
		//Intent intent = new Intent(this,Line.class);
		//startActivity(intent);
		//finish();
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
	//��ʼ���ؼ�
	private void init() {
		user = (EditText)findViewById(R.id.user);
		password = (EditText)findViewById(R.id.password);
	}
	//��ȡ��Ϣ
	private void getContent(){
		String user_db = user.getText().toString();
		String password_db = password.getText().toString();
		int flag = service_User.login(user_db,password_db);
		
		data.setPerson_id(flag);
		//String xx = "";
		//xx = String.valueOf(flag);
		
		//Toast.makeText(this, xx, Toast.LENGTH_SHORT).show();
		//boolean flag = true;
		if (flag > 0) {
			Toast.makeText(this, "��¼�ɹ�", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this,Line.class);
			startActivity(intent);
			finish();
		}else {
			Toast.makeText(this, "��¼ʧ��", Toast.LENGTH_SHORT).show();
		}
	}
}
