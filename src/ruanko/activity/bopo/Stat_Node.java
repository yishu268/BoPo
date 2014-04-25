package ruanko.activity.bopo;

import android.os.Bundle;
import android.view.View;

//成长记录统计界面（Stat_Node）
public class Stat_Node extends Bottom{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stat_node);
	}
	//返回按钮点击事件
	public void onClick_Back(View view) {
		finish();
	}
}
