package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//显示好友信息界面（Friend_Info）
public class Friend_Info extends Activity{

	private int nameid = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_info);
		init();
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
	//加为好友按钮点击事件
	public void onClick_Add(View view){
		Intent intent = new Intent(this,Friend_Add.class);
		startActivity(intent);
		finish();
	}
	//初始化
	private void init(){
		Bundle bundle = this.getIntent().getExtras();
		nameid = bundle.getInt("name_id", -1);
		String xx = "";
		xx = String.valueOf(nameid);
		Toast.makeText(this, xx, Toast.LENGTH_SHORT).show();
	}
}
