package ruanko.activity.bopo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import ruanko.model.bopo.Data;
import ruanko.model.bopo.Info_Data;
import ruanko.util.bopo.HttpUtil;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

//个人信息修改界面（Info_Change）
public class Info_Change extends Bottom{
	//声明控件
	private TextView name = null;
	private TextView age = null;
	
	private EditText phone = null;
	private Spinner location = null;
	private EditText birth = null;
	private EditText mail = null;
	
	private RadioGroup gender = null;
	
	private ImageButton head = null;
	
	private Data data = null;
	
	private int Year;
	private int mYear;
	private int mMonth;
	private int mDay;
	private int age1;
	
	private List<NameValuePair> list = null;
	private Info_Data info_Data = new Info_Data();
	private Info_Data info_Data2 = new Info_Data();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_change);
		data = (Data)getApplication();
		init();
	}
	//重载获取数据
	@Override  
	protected void onNewIntent(Intent intent) {        
	    super.onNewIntent(intent);  
	    setIntent(intent);
		load();
		head.setImageResource(data.getImage()[data.getHead_id()]);
	    //here we can use getIntent() to get the extra data.
	}
	
	//头像按钮点击事件
	public void onClick_Head(View view){
		Intent intent = new Intent(this,Info_Head.class);
		startActivity(intent);
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Info.class);
		startActivity(intent);
		finish();
	}
	//保存按钮点击事件
	public void onClick_Save(View view){

		RadioButton rButton = (RadioButton)findViewById(gender.getCheckedRadioButtonId());
		
		if (mail.getText().toString().matches("\\w+@\\w+\\.\\w+")) {		
			info_Data2.setGender(rButton.getText().toString());
			info_Data2.setAge(age.getText().toString());
			info_Data2.setPhone(phone.getText().toString());
			info_Data2.setLocation(location.getSelectedItem().toString());
			info_Data2.setBirth(birth.getText().toString());
			info_Data2.setMail(mail.getText().toString());
			info_Data2.setId(data.getPerson_id());
			info_Data2.setImage(String.valueOf(data.getHead_id()));
			
			boolean flag = submit();
			if (flag) {
				Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(this,Info.class);
				startActivity(intent);
				finish();
			}else {
				Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
			}
		}else {
			Toast.makeText(this, "邮箱格式错误", Toast.LENGTH_SHORT).show();
		}
	}
	//初始化
	private void init(){
		name = (TextView)findViewById(R.id.name);
		age = (TextView)findViewById(R.id.age);
		phone = (EditText)findViewById(R.id.phone);
		location = (Spinner)findViewById(R.id.location);
		birth = (EditText)findViewById(R.id.birth);
		head = (ImageButton)findViewById(R.id.head);
		gender = (RadioGroup)findViewById(R.id.gender);
		mail = (EditText)findViewById(R.id.mail);
		load();
		
		Time time = new Time("GMT+8");
		time.setToNow();
		Year = time.year;
		//SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy");
		//date = sDateFormat.format(new java.util.Date());
	}
	//载入数据
	private void load(){

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
			Toast.makeText(this, "用户信息加载异常", Toast.LENGTH_SHORT).show();
		}
		name.setText(info_Data.getName());
		age.setText(info_Data.getAge());
		phone.setText(info_Data.getPhone());
		location.setSelection(0);
		birth.setText(info_Data.getBirth());
		mail.setText(info_Data.getMail());
		head.setImageResource(data.getImage()[Integer.parseInt(info_Data.getImage())]);
		
		if (info_Data.getGender() == null || info_Data.getGender().equals("")){
			RadioButton rb1 = (RadioButton)findViewById(R.id.female);
			rb1.setChecked(true);
		}else if(info_Data.getGender().equals("女")) {
			RadioButton rb2 = (RadioButton)findViewById(R.id.female);
			rb2.setChecked(true);
		}else {
			RadioButton rb3 = (RadioButton)findViewById(R.id.male);
			rb3.setChecked(true);
		}
		
		//初始化Calendar日历对象
		Calendar mCalendar = Calendar.getInstance(Locale.CHINA);
		Date mDate = new Date();//获取当前日期date对象
		mCalendar.setTime(mDate);//为calendar对象设置时间
		
		mYear = mCalendar.get(Calendar.YEAR);
		mMonth = mCalendar.get(Calendar.MONTH);
		mDay = mCalendar.get(Calendar.DAY_OF_MONTH);
		birth.setInputType(InputType.TYPE_NULL);
		birth.setCursorVisible(false);
        birth.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DatePickerDialog datePickerDialog = new DatePickerDialog(Info_Change.this, 
						mDateSetListener, mYear, mMonth, mDay);
				datePickerDialog.show();
			}
		});
        birth.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				DatePickerDialog datePickerDialog = new DatePickerDialog(Info_Change.this, 
						mDateSetListener, mYear, mMonth, mDay);
				//datePickerDialog.show();
				if (hasFocus) {
					datePickerDialog.show();
				}else {
					
				}
			}
		});	
	}

    // 时间选择器
    private DatePickerDialog.OnDateSetListener mDateSetListener = 
    		new DatePickerDialog.OnDateSetListener() {
    	@Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear + 1;
            mDay = dayOfMonth;
            age1 = Year - mYear;
            update();
        }
        private void update(){
        	birth.setText(mYear + "-" + mMonth + "-" + mDay);
        	age.setText(String.valueOf(age1));
        }
    };
    
	private String query(String id){
		String queryString = "id="+id;
		String url = HttpUtil.BASE_URL+"servlet/selectFBIdServlet?"+queryString;
		return HttpUtil.queryStringForPost(url);
    }
	
	private UrlEncodedFormEntity makeEntity(){

		list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("id", String.valueOf(data.getPerson_id())));
		list.add(new BasicNameValuePair("userHeadImg", info_Data2.getImage()));
		list.add(new BasicNameValuePair("userSex",info_Data2.getGender()));
		list.add(new BasicNameValuePair("userMobile", info_Data2.getPhone()));
		list.add(new BasicNameValuePair("userPlace", info_Data2.getLocation()));
		list.add(new BasicNameValuePair("userBirthday", info_Data2.getBirth()));
		list.add(new BasicNameValuePair("userEmail", info_Data2.getMail()));
		list.add(new BasicNameValuePair("userAge", info_Data2.getAge()));
		
		try{
			return new UrlEncodedFormEntity(list,HTTP.UTF_8);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
		
	}
	private boolean submit(){
		String url = HttpUtil.BASE_URL+"servlet/updateUserMasgServlet";
		
		HttpPost request = HttpUtil.getHttpPost(url);
		request.setEntity(makeEntity());
		
		String result= HttpUtil.queryStringForPost(request);
		if(result!=null&&result.equals("1"))return true;
		return false;
	}
}
