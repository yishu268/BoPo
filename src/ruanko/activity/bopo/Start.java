package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

//延迟启动界面（Start）     延迟2s跳转到登录界面（Login）
public class Start extends Activity{
	//定义延迟时间
	private final int SPLASH_DISPLAY_LENGHT = 2000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		new Handler().postDelayed(new Runnable(){
			public void run() {
				//延迟执行的内容
				Intent intent = new Intent(Start.this,Login.class);
				Start.this.startActivity(intent);
				Start.this.finish();
			}
		},SPLASH_DISPLAY_LENGHT);//延迟的时间
	}
}