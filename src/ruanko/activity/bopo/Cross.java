package ruanko.activity.bopo;

import java.util.Calendar;

import ruanko.activity.bopo.Bottom;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;

//��Խ���棨Cross��
public class Cross extends Bottom{
	
	private EditText dateEt=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cross);
		
		dateEt=(EditText)findViewById(R.id.dateEt);
		DatePicker datePicker=(DatePicker)findViewById(R.id.datech);
		Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int monthOfYear=calendar.get(Calendar.MONTH);
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, monthOfYear, dayOfMonth, new OnDateChangedListener(){

            public void onDateChanged(DatePicker view, int year,
                    int monthOfYear, int dayOfMonth) {
                dateEt.setText("��ѡ��������ǣ�"+year+"��"+(monthOfYear+1)+"��"+dayOfMonth+"�ա�");
            }
            
        });
	}
	//��Խ��ť����¼�
	public void onClick_Go(View view) {
		Intent intent = new Intent(this,Node_View.class);
		startActivity(intent);
	}
}
