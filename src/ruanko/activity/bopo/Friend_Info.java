package ruanko.activity.bopo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import ruanko.model.bopo.Data;
import ruanko.model.bopo.Info_Data;
import ruanko.util.bopo.HttpUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//显示好友信息界面（Friend_Info）
public class Friend_Info extends Bottom{

	//声明控件
	private TextView name = null;
	private TextView gender = null;
	private TextView location = null;
	private TextView mail = null;
	
	private ImageView head = null;
	
	private Button add = null;
	
	private int nameid = 0;
	
	private Info_Data info_Data = new Info_Data();
	
	private Data data = null;
	
	private List<NameValuePair> list = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_info);
		data = (Data)getApplication();
		init();
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
	//加为好友按钮点击事件
	public void onClick_Add(View view){
		String flag = submit();	
		if (Integer.parseInt(flag) > 0) {
			Toast.makeText(this, "用户添加成功", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this,Friend_Add.class);
			startActivity(intent);
			finish();
		}else {
			Toast.makeText(this, "用户添加失败", Toast.LENGTH_SHORT).show();
		}
	}
	//初始化
	private void init(){
		
		name = (TextView)findViewById(R.id.name);
		gender = (TextView)findViewById(R.id.gender);
		location = (TextView)findViewById(R.id.location);
		mail = (TextView)findViewById(R.id.mail);
		head = (ImageView)findViewById(R.id.head);
		add = (Button)findViewById(R.id.add);
		
		//接受传过来的id
		Bundle bundle = this.getIntent().getExtras();
		nameid = bundle.getInt("name_id", -1);
		
		//将json转化成实体类
		String json = query(String.valueOf(nameid));
		
		try {
			JSONObject object = new JSONObject(json);
			info_Data.setName(object.getString("userName"));
			info_Data.setGender(object.getString("userSex"));
			info_Data.setLocation(object.getString("userPlace"));
			info_Data.setMail(object.getString("userEmail"));
			info_Data.setImage(object.getString("userHeadImg"));
			
		} catch (Exception e) {
			Toast.makeText(this, "用户信息加载异常", Toast.LENGTH_SHORT).show();
		}
		
		load();
		String flag = check(String.valueOf(data.getPerson_id()),info_Data.getName());
		
		if (Integer.parseInt(flag)>0) {
			
		}else {
			Toast.makeText(this, "该用户已经是你的好友", Toast.LENGTH_SHORT).show();
			add.setEnabled(false);
		}
	}
	//将数据显示到界面上
	private void load() {

		name.setText(info_Data.getName());
		gender.setText(info_Data.getGender());
		location.setText(info_Data.getLocation());
		mail.setText(info_Data.getMail());
		head.setImageResource(data.getImage()[Integer.parseInt(info_Data.getImage())]);
	}
	//显示搜索结果信息
	private String query(String id){
		String queryString = "id="+id;
		String url = HttpUtil.BASE_URL+"servlet/selectFBIdServlet?"+queryString;
		return HttpUtil.queryStringForPost(url);
    }
	//检测是否已经为好友
	private String check(String id,String name){
		String queryString = "id="+id+"&fName="+name;
		String url = HttpUtil.BASE_URL+"servlet/checkFExistedServlet?"+queryString;
		return HttpUtil.queryStringForPost(url);
    }
	//添加好友功能
	private UrlEncodedFormEntity makeEntity(){
		
		list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("friendsId", String.valueOf(nameid)));
		list.add(new BasicNameValuePair("friendsName",info_Data.getName()));
		list.add(new BasicNameValuePair("friendsUId", String.valueOf(data.getPerson_id())));
		list.add(new BasicNameValuePair("friendsImg", info_Data.getImage()));

		
		try{
			return new UrlEncodedFormEntity(list,HTTP.UTF_8);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
		
	}
	private String submit(){
		String url = HttpUtil.BASE_URL+"servlet/addUserFriendsServlet";
		
		HttpPost request = HttpUtil.getHttpPost(url);
		request.setEntity(makeEntity());
		
		String result= HttpUtil.queryStringForPost(request);
		return result;
	}
}
