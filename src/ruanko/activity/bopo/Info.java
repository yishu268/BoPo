package ruanko.activity.bopo;

import ruanko.model.bopo.Data;
import ruanko.model.bopo.Info_Data;
import ruanko.service.bopo.Service_Friend;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//个人信息界面（Info）
public class Info extends Activity{
	//声明控件
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
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);
		service_Friend = new Service_Friend(this);
		data = (Data)getApplication();
		init();
	}
	//重载获取数据
	@Override  
	protected void onNewIntent(Intent intent) {        
	    super.onNewIntent(intent);  
	    setIntent(intent);
		load();
	    //here we can use getIntent() to get the extra data.
	}
	
	//手机返回按钮点击事件
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK&&event.getRepeatCount() == 0) {
			Intent intent = new Intent(this,Line.class);
			startActivity(intent);
			finish();
			return false;
		}
		return false;	
	}
	
	//修改按钮点击事件
	public void onClick_Change(View view){
		Intent intent = new Intent(this,Info_Change.class);
		startActivity(intent);
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Line.class);
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
		Info_Data info_Data = new Info_Data();
		info_Data =  service_Friend.getId(data.getPerson_id());
		int head1 = Integer.parseInt(info_Data.getImage());

		name.setText(info_Data.getName());
		gender.setText(info_Data.getGender());
		phone.setText(info_Data.getPhone());
		location.setText(info_Data.getLocation());
		birth.setText(info_Data.getBirth());
		age.setText(info_Data.getAge());
		mail.setText(info_Data.getMail());
		head.setImageResource(data.getImage()[head1]);
	}
}
