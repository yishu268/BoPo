package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//����ͳ�ƽ��棨Stat��
public class Stat extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stat);
	}
	//�ɳ���¼ͳ�ư�ť����¼�
	public void onClick_Stat_Node(View view){
		Intent intent = new Intent(this,Stat_Node.class);
		startActivity(intent);
	}
	//�ɳ���ִͳ�ư�ť����¼�
	public void onClick_Stat_Review(View view){
		Intent intent = new Intent(this,Stat_Review.class);
		startActivity(intent);
	}
	//�ۺ�����ͳ�ư�ť����¼�
	public void onClick_Stat_Line(View view){
		Intent intent = new Intent(this,Stat_Line.class);
		startActivity(intent);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Set.class);
		startActivity(intent);
		finish();
	}
}
