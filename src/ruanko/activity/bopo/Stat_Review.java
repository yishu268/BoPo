package ruanko.activity.bopo;

import android.os.Bundle;
import android.view.View;

//�ɳ���ִͳ�ƽ��棨Stat_Review��
public class Stat_Review extends Bottom{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stat_review);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view) {
		finish();
	}
}
