package ruanko.activity.bopo;

import android.os.Bundle;
import android.view.View;

//�ɳ���¼ͳ�ƽ��棨Stat_Node��
public class Stat_Node extends Bottom{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stat_node);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view) {
		finish();
	}
}
