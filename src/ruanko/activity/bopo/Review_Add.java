package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//������۽��棨Review_Add��
public class Review_Add extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.review_add);
	}
	//��ɰ�ť����¼�
	public void onClick_Finish(View view){
		Intent intent = new Intent(this,Node_View.class);
		startActivity(intent);
		finish();
	}
}
