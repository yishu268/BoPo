package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//��ʾ������Ϣ���棨Friend_Info��
public class Friend_Info extends Activity{

	private int nameid = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_info);
		init();
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
	//��Ϊ���Ѱ�ť����¼�
	public void onClick_Add(View view){
		Intent intent = new Intent(this,Friend_Add.class);
		startActivity(intent);
		finish();
	}
	//��ʼ��
	private void init(){
		Bundle bundle = this.getIntent().getExtras();
		nameid = bundle.getInt("name_id", -1);
		String xx = "";
		xx = String.valueOf(nameid);
		Toast.makeText(this, xx, Toast.LENGTH_SHORT).show();
	}
}
