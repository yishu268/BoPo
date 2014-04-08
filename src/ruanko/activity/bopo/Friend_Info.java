package ruanko.activity.bopo;

import ruanko.model.bopo.Info_Data;
import ruanko.service.bopo.Service_Friend;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//��ʾ������Ϣ���棨Friend_Info��
public class Friend_Info extends Activity{

	//�����ؼ�
	private TextView name = null;
	private TextView gender = null;
	private TextView location = null;
	private TextView mail = null;
	
	private Button add = null;
	
	private int nameid = 0;
	
	private Service_Friend service_Friend = null;
	
	private Info_Data info_Data = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_info);
		service_Friend = new Service_Friend(this);
		init();
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
	//��Ϊ���Ѱ�ť����¼�
	public void onClick_Add(View view){
		boolean flag = true;
		flag = service_Friend.add(info_Data);
		if (flag) {
			Toast.makeText(this, "�û���ӳɹ�", Toast.LENGTH_SHORT).show();
		}else {
			Toast.makeText(this, "�û����ʧ��", Toast.LENGTH_SHORT).show();
		}
		Intent intent = new Intent(this,Friend_Add.class);
		startActivity(intent);
		finish();
	}
	//��ʼ��
	private void init(){
		
		name = (TextView)findViewById(R.id.name);
		gender = (TextView)findViewById(R.id.gender);
		location = (TextView)findViewById(R.id.location);
		mail = (TextView)findViewById(R.id.mail);
		add = (Button)findViewById(R.id.add);
		
		//���ܴ�������id
		Bundle bundle = this.getIntent().getExtras();
		nameid = bundle.getInt("name_id", -1);
		//String xx = "";
		//xx = String.valueOf(nameid);
		//Toast.makeText(this, xx, Toast.LENGTH_SHORT).show();
		info_Data = service_Friend.getId(nameid);
		load();
		boolean flag = service_Friend.check(info_Data.getName());
		if (flag) {
			
		}else {
			Toast.makeText(this, "���û��Ѿ�����ĺ���", Toast.LENGTH_LONG).show();
			add.setEnabled(false);
		}
	}
	//��������ʾ��������
	private void load() {

		
		name.setText(info_Data.getName());
		gender.setText(info_Data.getGender());
		location.setText(info_Data.getName());
		mail.setText(info_Data.getMail());

	}
}
