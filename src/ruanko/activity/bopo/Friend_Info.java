package ruanko.activity.bopo;

import ruanko.model.bopo.Info_Data;
import ruanko.service.bopo.Service_Friend;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//显示好友信息界面（Friend_Info）
public class Friend_Info extends Activity{

	//声明控件
	private TextView name = null;
	private TextView gender = null;
	private TextView location = null;
	private TextView mail = null;
	
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
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
	//加为好友按钮点击事件
	public void onClick_Add(View view){
		boolean flag = true;
		flag = service_Friend.add(info_Data);
		if (flag) {
			Toast.makeText(this, "用户添加成功", Toast.LENGTH_SHORT).show();
		}else {
			Toast.makeText(this, "用户添加失败", Toast.LENGTH_SHORT).show();
		}
		Intent intent = new Intent(this,Friend_Add.class);
		startActivity(intent);
		finish();
	}
	//初始化
	private void init(){
		
		name = (TextView)findViewById(R.id.name);
		gender = (TextView)findViewById(R.id.gender);
		location = (TextView)findViewById(R.id.location);
		mail = (TextView)findViewById(R.id.mail);		
		
		//接受传过来的id
		Bundle bundle = this.getIntent().getExtras();
		nameid = bundle.getInt("name_id", -1);
		String xx = "";
		xx = String.valueOf(nameid);
		Toast.makeText(this, xx, Toast.LENGTH_SHORT).show();
		info_Data = service_Friend.getId(nameid);
		load();
	}
	//将数据显示到界面上
	private void load() {
		name.setText(info_Data.getName());
		gender.setText(info_Data.getMail());
		location.setText(info_Data.getName());
		mail.setText(info_Data.getMail());
	}
}
