package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//�ɳ���¼ͳ�ƽ��棨Stat_Node��
public class Stat_Node extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stat_node);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view) {
		Intent intent = new Intent(this, Stat.class);
		startActivity(intent);
		finish();
	}
}
