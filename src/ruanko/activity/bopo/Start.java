package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

//�ӳ��������棨Start��     �ӳ�2s��ת����¼���棨Login��
public class Start extends Activity{
	//�����ӳ�ʱ��
	private final int SPLASH_DISPLAY_LENGHT = 2000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		new Handler().postDelayed(new Runnable(){
			public void run() {
				//�ӳ�ִ�е�����
				Intent intent = new Intent(Start.this,Login.class);
				Start.this.startActivity(intent);
				Start.this.finish();
			}
		},SPLASH_DISPLAY_LENGHT);//�ӳٵ�ʱ��
	}
}