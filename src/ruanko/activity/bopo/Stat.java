package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//数据统计界面（Stat）
public class Stat extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stat);
	}
	//成长记录统计按钮点击事件
	public void onClick_Stat_Node(View view){
		Intent intent = new Intent(this,Stat_Node.class);
		startActivity(intent);
	}
	//成长回执统计按钮点击事件
	public void onClick_Stat_Review(View view){
		Intent intent = new Intent(this,Stat_Review.class);
		startActivity(intent);
	}
	//综合数据统计按钮点击事件
	public void onClick_Stat_Line(View view){
		Intent intent = new Intent(this,Stat_Line.class);
		startActivity(intent);
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
}
