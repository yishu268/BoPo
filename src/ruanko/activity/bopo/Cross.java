package ruanko.activity.bopo;

import ruanko.activity.bopo.Bottom;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//��Խ���棨Cross��
public class Cross extends Bottom{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cross);
	}
	//��Խ��ť����¼�
	public void onClick_Go(View view) {
		Intent intent = new Intent(this,Line.class);
		startActivity(intent);
	}
}
