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

//登录界面（Login）
public class Login extends Activity {

	//声明控件
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

	//登录按钮点击事件
	public void onClick_Login(View view){
		getContent();
		//Intent intent = new Intent(this,Line.class);
		//startActivity(intent);
		//finish();
	}	
	//注册按钮点击事件
	public void onClick_Register(View view){
		Intent intent = new Intent(this,Register.class);
		startActivity(intent);
	}
	//找回密码按钮点击事件
	public void onClick_Find(View view){
		Intent intent = new Intent(this,Find_Password.class);
		startActivity(intent);
	}
	//初始化控件
	private void init() {
		user = (EditText)findViewById(R.id.user);
		password = (EditText)findViewById(R.id.password);
	}
	//获取信息
	private void getContent(){
		String user_db = user.getText().toString();
		String password_db = password.getText().toString();
		

		//Toast.makeText(this, xx, Toast.LENGTH_SHORT).show();
		
		if (user_db.equals("")||user_db == null) {
			Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
		}else {
			String loginRJson = query(user_db, password_db);
			Toast.makeText(this, loginRJson, Toast.LENGTH_SHORT).show();			
			
			//检查是否可以连接服务器
			if (loginRJson.equals("网络状态异常！") || loginRJson.equals("") || loginRJson == null) {
				Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
			}else {
				//根据服务端返回值判断用户是否存在
				if (loginRJson.equals("{}")) {
					Toast.makeText(this, "用户名不存在或密码错误", Toast.LENGTH_SHORT).show();
				}
				else {
					//转换JSON数据并实例化info_Data
					try {
						JSONObject object = new JSONObject(loginRJson);
						info_Data.setId(Integer.parseInt(object.getString("id")));
						info_Data.setLoginFlag(object.getString("userLoginFlag"));	
					} catch (Exception e) {
						Toast.makeText(this, "用户信息加载异常", Toast.LENGTH_SHORT).show();
					}
					//根据用户状态标示符判断用户是否在线
					if (info_Data.getLoginFlag().equals("1")) {
						Toast.makeText(this, "用户已在其他设备登录", Toast.LENGTH_SHORT).show();
					} else{
						data.setPerson_id(info_Data.getId());
						Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
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
