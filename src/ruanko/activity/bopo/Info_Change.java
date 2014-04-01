package ruanko.activity.bopo;

import ruanko.model.bopo.Data;
import ruanko.model.bopo.Info_Data;
import ruanko.service.bopo.Service_Friend;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//个人信息修改界面（Info_Change）
public class Info_Change extends Activity{
	//声明控件
	private TextView name = null;
	private TextView age = null;
	
	private EditText phone = null;
	private EditText location = null;
	private EditText birth = null;
	
	private Service_Friend service_Friend = null;
	private Data data = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_change);
		service_Friend = new Service_Friend(this);
		data = (Data)getApplication();
		init();
	}
	
	//头像按钮点击事件
	public void onClick_Head(View view){
		Intent intent = new Intent(this,Info_Head.class);
		startActivity(intent);
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
	//初始化
	private void init(){
		name = (TextView)findViewById(R.id.name);
		age = (TextView)findViewById(R.id.age);
		phone = (EditText)findViewById(R.id.phone);
		location = (EditText)findViewById(R.id.location);
		birth = (EditText)findViewById(R.id.birth);
		load();
	}
	//载入数据
	private void load(){
		Info_Data info_Data = new Info_Data();
		info_Data = service_Friend.getId(data.getPerson_id());
		name.setText(info_Data.getName());
		age.setText(info_Data.getAge());
		phone.setText(info_Data.getPhone());
		location.setText(info_Data.getLocation());
		birth.setText(info_Data.getBirth());
	}
}
