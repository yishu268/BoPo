package ruanko.activity.bopo;

import ruanko.util.bopo.HttpUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//ͨ���û�����Ӻ��ѽ��棨Friend_Add_Name��
public class Friend_Add_Name extends Bottom{

	//�����ؼ�
	private EditText name = null;
	
	//private Service_Friend service_Friend = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add_name);
		//service_Friend = new Service_Friend(this);
		
		name = (EditText)findViewById(R.id.name);//��ʼ��
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
	//������ť����¼�
	public void onClick_Search(View view){
		String name_db = name.getText().toString();

		String getid = query(name_db);
		int id = Integer.parseInt(getid);

		if (id == -1) {
			Toast.makeText(this, "�������û���", Toast.LENGTH_SHORT).show();
		}else if (id == 0) {
			Toast.makeText(this, "δ�ҵ��û�", Toast.LENGTH_SHORT).show();
		}else {
			Intent intent = new Intent(this,Friend_Info.class);
			Bundle bundle = new Bundle();
			bundle.putInt("name_id", id);
			intent.putExtras(bundle);
			startActivity(intent);
			finish();
		}
	}
	
	private String query(String name){
		String queryString = "userName="+name;
		String url = HttpUtil.BASE_URL+"servlet/addFBNameServlet?"+queryString;
		return HttpUtil.queryStringForPost(url);
    }
	
}
