package ruanko.activity.bopo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import ruanko.util.bopo.HttpUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

//按条件添加好友界面（Friend_Add_Condition）
public class Friend_Add_Condition extends Bottom{

	//声明控件
	private EditText age = null;
	private RadioGroup gender = null;
	private Spinner location = null;
	
	private List<NameValuePair> list = null;
	//private Service_Friend service_Friend = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add_condition);
		//service_Friend = new Service_Friend(this);
		init();
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
	//搜索按钮点击事件
	public void onClick_Search(View view){

		String age_db = age.getText().toString();

		if (age_db.equals("")||age_db == null) {
			Toast.makeText(this, "请输入年龄", Toast.LENGTH_SHORT).show();
		}else {
			
			String json = submit();
			
			if(json.equals("")||json == null){
				Toast.makeText(this, "未找到相关用户", Toast.LENGTH_SHORT).show();
			}else {
				Intent intent = new Intent(this,Friend_Add_Result.class);
				intent.putExtra("json", json);
				startActivity(intent);
				finish();
			}
		}
	}

	//初始化
	private void init(){
		age = (EditText)findViewById(R.id.age);
		gender = (RadioGroup)findViewById(R.id.gender);
		location = (Spinner)findViewById(R.id.location);
	}
	
	private UrlEncodedFormEntity makeEntity(){
		
		RadioButton rButton = (RadioButton)findViewById(gender.getCheckedRadioButtonId());
		
		list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("userAge", age.getText().toString()));
		list.add(new BasicNameValuePair("userSex",rButton.getText().toString()));
		list.add(new BasicNameValuePair("userPlace", location.getSelectedItem().toString()));

		
		try{
			return new UrlEncodedFormEntity(list,HTTP.UTF_8);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
		
	}
	private String submit(){
		String url = HttpUtil.BASE_URL+"servlet/selectFBConServlet";
		
		HttpPost request = HttpUtil.getHttpPost(url);
		request.setEntity(makeEntity());
		
		String result= HttpUtil.queryStringForPost(request);
		return result;
	}
	
}
