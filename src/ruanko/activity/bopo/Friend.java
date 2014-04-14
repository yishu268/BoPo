package ruanko.activity.bopo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ruanko.model.bopo.Friend_Data;
import ruanko.service.bopo.Service_Friend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

//好友界面（Friend）
public class Friend extends Bottom{

	
	private ListView friend_list = null;
	
	private Service_Friend service_Friend = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend);
		service_Friend = new Service_Friend(this);
		init();
	}
	//重载获取数据
		@Override  
		protected void onNewIntent(Intent intent) {        
		    super.onNewIntent(intent);  
		    setIntent(intent);
			init();
		    //here we can use getIntent() to get the extra data.
		}
	
	//添加按钮点击事件
	public void onClick_Add(View view){
		Intent intent = new Intent(this,Friend_Add.class);
		startActivity(intent);
	}
	
	private void init() {

		//给ListView添加监听器
		friend_list = (ListView)findViewById(R.id.friend_list);
		if (friend_list == null)
			return;
		//第一步：获得数据源（model）
		List<?> friendList = new ArrayList<Friend_Data>();
		friendList = service_Friend.show();
		List<HashMap<String, String>> myList = new ArrayList<HashMap<String, String>>();
		
		if (friendList != null) {
			for (int i = 0; i < friendList.size(); i++) {
				Friend_Data friend_Data = (Friend_Data)friendList.get(i);
				Toast.makeText(this, String.valueOf(friendList.size()), Toast.LENGTH_SHORT).show();
				//用HashMap做映射
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("text", friend_Data.getName());
				map.put("textid", String.valueOf(friend_Data.getId()));
				myList.add(map);
			}
		}
		//用给ListView绑定数据
		SimpleAdapter adapter = new SimpleAdapter(this, 
				myList, //数据来源
				R.layout.friend_list_item, //ListView的XML实现
				new String[]{"text","textid"}, //动态数组与name对应的子项
				new int[]{R.id.text,R.id.textid});
		friend_list.setAdapter(adapter);
		//为ListView添加点击事件
		friend_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				TextView text = (TextView)arg1.findViewById(R.id.textid);
				String id = text.getText().toString();
				Intent intent = new Intent(Friend.this,Friend_Line.class);
				intent.putExtra("id", id);
				startActivity(intent);
			}
		});
	}
}
