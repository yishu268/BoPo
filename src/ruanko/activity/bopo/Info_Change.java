package ruanko.activity.bopo;

import ruanko.model.bopo.Data;
import ruanko.model.bopo.Info_Data;
import ruanko.service.bopo.Service_Friend;
import ruanko.service.bopo.Service_User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

//������Ϣ�޸Ľ��棨Info_Change��
public class Info_Change extends Activity{
	//�����ؼ�
	private TextView name = null;
	private TextView age = null;
	
	private EditText phone = null;
	private EditText location = null;
	private EditText birth = null;
	
	private RadioGroup gender = null;
	
	private ImageButton head = null;
	
	private Service_Friend service_Friend = null;
	private Service_User service_User = null;
	private Data data = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_change);
		service_Friend = new Service_Friend(this);
		service_User = new Service_User(this);
		data = (Data)getApplication();
		init();
	}
	//���ػ�ȡ����
	@Override  
	protected void onNewIntent(Intent intent) {        
	    super.onNewIntent(intent);  
	    setIntent(intent);
		load();
	    //here we can use getIntent() to get the extra data.
	}
	
	//ͷ��ť����¼�
	public void onClick_Head(View view){
		Intent intent = new Intent(this,Info_Head.class);
		startActivity(intent);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Info.class);
		startActivity(intent);
		finish();
	}
	//���水ť����¼�
	public void onClick_Save(View view){
		Info_Data info_Data = new Info_Data();
		RadioButton rButton = (RadioButton)findViewById(gender.getCheckedRadioButtonId());
		
		info_Data.setGender(rButton.getText().toString());
		info_Data.setPhone(phone.getText().toString());
		info_Data.setLocation(location.getText().toString());
		info_Data.setBirth(birth.getText().toString());
		info_Data.setId(data.getPerson_id());
		
		boolean flag = service_User.update(info_Data);
		if (flag) {
			Toast.makeText(this, "����ɹ�", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this,Info.class);
			startActivity(intent);
			finish();
		}else {
			Toast.makeText(this, "����ʧ��", Toast.LENGTH_SHORT).show();
		}
	}
	//��ʼ��
	private void init(){
		name = (TextView)findViewById(R.id.name);
		age = (TextView)findViewById(R.id.age);
		phone = (EditText)findViewById(R.id.phone);
		location = (EditText)findViewById(R.id.location);
		birth = (EditText)findViewById(R.id.birth);
		head = (ImageButton)findViewById(R.id.head);
		gender = (RadioGroup)findViewById(R.id.gender);
		load();
	}
	//��������
	private void load(){
		Info_Data info_Data = new Info_Data();
		info_Data = service_Friend.getId(data.getPerson_id());
		name.setText(info_Data.getName());
		age.setText(info_Data.getAge());
		phone.setText(info_Data.getPhone());
		location.setText(info_Data.getLocation());
		birth.setText(info_Data.getBirth());
		head.setImageResource(data.getImage()[data.getHead_id()]);
		
		if (info_Data.getGender().equals("Ů")||info_Data.getGender().equals("")){
			RadioButton rb1 = (RadioButton)findViewById(R.id.female);
			rb1.setChecked(true);
		}else {
			RadioButton rb2 = (RadioButton)findViewById(R.id.male);
			rb2.setChecked(true);
		}
	}
}
