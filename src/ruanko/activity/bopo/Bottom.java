package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

public class Bottom extends Activity{
//下方功能栏点击事件
	public void onClick_Line(View view) {
		Intent intent = new Intent(this, Line.class);
		startActivity(intent);
	}
	public void onClick_Friend(View view) {
		Intent intent = new Intent(this, Friend.class);
		startActivity(intent);
	}
	public void onClick_Cross(View view) {
		Intent intent = new Intent(this, Cross.class);
		startActivity(intent);
	}
	public void onClick_Set(View view) {
		Intent intent = new Intent(this, Set.class);
		startActivity(intent);
	}
	/*
	 * 设置主题
	 */
	protected SharedPreferences mPref ;
	public static final String KEY_THEME_ID = "theme_id";
	
	public void onCreate(Bundle savedInstanceState) {
        mPref = PreferenceManager.getDefaultSharedPreferences(this);
        customTheme();
        super.onCreate(savedInstanceState);
    }
	
	protected void onNewIntent(Intent intent) {
        mPref = PreferenceManager.getDefaultSharedPreferences(this);
        customTheme();
	    super.onNewIntent(intent);  
	    setIntent(intent);
	    //here we can use getIntent() to get the extra data.
	}
	
    private void customTheme(){
        int id = mPref.getInt(KEY_THEME_ID, -1);
        if(id != -1){
            setTheme(id);
        }
        }
}
