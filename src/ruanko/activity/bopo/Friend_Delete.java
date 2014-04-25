package ruanko.activity.bopo;

import ruanko.model.bopo.Info_Data;
import ruanko.service.bopo.Service_Friend;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Friend_Delete extends Bottom{
	//�����ؼ�
	private TextView name = null;
	private TextView gender = null;
	private TextView location = null;
	private TextView mail = null;
	
	private Info_Data info_Data = null;
	
	private Service_Friend service_Friend = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_delete);
		service_Friend = new Service_Friend(this);
		init();
	}
	//ɾ����ť����¼�
	public void onClick_Delete(View view){
		
	}
	//��ʼ��
	private void init(){
		name = (TextView)findViewById(R.id.name);
		gender = (TextView)findViewById(R.id.gender);
		location = (TextView)findViewById(R.id.location);
		mail = (TextView)findViewById(R.id.mail);
		int i = 1;
		info_Data = service_Friend.getId(i);
		load();
	}
	//��������
	private void load(){
		name.setText(info_Data.getName());
		gender.setText(info_Data.getGender());
		location.setText(info_Data.getLocation());
		mail.setText(info_Data.getMail());
	}
}
