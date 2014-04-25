package ruanko.activity.bopo;

import org.json.JSONObject;

import ruanko.model.bopo.Data;
import ruanko.model.bopo.Info_Data;
import ruanko.util.bopo.HttpUtil;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

//��¼���棨Login��
public class Login extends Activity {

	//�����ؼ�
	private EditText user = null;
	private EditText password = null;
	private Info_Data info_Data = new Info_Data();
	
	//private Service_User service_User = null;
	
	private Data data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
				
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		  .detectDiskReads() .detectDiskWrites() .detectNetwork()
		  .detectAll()  .penaltyLog() .build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		  .detectLeakedSqlLiteObjects()
		  .penaltyLog() .penaltyDeath() .build());
 
		
		//service_User = new Service_User(this);
		data = (Data)getApplication();
		init();
	}

	//��¼��ť����¼�
	public void onClick_Login(View view){
		getContent();
		//Intent intent = new Intent(this,Line.class);
		//startActivity(intent);
		//finish();
	}	
	//ע�ᰴť����¼�
	public void onClick_Register(View view){
		Intent intent = new Intent(this,Register.class);
		startActivity(intent);
	}
	//�һ����밴ť����¼�
	public void onClick_Find(View view){
		Intent intent = new Intent(this,Find_Password.class);
		startActivity(intent);
	}
	//��ʼ���ؼ�
	private void init() {
		user = (EditText)findViewById(R.id.user);
		password = (EditText)findViewById(R.id.password);
	}
	//��ȡ��Ϣ
	private void getContent(){
		String user_db = user.getText().toString();
		String password_db = password.getText().toString();
		

		//Toast.makeText(this, xx, Toast.LENGTH_SHORT).show();
		
		if (user_db.equals("")||user_db == null) {
			Toast.makeText(this, "�������û���", Toast.LENGTH_SHORT).show();
		}else {
			String loginRJson = query(user_db, password_db);
			Toast.makeText(this, loginRJson, Toast.LENGTH_SHORT).show();			
			
			//����Ƿ�������ӷ�����
			if (loginRJson.equals("����״̬�쳣��") || loginRJson.equals("") || loginRJson == null) {
				Toast.makeText(this, "�����쳣", Toast.LENGTH_SHORT).show();
			}else {
				//���ݷ���˷���ֵ�ж��û��Ƿ����
				if (loginRJson.equals("{}")) {
					Toast.makeText(this, "�û��������ڻ��������", Toast.LENGTH_SHORT).show();
				}
				else {
					//ת��JSON���ݲ�ʵ����info_Data
					try {
						JSONObject object = new JSONObject(loginRJson);
						info_Data.setId(Integer.parseInt(object.getString("id")));
						info_Data.setLoginFlag(object.getString("userLoginFlag"));	
					} catch (Exception e) {
						Toast.makeText(this, "�û���Ϣ�����쳣", Toast.LENGTH_SHORT).show();
					}
					//�����û�״̬��ʾ���ж��û��Ƿ�����
					if (info_Data.getLoginFlag().equals("1")) {
						Toast.makeText(this, "�û����������豸��¼", Toast.LENGTH_SHORT).show();
					} else{
						data.setPerson_id(info_Data.getId());
						Toast.makeText(this, "��¼�ɹ�", Toast.LENGTH_SHORT).show();
						Intent intent = new Intent(this,Line.class);
						startActivity(intent);
						finish();
					}
				}  
			}
		}
	}
	private String query(String username,String password){
		String queryString = "userName="+username+"&userPwd="+password;
		String url = HttpUtil.BASE_URL+"servlet/userLoginServlet?"+queryString;
		return HttpUtil.queryStringForPost(url);
    }
	
}
