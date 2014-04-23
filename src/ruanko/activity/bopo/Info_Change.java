package ruanko.activity.bopo;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import ruanko.model.bopo.Data;
import ruanko.model.bopo.Info_Data;
import ruanko.service.bopo.Service_Friend;
import ruanko.service.bopo.Service_User;
import android.app.Activity;
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
public class Info_Change extends Activity{
	//声明控件
	private TextView name = null;
	private TextView age = null;
	
	private EditText phone = null;
	private Spinner location = null;
	private EditText birth = null;
	private EditText mail = null;
	
	private RadioGroup gender = null;
	
	private ImageButton head = null;
	
	private Service_Friend service_Friend = null;
	private Service_User service_User = null;
	private Data data = null;
	
	private int Year;
	private int mYear;
	private int mMonth;
	private int mDay;
	private int age1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_change);
		service_Friend = new Service_Friend(this);
		service_User = new Service_User(this);
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
		Info_Data info_Data = new Info_Data();
		RadioButton rButton = (RadioButton)findViewById(gender.getCheckedRadioButtonId());
		
		if (mail.getText().toString().matches("\\w+@\\w+\\.\\w+")) {		
			info_Data.setGender(rButton.getText().toString());
			info_Data.setAge(age.getText().toString());
			info_Data.setPhone(phone.getText().toString());
			info_Data.setLocation(location.getSelectedItem().toString());
			info_Data.setBirth(birth.getText().toString());
			info_Data.setMail(mail.getText().toString());
			info_Data.setId(data.getPerson_id());
			info_Data.setImage(String.valueOf(data.getHead_id()));
			
			boolean flag = service_User.update(info_Data);
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
		Info_Data info_Data = new Info_Data();
		info_Data = service_Friend.getId(data.getPerson_id());
		int head1 = Integer.parseInt(info_Data.getImage());
		name.setText(info_Data.getName());
		age.setText(info_Data.getAge());
		phone.setText(info_Data.getPhone());
		location.setSelection(0);
		birth.setText(info_Data.getBirth());
		mail.setText(info_Data.getMail());
		head.setImageResource(data.getImage()[head1]);
		
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
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            age1 = Year - mYear;
            update();
        }
        private void update(){
        	birth.setText(mYear + "-" + mMonth + "-" + mDay);
        	age.setText(String.valueOf(age1));
        }
    };			
}
