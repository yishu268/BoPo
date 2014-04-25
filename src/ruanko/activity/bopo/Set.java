package ruanko.activity.bopo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//���ý��棨Set��
public class Set extends Bottom{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set);		
	}
	//����
	@Override
	protected void onNewIntent(Intent intent) {
	    super.onNewIntent(intent);  
	    setIntent(intent);
	    setContentView(R.layout.set);
	    //here we can use getIntent() to get the extra data.
	}
	//����ͳ�ư�ť����¼�
	public void onClick_Stat(View view) {
		Intent intent = new Intent(Set.this, Stat.class);
		startActivity(intent);
	}
	//�������ð�ť����¼�
	public void onClick_Theme(View view) {
		Intent intent = new Intent(Set.this, Theme.class);
		startActivity(intent);
	}
	//�������ǰ�ť����¼�
	public void onClick_About(View view) {
		Intent intent = new Intent(Set.this, About.class);
		startActivity(intent);
	}
	//ע����½��ť����¼�
	public void onClick_Logout(View view) {
		Intent intent = new Intent();
        intent.setClass(this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);        
        finish();
	}
}
