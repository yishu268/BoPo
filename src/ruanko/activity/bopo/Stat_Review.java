package ruanko.activity.bopo;

import android.os.Bundle;
import android.view.View;

//成长回执统计界面（Stat_Review）
public class Stat_Review extends Bottom{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stat_review);
	}
	//返回按钮点击事件
	public void onClick_Back(View view) {
		finish();
	}
}
