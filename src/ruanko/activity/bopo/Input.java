package ruanko.activity.bopo;

import ruanko.model.bopo.Info_Data;
import ruanko.service.bopo.Service_User;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Input extends Activity{

	private EditText name = null;
	private EditText password = null;
	private EditText mail = null;
	private EditText gender = null;
	private EditText phone = null;
	private EditText image = null;
	private EditText location = null;
	private EditText age = null;
	private EditText birth = null;
	private Service_User service_User = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input);
		service_User = new Service_User(this); 
		init();
	}
	
	public void onClick_Save(View view){
		service_User.input(getContent());
	}
	
	private void init(){
		name = (EditText)findViewById(R.id.name);
		password = (EditText)findViewById(R.id.password);
		mail = (EditText)findViewById(R.id.mail);
		gender = (EditText)findViewById(R.id.gender);
		phone = (EditText)findViewById(R.id.phone);
		image = (EditText)findViewById(R.id.image);
		location = (EditText)findViewById(R.id.location);
		age = (EditText)findViewById(R.id.age);
		birth = (EditText)findViewById(R.id.birth);
	}
	
	private Info_Data getContent(){
		Info_Data info_Data = new Info_Data();
		info_Data.setName(name.getText().toString());
		info_Data.setPassword(password.getText().toString());
		info_Data.setMail(mail.getText().toString());
		info_Data.setGender(gender.getText().toString());
		info_Data.setPhone(phone.getText().toString());
		info_Data.setImage(image.getText().toString());
		info_Data.setLocation(location.getText().toString());
		info_Data.setAge(age.getText().toString());
		info_Data.setBirth(birth.getText().toString());
		return info_Data;		
	}

}
