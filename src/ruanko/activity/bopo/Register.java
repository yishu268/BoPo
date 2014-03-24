package ruanko.activity.bopo;

import ruanko.model.bopo.Info_Data;
import ruanko.service.bopo.Service_User;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Register extends Activity{

	//�����ؼ�
	private EditText name = null;
	private EditText password = null;
	private EditText repassword = null;
	private EditText mail = null;
	
	private Button register = null;
	
	private ImageView error = null;
	
	private Service_User service_User = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		service_User = new Service_User(this);
		init();
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
	//ע�ᰴť����¼�
	public void onClick_Register(View view){
		boolean flag = service_User.register(getContent());
		if (flag) {
			Toast.makeText(this,"ע��ɹ�", Toast.LENGTH_LONG).show();
			finish();
		}else {
			Toast.makeText(this,"ע��ʧ��", Toast.LENGTH_LONG).show();
		}
	}
	//��ʼ���ؼ�
	private void init(){
		name = (EditText)findViewById(R.id.name);
		password = (EditText)findViewById(R.id.password);
		repassword = (EditText)findViewById(R.id.repassword);
		mail = (EditText)findViewById(R.id.mail);
		register = (Button)findViewById(R.id.register);
		
		error = (ImageView)findViewById(R.id.error);
		error.setVisibility(View.GONE);
		
		
		repassword.addTextChangedListener(new TextWatcher() {
			//�����ֶ��б仯ʱ
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
			}
			//�����ֶ��б仯ǰ
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {				
			}
			//�����ֶ��б仯��
			@Override
			public void afterTextChanged(Editable s) {	
				if (password.getText().toString().equals(repassword.getText().toString())) {
					error.setVisibility(View.GONE);
					register.setEnabled(true);
				}else {
					error.setVisibility(View.VISIBLE);
					register.setEnabled(false);
				}
			}
		});
	}
	private Info_Data getContent(){
		Info_Data info_Data = new Info_Data();
		info_Data.setName(name.getText().toString());
		info_Data.setPassword(password.getText().toString());
		info_Data.setMail(mail.getText().toString());
		info_Data.setNode_id(name.getText().toString());
		info_Data.setImage(name.getText().toString());
		return info_Data;		
	}
}
