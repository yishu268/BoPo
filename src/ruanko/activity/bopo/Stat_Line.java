package ruanko.activity.bopo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

//�ۺ�����ͳ�ƽ��棨Stat_Line��
public class Stat_Line extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stat_line);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view) {
		finish();
	}
}
