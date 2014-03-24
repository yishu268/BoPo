package ruanko.activity.bopo;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

//好友界面（Friend）
public class Friend extends Bottom{

	
	private ListView friend_list = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend);
		init();
	}
	
	//添加按钮点击事件
	public void onClick_Add(View view){
		Intent intent = new Intent(this,Friend_Add.class);
		startActivity(intent);
	}
	
	private void init() {
		int size = 1;
		//给ListView添加监听器
		friend_list = (ListView)findViewById(R.id.friend_list);
		if (friend_list == null)
			return;
		//第一步：获得数据源（model）
		List<String> data = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			data.add("" + size++);
		}
		// 第二步：new一个适配器（controller）
	    // 参数1：Context
	    // 参数2：ListView的item布局
	    // 参数3：数据填充在item布局下的那个控件id
	    // 参数4：填充的数据
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				R.layout.friend_list_item, R.id.text, data);
		// 第三步：给ListView设置适配器（view）
		friend_list.setAdapter(adapter);
		//为ListView添加点击事件
		friend_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(Friend.this,Friend_Line.class);
				startActivity(intent);
			}
		});
	}
}
