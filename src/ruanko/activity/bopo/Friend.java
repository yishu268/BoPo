package ruanko.activity.bopo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import ruanko.model.bopo.Data;
import ruanko.model.bopo.Friend_Data;
import ruanko.util.bopo.HttpUtil;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Toast;

//好友界面（Friend）
public class Friend extends Bottom{

	
	private ListView friend_list = null;
	
	private Data data = null;
	
	private String fid = null;
	
	public static final int OPTION_DIALOG = 1;
	
	private int remark_flag = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend);
		data = (Data)getApplication();
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

		//dialog设置
        final Dialog dialog = new Dialog(Friend.this, R.style.dialog_theme);
        dialog.setContentView(R.layout.option_dialog);
        dialog.setCanceledOnTouchOutside(true);
		
		//给ListView添加监听器
		String json = query(String.valueOf(data.getPerson_id()));
		
		List<Friend_Data> friendList = new ArrayList<Friend_Data>();

		try {
			JSONArray array = new JSONArray(json);
			for (int i = 0; i < array.length(); i++) {
				Friend_Data friend_Data = new Friend_Data();
				JSONObject object = array.getJSONObject(i);
				friend_Data.setFriendid(Integer.parseInt(object.getString("friendsId")));
				friend_Data.setName(object.getString("friendsName"));
				friend_Data.setRemark(object.getString("friendsRName"));			
				friend_Data.setImage(object.getString("friendsImg"));
				friendList.add(friend_Data);
				
			//Toast.makeText(this, ff, Toast.LENGTH_SHORT).show();
			}
		} catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(this, "好友添加异常！", Toast.LENGTH_SHORT).show();
		}
		
		
		
		friend_list = (ListView)findViewById(R.id.friend_list);
		/*if (friend_list == null)
			return;
		//第一步：获得数据源（model）
		List<?> friendList = new ArrayList<Friend_Data>();
		friendList = service_Friend.show(data.getPerson_id());*/
		List<HashMap<String, Object>> myList = new ArrayList<HashMap<String, Object>>();
		
		if (friendList != null) {
			for (int i = 0; i < friendList.size(); i++) {
				Friend_Data friend_Data = (Friend_Data)friendList.get(i);
				//Toast.makeText(this, String.valueOf(friendList.size()), Toast.LENGTH_SHORT).show();
				//用HashMap做映射
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("head", data.getImage()[Integer.parseInt(friend_Data.getImage())]);
				map.put("text", friend_Data.getName());
				map.put("textid", String.valueOf(friend_Data.getFriendid()));
				myList.add(map);
			}
		}
		//用给ListView绑定数据
		SimpleAdapter adapter = new SimpleAdapter(this, 
				myList, //数据来源
				R.layout.friend_list_item, //ListView的XML实现
				new String[]{"head","text","textid"}, //动态数组与name对应的子项
				new int[]{R.id.head,R.id.text,R.id.textid});
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
		//长按事件
		friend_list.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				TextView text = (TextView)view.findViewById(R.id.textid);
				fid = text.getText().toString();
				//Toast.makeText(Friend.this, "111", Toast.LENGTH_SHORT).show();
				//showDialog(OPTION_DIALOG);
				
                dialog.show();

				return false;
			}
		});
		Button delete = (Button)dialog.findViewById(R.id.delete);
		Button info = (Button)dialog.findViewById(R.id.info);
		Button remark = (Button)dialog.findViewById(R.id.remark);
		EditText remark_input = (EditText)dialog.findViewById(R.id.remark_input);
		remark_input.setVisibility(View.GONE);
		
		delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Toast.makeText(Friend.this, "删除好友失败", Toast.LENGTH_SHORT).show();
				String flag = delete(fid, String.valueOf(data.getPerson_id()));
				if (Integer.parseInt(flag) > 0) {
					Toast.makeText(Friend.this, "成功删除好友", Toast.LENGTH_SHORT).show();
					dialog.dismiss();
					init();
				}else {
					Toast.makeText(Friend.this, "删除好友失败", Toast.LENGTH_SHORT).show();
				}
			}
			
		});
		
		info.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(Friend.this, Friend_Info_V.class);
				intent.putExtra("id", fid);
				dialog.dismiss();
				startActivity(intent);
			}
			
		});		
		remark.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText remark_input = (EditText)dialog.findViewById(R.id.remark_input);
				if (remark_flag == 0) {
					remark_flag = 1;
					
					remark_input.setVisibility(View.VISIBLE);
				}else {
					remark_flag = 0;
					remark_input.setVisibility(View.GONE);
				}
			}		
		});
	}

	
	private String query(String id){
		String queryString = "id="+id;
		String url = HttpUtil.BASE_URL+"servlet/getFriendsListServlet?"+queryString;
		return HttpUtil.queryStringForPost(url);
    }
	private String delete(String friendid,String userid){
		String queryString = "friendsId="+friendid+"&userId="+userid;
		String url = HttpUtil.BASE_URL+"servlet/deleteUserFriendsServlet?"+queryString;
		return HttpUtil.queryStringForPost(url);
    }
}
