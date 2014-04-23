package ruanko.activity.bopo;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

//成长信息添加界面（Node_Add）
public class Node_Add extends Activity{

	private Button date = null;
	
	private int mYear;
	private int mMonth;
	private int mDay;
	
	//private Data data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.node_add);
		init();
	}
	//完成按钮点击事件
	public void onClick_Finish(View view){
		finish();
	}
	private void init(){
		
		//Time time = new Time("gmt+8");
		//time.setToNow();
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		Date mDate = new Date();
		calendar.setTime(mDate);
		
		mYear = calendar.get(Calendar.YEAR);
		mMonth = calendar.get(Calendar.MONTH);
		mDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		date = (Button)findViewById(R.id.date);
	    date.setOnClickListener(new OnClickListener() {
			
				@Override
				public void onClick(View v) {
					DatePickerDialog datePickerDialog = new DatePickerDialog(Node_Add.this, 
							mDateSetListener, mYear, mMonth, mDay);
					datePickerDialog.show();
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
	         //age1 = Year - mYear;
	         update();
	     }
	     private void update(){
	     	date.setText(mYear + "-" + mMonth + "-" + mDay);
	     	//age.setText(String.valueOf(age1));
	     }
	 };

}
