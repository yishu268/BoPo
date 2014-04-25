package ruanko.activity.bopo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import ruanko.model.bopo.Data;
import ruanko.model.bopo.Friend_Data;
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
public class Friend_Add_Result extends Bottom{

	//声明ListView
	private ListView result = null;
	
	private Data data = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add_result);
		data = (Data)getApplication();
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
		
		//第一步：获得数据源（model）
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String json = bundle.getString("json");
		
		if (json.equals("")||json == null) {
			Toast.makeText(this, "未找到符合条件的用户", Toast.LENGTH_SHORT).show();
		}
		else {
			List<Friend_Data> friendList = new ArrayList<Friend_Data>();
			
			try {
				JSONArray array = new JSONArray(json);
				for (int i = 0; i < array.length(); i++) {
					Friend_Data friend_Data = new Friend_Data();
					JSONObject object = array.getJSONObject(i);
					friend_Data.setFriendid(Integer.parseInt(object.getString("userId")));
					friend_Data.setName(object.getString("userName"));
					friend_Data.setImage(object.getString("userHImg"));
					friendList.add(friend_Data);
				}
			} catch (Exception e) {
				
				Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
			}
			
			
			
			List<HashMap<String, Object>> myList = new ArrayList<HashMap<String, Object>>();
			
			if (friendList != null) {
				for (int i = 0; i < friendList.size(); i++) {
					Friend_Data friend_Data = (Friend_Data)friendList.get(i);
					//info_Data = sFriend.getId(Integer.valueOf(id[i]).intValue());
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("head", data.getImage()[Integer.parseInt(friend_Data.getImage())]);
					map.put("text", friend_Data.getName());
					map.put("textid", String.valueOf(friend_Data.getFriendid()));
					myList.add(map);
				}
			}
			SimpleAdapter adapter = new SimpleAdapter(this, 
					myList, //数据来源
					R.layout.friend_list_item, //ListView的XML实现
					new String[]{"head","text","textid"}, //动态数组与name对应的子项
					new int[]{R.id.head,R.id.text,R.id.textid});
			result.setAdapter(adapter);
		}

		//为ListView添加点击事件
		result.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				TextView text = (TextView)arg1.findViewById(R.id.textid);
				String name = text.getText().toString();
				
				int name_id = Integer.valueOf(name).intValue();
				
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
