package ruanko.activity.bopo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import ruanko.model.bopo.Info_Data;
import ruanko.util.bopo.HttpUtil;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Register extends Activity{

	//声明控件
	private EditText name = null;
	private EditText password = null;
	private EditText repassword = null;
	private EditText mail = null;
	
	private Button register = null;
	
	private ImageView error = null;
	private ImageView error_1 = null;
	private ImageView error_2 = null;
	
	//private Service_User service_User = null;
	
	private List<NameValuePair> list = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		//service_User = new Service_User(this);
		init();
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
	//注册按钮点击事件
	public void onClick_Register(View view){
		String n = name.getText().toString();
		String p = password.getText().toString();
		String r = repassword.getText().toString();
		String m = mail.getText().toString();
		
		//验证用户名是否为空
		if (n.equals("")||n == null) {
			Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
		}
		//验证密码是否为空
		else if (p.equals("")||p == null) {
			Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
		}
		//再次确认密码是否为空
		else if (r.equals("")||r == null) {
			Toast.makeText(this, "请再次确认密码", Toast.LENGTH_SHORT).show();
		}
		//邮箱格式是否正确
		else if (m.equals("")||m == null||m.matches("\\w+@\\w+\\.\\w+")) {
			//boolean flag = service_User.register(getContent());
			//boolean flag = submit();
			
			if (submit()) {
				Toast.makeText(this,"注册成功", Toast.LENGTH_SHORT).show();
				finish();
			}else {
				Toast.makeText(this,"注册失败", Toast.LENGTH_SHORT).show();
			}
		}else {
			Toast.makeText(this, "邮箱格式不正确", Toast.LENGTH_SHORT).show();
		}

	} 

	//初始化控件
	private void init(){
		name = (EditText)findViewById(R.id.name);
		password = (EditText)findViewById(R.id.password);
		repassword = (EditText)findViewById(R.id.repassword);
		mail = (EditText)findViewById(R.id.mail);
		register = (Button)findViewById(R.id.register);
		
		error = (ImageView)findViewById(R.id.error);
		error.setVisibility(View.GONE);
		error_1 = (ImageView)findViewById(R.id.error_1);
		error_1.setVisibility(View.GONE);
		error_2 = (ImageView)findViewById(R.id.error_2);
		error_2.setVisibility(View.GONE);
		
		mail.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		
		name.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				//boolean flag = service_User.check(name.getText().toString());
				String flag = query(name.getText().toString());
				//Toast.makeText(Register.this, flag, Toast.LENGTH_SHORT).show();
				if (Integer.parseInt(flag) > 0) {
					error_1.setVisibility(View.GONE);
					register.setEnabled(true);
				}else {
					error_1.setVisibility(View.VISIBLE);
					register.setEnabled(false);
				}
			}
		});
		
		password.addTextChangedListener(new TextWatcher() {
			//输入字段有变化时
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
			}
			//输入字段有变化前
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {				
			}
			//输入字段有变化后
			@Override
			public void afterTextChanged(Editable s) {
				if (password.getText().toString().equals(repassword.getText().toString())) {
					error.setVisibility(View.GONE);
					register.setEnabled(true);
				}else {
					error.setVisibility(View.VISIBLE);
					register.setEnabled(false);
				}
			}
		});
		
		repassword.addTextChangedListener(new TextWatcher() {
			//输入字段有变化时
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
			}
			//输入字段有变化前
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {				
			}
			//输入字段有变化后
			@Override
			public void afterTextChanged(Editable s) {
				if (password.getText().toString().equals(repassword.getText().toString())) {
					error.setVisibility(View.GONE);
					register.setEnabled(true);
				}else {
					error.setVisibility(View.VISIBLE);
					register.setEnabled(false);
				}
			}
		});
		
	}
	private Info_Data getContent(){
		Info_Data info_Data = new Info_Data();
		info_Data.setName(name.getText().toString());
		info_Data.setPassword(password.getText().toString());
		info_Data.setMail(mail.getText().toString());
		info_Data.setImage("0");
		return info_Data;		
	}
	
	private UrlEncodedFormEntity makeEntity(){
		
		Info_Data info_Data = getContent();
		list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("name", info_Data.getName()));
		list.add(new BasicNameValuePair("password",info_Data.getPassword()));
		list.add(new BasicNameValuePair("mail", info_Data.getMail()));
		list.add(new BasicNameValuePair("image", "0"));
		
		try{
			return new UrlEncodedFormEntity(list,HTTP.UTF_8);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
		
	}
	private boolean submit(){
		String url = HttpUtil.BASE_URL+"servlet/userRegisterServlet";
		
		HttpPost request = HttpUtil.getHttpPost(url);
		request.setEntity(makeEntity());
		
		String result= HttpUtil.queryStringForPost(request);
		if(result!=null&&result.equals("1"))return true;
		return false;
	}
	private String query(String name){
		String queryString = "name="+name;
		String url = HttpUtil.BASE_URL+"servlet/checkUserNameServlet?"+queryString;
		return HttpUtil.queryStringForPost(url);
    }

}
