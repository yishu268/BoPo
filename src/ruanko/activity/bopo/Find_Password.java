package ruanko.activity.bopo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

//�һ�������棨Find_Password��
public class Find_Password extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.find_password);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
}
