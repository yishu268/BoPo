package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
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
}
