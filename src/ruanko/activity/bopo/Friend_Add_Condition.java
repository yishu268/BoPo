package ruanko.activity.bopo;

import ruanko.service.bopo.Service_Friend;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

//按条件添加好友界面（Friend_Add_Condition）
public class Friend_Add_Condition extends Activity{

	//声明控件
	private EditText age = null;
	private RadioGroup gender = null;
	private Spinner location = null;
	
	private Service_Friend service_Friend = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add_condition);
		service_Friend = new Service_Friend(this);
		init();
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
	//搜索按钮点击事件
	public void onClick_Search(View view){
		RadioButton rButton = (RadioButton)findViewById(gender.getCheckedRadioButtonId());
		String age_db = age.getText().toString();
		String gender_db = rButton.getText().toString();
		String location_db = "123";
		int[] id = service_Friend.condition(age_db, gender_db, location_db);


		Intent intent = new Intent(this,Friend_Add_Result.class);
		Bundle bundle = new Bundle();
		bundle.putIntArray("id", id);
		intent.putExtras(bundle);
		startActivity(intent);
		finish();
	}

	//初始化
	private void init(){
		age = (EditText)findViewById(R.id.age);
		gender = (RadioGroup)findViewById(R.id.gender);
		location = (Spinner)findViewById(R.id.location);
		
		//Spinner赋值
		ArrayAdapter<?> adapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_spinner_item, R.array.city);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		location.setAdapter(adapter);
	}
	//获取数据

}
