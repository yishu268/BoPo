package ruanko.activity.bopo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ruanko.model.bopo.Data;
import ruanko.model.bopo.Friend_Data;
import ruanko.service.bopo.Service_Friend;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

//好友界面（Friend）
public class Friend extends Bottom{

	
	private ListView friend_list = null;
	
	private Service_Friend service_Friend = null;
	
	private Data data = null;
	
	private String fid = null;
	
	public static final int OPTION_DIALOG = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend);
		service_Friend = new Service_Friend(this);
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

		//给ListView添加监听器
		friend_list = (ListView)findViewById(R.id.friend_list);
		if (friend_list == null)
			return;
		//第一步：获得数据源（model）
		List<?> friendList = new ArrayList<Friend_Data>();
		friendList = service_Friend.show(data.getPerson_id());
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
		friend_list.setOnItemLongClickListener(new OnItemLongClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				TextView text = (TextView)view.findViewById(R.id.textid);
				fid = text.getText().toString();
				//Toast.makeText(Friend.this, "111", Toast.LENGTH_SHORT).show();
				showDialog(OPTION_DIALOG);

				return false;
			}
		});
	}
	protected Dialog onCreateDialog(int id) {

		Dialog dialog;
		switch (id) {
		case OPTION_DIALOG:
			dialog = opDialog();
			break;

		default:
			dialog = null;
		}
		return dialog;
	}
	private Dialog opDialog(){
		final Dialog opDialog;
		View opDialogView = null;
		LayoutInflater li = LayoutInflater.from(this);
		opDialogView = li.inflate(R.layout.option_dialog, null);
		
		opDialog = new AlertDialog.Builder(this).setView(opDialogView).create();
		
		Button delete = (Button)opDialogView.findViewById(R.id.delete);
		Button info = (Button)opDialogView.findViewById(R.id.info);
		
		delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				service_Friend.delete(data.getPerson_id(), Integer.parseInt(fid));
				opDialog.dismiss();
				init();
			}
			
		});
		
		info.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(Friend.this, Friend_Info_V.class);
				intent.putExtra("id", fid);
				opDialog.dismiss();
				startActivity(intent);
			}
			
		});
		
		return opDialog;	
	}
}
