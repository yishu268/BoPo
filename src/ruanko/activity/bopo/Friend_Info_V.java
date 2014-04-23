package ruanko.activity.bopo;

import ruanko.model.bopo.Data;
import ruanko.model.bopo.Info_Data;
import ruanko.service.bopo.Service_Friend;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Friend_Info_V extends Activity{
	
	private TextView name = null;
	private TextView gender = null;
	private TextView phone = null;
	private TextView location = null;
	private TextView birth = null;
	private TextView age = null;
	private TextView mail = null;
	
	private ImageView head = null;
	
	private Data data = null;
	
	private Service_Friend service_Friend = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_info_v);
		data = (Data)getApplication();
		service_Friend = new Service_Friend(this);
		init();
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Friend.class);
		startActivity(intent);
		finish();
	}
	//初始化
	private void init(){
		name = (TextView)findViewById(R.id.name);
		gender = (TextView)findViewById(R.id.gender);
		phone = (TextView)findViewById(R.id.phone);
		location = (TextView)findViewById(R.id.location);
		birth = (TextView)findViewById(R.id.birth);
		age = (TextView)findViewById(R.id.age);
		mail = (TextView)findViewById(R.id.mail);
		head = (ImageView)findViewById(R.id.head);
		load();
		
	}
	//载入数据
	private void load(){
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String id = bundle.getString("id");
		
		Info_Data info_Data = new Info_Data();
		info_Data =  service_Friend.getId(Integer.parseInt(id));

		name.setText(info_Data.getName());
		gender.setText(info_Data.getGender());
		phone.setText(info_Data.getPhone());
		location.setText(info_Data.getLocation());
		birth.setText(info_Data.getBirth());
		age.setText(info_Data.getAge());
		mail.setText(info_Data.getMail());
		head.setImageResource(data.getImage()[data.getHead_id()]);
	}

}
