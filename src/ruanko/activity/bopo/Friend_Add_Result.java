package ruanko.activity.bopo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//用户搜索结果界面（Friend_Add_Result）
public class Friend_Add_Result extends Activity{

	//声明ListView
	private ListView result = null;
	
	private int[] data = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add_result);
		init();
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
	//返回好友列表按钮点击事件
	public void onClick_Back_Friend(View view){
		Intent intent = new Intent(this,Friend.class);
		startActivity(intent);
		finish();
	}
	//给ListView赋值 初始化数据绑定
	private void init() {

		//给ListView添加监听器
		result = (ListView)findViewById(R.id.result);
		if (result == null)
			return;
		//第一步：获得数据源（model）
		//ArrayList<Friend_Info_Data> data = (ArrayList<Friend_Info_Data>)getIntent().getSerializableExtra("name");
		
		Bundle id = this.getIntent().getExtras();
		data = id.getIntArray("name");
				
		
		List<String> data_add = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			data_add.add("" + data[i]);
		}
		// 第二步：new一个适配器（controller）
	    // 参数1：Context
	    // 参数2：ListView的item布局
	    // 参数3：数据填充在item布局下的那个控件id
	    // 参数4：填充的数据
		//ArrayAdapter<Friend_Info_Data> adapter = new ArrayAdapter<Friend_Info_Data>(this, 
		//		R.layout.friend_list_item, R.id.text, data);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				R.layout.friend_list_item, R.id.text, data_add);
		// 第三步：给ListView设置适配器（view）
		result.setAdapter(adapter);
		//为ListView添加点击事件
		result.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(Friend_Add_Result.this,Friend_Info.class);
				startActivity(intent);
			}
		});
	}
}
