package ruanko.activity.bopo;

import ruanko.service.bopo.Service_Friend;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//通过用户名添加好友界面（Friend_Add_Name）
public class Friend_Add_Name extends Activity{

	//声明控件
	private EditText name = null;
	
	private Service_Friend service_Friend = null;
	
	private int id = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add_name);
		service_Friend = new Service_Friend(this);
		
		name = (EditText)findViewById(R.id.name);//初始化
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
	//搜索按钮点击事件
	public void onClick_Search(View view){
		String name_db = name.getText().toString();
		id = service_Friend.name(name_db);
		Intent intent = new Intent(this,Friend_Info.class);
		Bundle bundle = new Bundle();
		bundle.putInt("name_id", id);
		intent.putExtras(bundle);
		startActivity(intent);
		//Intent intent = new Intent(this,Friend_Add_Result.class);
		//startActivity(intent);
		//finish();
	}
	
}
