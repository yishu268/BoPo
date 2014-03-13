package ruanko.activity.bopo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//���ý��棨Set��
public class Set extends Bottom{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set);		
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
		Intent intent = new Intent(Set.this, Login.class);
		startActivity(intent);
		finish();
	}
}
