package ruanko.activity.bopo;

import ruanko.model.bopo.Info_Data;
import ruanko.service.bopo.Service_Friend;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Friend_Delete extends Bottom{
	//声明控件
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
	//删除按钮点击事件
	public void onClick_Delete(View view){
		
	}
	//初始化
	private void init(){
		name = (TextView)findViewById(R.id.name);
		gender = (TextView)findViewById(R.id.gender);
		location = (TextView)findViewById(R.id.location);
		mail = (TextView)findViewById(R.id.mail);
		int i = 1;
		info_Data = service_Friend.getId(i);
		load();
	}
	//载入数据
	private void load(){
		name.setText(info_Data.getName());
		gender.setText(info_Data.getGender());
		location.setText(info_Data.getLocation());
		mail.setText(info_Data.getMail());
	}
}
