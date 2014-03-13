package ruanko.activity.bopo;

import ruanko.activity.bopo.Bottom;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//穿越界面（Cross）
public class Cross extends Bottom{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cross);
	}
	//穿越按钮点击事件
	public void onClick_Go(View view) {
		Intent intent = new Intent(this,Line.class);
		startActivity(intent);
	}
}
