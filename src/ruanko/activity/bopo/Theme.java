package ruanko.activity.bopo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

//������棨Theme��
public class Theme extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.theme);
	}
	
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
}
