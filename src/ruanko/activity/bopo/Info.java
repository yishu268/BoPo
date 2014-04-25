package ruanko.activity.bopo;

import org.json.JSONObject;

import ruanko.model.bopo.Data;
import ruanko.model.bopo.Info_Data;
import ruanko.util.bopo.HttpUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//������Ϣ���棨Info��
public class Info extends Bottom{
	//�����ؼ�
	private TextView name = null;
	private TextView gender = null;
	private TextView phone = null;
	private TextView location = null;
	private TextView birth = null;
	private TextView age = null;
	private TextView mail = null;
	
	private ImageView head = null;
	
	private Data data = null;
	
	//private Service_Friend service_Friend = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);
		//service_Friend = new Service_Friend(this);
		data = (Data)getApplication();
		init();
	}
	//���ػ�ȡ����
	@Override  
	protected void onNewIntent(Intent intent) {        
	    super.onNewIntent(intent);  
	    setIntent(intent);
		load();
	    //here we can use getIntent() to get the extra data.
	}
	
	//�ֻ����ذ�ť����¼�
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK&&event.getRepeatCount() == 0) {
			Intent intent = new Intent(this,Line.class);
			startActivity(intent);
			finish();
			return false;
		}
		return false;	
	}
	
	//�޸İ�ť����¼�
	public void onClick_Change(View view){
		Intent intent = new Intent(this,Info_Change.class);
		startActivity(intent);
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Line.class);
		startActivity(intent);
		finish();
	}
	//��ʼ��
	private void init(){
		name = (TextView)findViewById(R.id.name);
		gender = (TextView)findViewById(R.id.gender);
		phone = (TextView)findViewById(R.id.phone);
		location = (TextView)findViewById(R.id.location);
		birth = (TextView)findViewById(R.id.birth);
		age = (TextView)findViewById(R.id.age);
		mail = (TextView)findViewById(R.id.mail);
		head = (ImageView)findViewById(R.id.head);
		load();
	}
	//��������
	private void load(){
		Info_Data info_Data = new Info_Data();
		//info_Data =  service_Friend.getId(data.getPerson_id());
		//int head1 = Integer.parseInt(info_Data.getImage());

		String json =  query(String.valueOf(data.getPerson_id()));
		
		try {
			JSONObject object = new JSONObject(json);
			info_Data.setImage(object.getString("userHeadImg"));
			info_Data.setName(object.getString("userName"));
			info_Data.setGender(object.getString("userSex"));
			info_Data.setPhone(object.getString("userMobile"));
			info_Data.setLocation(object.getString("userPlace"));
			info_Data.setBirth(object.getString("userBirthday"));
			info_Data.setAge(object.getString("userAge"));
			info_Data.setMail(object.getString("userEmail"));
			//Toast.makeText(this, object.getString("notesTitle"), Toast.LENGTH_SHORT).show();
			
		} catch (Exception e) {
			Toast.makeText(this, "�û���Ϣ�����쳣", Toast.LENGTH_SHORT).show();
		}
		
		name.setText(info_Data.getName());
		gender.setText(info_Data.getGender());
		phone.setText(info_Data.getPhone());
		location.setText(info_Data.getLocation());
		birth.setText(info_Data.getBirth());
		age.setText(info_Data.getAge());
		mail.setText(info_Data.getMail());
		head.setImageResource(data.getImage()[Integer.parseInt(info_Data.getImage())]);
	}
	
	private String query(String id){
		String queryString = "id="+id;
		String url = HttpUtil.BASE_URL+"servlet/selectFBIdServlet?"+queryString;
		return HttpUtil.queryStringForPost(url);
    }
}
