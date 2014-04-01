package ruanko.activity.bopo;

import ruanko.model.bopo.Data;
import ruanko.model.bopo.Info_Data;
import ruanko.service.bopo.Service_Friend;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//������Ϣ���棨Info��
public class Info extends Activity{
	//�����ؼ�
	
	private TextView name = null;
	private TextView gender = null;
	private TextView phone = null;
	private TextView location = null;
	private TextView birth = null;
	private TextView age = null;
	
	private Data data = null;
	
	private Service_Friend service_Friend = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);
		service_Friend = new Service_Friend(this);
		data = (Data)getApplication();
		init();
	}
	
	//�޸İ�ť����¼�
	public void onClick_Change(View view){
		Intent intent = new Intent(this,Info_Change.class);
		startActivity(intent);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
	//��ʼ��
	private void init(){
		name = (TextView)findViewById(R.id.name);
		gender = (TextView)findViewById(R.id.gender);
		phone = (TextView)findViewById(R.id.phone);
		location = (TextView)findViewById(R.id.location);
		birth = (TextView)findViewById(R.id.birth);
		age = (TextView)findViewById(R.id.age);
		load();
	}
	//��������
	private void load(){
		Info_Data info_Data = new Info_Data();
		info_Data =  service_Friend.getId(data.getPerson_id());

		name.setText(info_Data.getName());
		gender.setText(info_Data.getGender());
		phone.setText(info_Data.getPhone());
		location.setText(info_Data.getLocation());
		birth.setText(info_Data.getBirth());
		age.setText(info_Data.getAge());
	}
}
