package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//���ѳɳ���¼���棨Friend_Node��
public class Friend_Node extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_node);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
	//���۰�ť����¼�
	public void onClick_Review(View view){
		Intent intent = new Intent(this,Review_Add.class);
		startActivity(intent);
	}
}
