package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//关于我们界面（About）
public class About extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Set.class);
		startActivity(intent);
		finish();
	}
}
