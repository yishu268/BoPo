package ruanko.activity.bopo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//���ѽ��棨Friend��
public class Friend extends Bottom{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend);
	}
	
	//��Ӱ�ť����¼�
	public void onClick_Add(View view){
		Intent intent = new Intent(this,Friend_Add.class);
		startActivity(intent);
	}
}
