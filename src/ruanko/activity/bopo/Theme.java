package ruanko.activity.bopo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//������棨Theme��
public class Theme extends Bottom{
	
	private Button simple = null;//��Լ��ť
	private Button colorful = null;//����ȡ��
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);       
		setContentView(R.layout.theme);
		init();
	}
	//����
	@Override
	protected void onNewIntent(Intent intent) {
	    super.onNewIntent(intent);  
	    setIntent(intent);
		init();
	    //here we can use getIntent() to get the extra data.
	}
	private void init(){
		simple = (Button)findViewById(R.id.simple);
		colorful = (Button)findViewById(R.id.colorful);
		
		simple.setOnClickListener(new ButtonSimpleListener());
		colorful.setOnClickListener(new ButtonColorfulListener());
		
	}
	//simple��ť�ڲ���
	//@SuppressLint("NewApi") 
	class ButtonSimpleListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = mPref.getInt(KEY_THEME_ID, -1);
            id = R.style.theme1;
            mPref.edit().putInt(KEY_THEME_ID, id).commit();
            
            /**lineҳ���޷��ı�*/
            Intent intent = new Intent(Theme.this,Theme.class);            
            startActivity(intent);
            finish();
            }
		}
	
	//colorful��ť�ڲ���
	class ButtonColorfulListener implements OnClickListener{

		//@SuppressLint("NewApi") @Override
		public void onClick(View v) {
            int id = mPref.getInt(KEY_THEME_ID, -1);
            id = R.style.theme2;
            mPref.edit().putInt(KEY_THEME_ID, id).commit();

            /**lineҳ���޷��ı�*/
 			Intent intent = new Intent(Theme.this,Theme.class);                       
            startActivity(intent);
            finish();

		}
		
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Set.class);
		startActivity(intent);
		finish();
	}
}
