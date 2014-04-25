package ruanko.activity.bopo;

import android.os.Bundle;
import android.view.View;

//综合数据统计界面（Stat_Line）
public class Stat_Line extends Bottom{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stat_line);
	}
	//返回按钮点击事件
	public void onClick_Back(View view) {
		finish();
	}
}
