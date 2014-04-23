package ruanko.activity.bopo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ruanko.model.bopo.Info_Data;
import ruanko.service.bopo.Service_Friend;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

//用户搜索结果界面（Friend_Add_Result）
public class Friend_Add_Result extends Activity{

	//声明ListView
	private ListView result = null;
	
	private String[] id = null;
	
	private Service_Friend sFriend = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add_result);
		sFriend = new Service_Friend(this);
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
		
		Bundle bundle = this.getIntent().getExtras();
		id = bundle.getStringArray("id");
		
		if (id == null||id.length == 0) {
			Toast.makeText(this, "未找到符合条件的用户", Toast.LENGTH_SHORT).show();
		}
		
		Info_Data info_Data = new Info_Data();
		
		
		List<HashMap<String, String>> myList = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < id.length; i++) {
			info_Data = sFriend.getId(Integer.valueOf(id[i]).intValue());
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("text", info_Data.getName());
			map.put("textid", String.valueOf(info_Data.getId()));
			myList.add(map);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, 
				myList, //数据来源
				R.layout.friend_list_item, //ListView的XML实现
				new String[]{"text","textid"}, //动态数组与name对应的子项
				new int[]{R.id.text,R.id.textid});
		result.setAdapter(adapter);
		//为ListView添加点击事件
		result.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				TextView text = (TextView)arg1.findViewById(R.id.textid);
				String name = text.getText().toString();
				int name_id = Integer.valueOf(name).intValue(); 
			    //Toast.makeText(Friend_Add_Result.this, name, Toast.LENGTH_SHORT).show();
				//将id传递到info
				Intent intent = new Intent(Friend_Add_Result.this,Friend_Info.class);
				Bundle bundle = new Bundle();
				bundle.putInt("name_id", name_id);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}
}
