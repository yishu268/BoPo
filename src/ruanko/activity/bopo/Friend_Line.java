package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//���ѳɳ�����棨Friend_Line��
public class Friend_Line extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_line);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
	//���ѳɳ���Ϣ��ť����¼�
	public void onClick_Node(View view){
		Intent intent = new Intent(this,Friend_Node.class);
		startActivity(intent);
	}
}
