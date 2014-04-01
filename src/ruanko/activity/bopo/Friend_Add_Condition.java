package ruanko.activity.bopo;

import java.util.List;

import ruanko.service.bopo.Service_Friend;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

//��������Ӻ��ѽ��棨Friend_Add_Condition��
public class Friend_Add_Condition extends Activity{

	//�����ؼ�
	private EditText age = null;
	private RadioGroup gender = null;
	private Spinner location = null;
	
	private Service_Friend service_Friend = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add_condition);
		service_Friend = new Service_Friend(this);
		init();
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
	//������ť����¼�
	public void onClick_Search(View view){
		RadioButton rButton = (RadioButton)findViewById(gender.getCheckedRadioButtonId());
		String age_db = age.getText().toString();
		String gender_db = rButton.getText().toString();
		String location_db = location.getSelectedItem().toString();
		String gender_dbs = "";
		if (gender_db.equals("��")) {
			gender_dbs = "female";
		}else if (gender_db.equals("Ů")) {
			gender_dbs = "male";
		}
		if (age_db.equals("")||age_db == null) {
			Toast.makeText(this, "����������", Toast.LENGTH_SHORT).show();
		}else {
			List<?> list = service_Friend.condition(age_db, gender_dbs, location_db);
			
			int size = list.size();
			String[] array = new String[size];
			array = (String[])list.toArray(array);

			Intent intent = new Intent(this,Friend_Add_Result.class);
			Bundle bundle = new Bundle();
			bundle.putStringArray("id", array);
			intent.putExtras(bundle);
			startActivity(intent);
			finish();
		}
	}

	//��ʼ��
	private void init(){
		age = (EditText)findViewById(R.id.age);
		gender = (RadioGroup)findViewById(R.id.gender);
		location = (Spinner)findViewById(R.id.location);
	}
	//��ȡ����

}
