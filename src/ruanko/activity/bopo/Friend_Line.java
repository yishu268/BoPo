package ruanko.activity.bopo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ruanko.model.bopo.Line_Data;
import ruanko.service.bopo.Service_Node;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

//好友成长轴界面（Friend_Line）
public class Friend_Line extends Activity{
	//声明控件
	private ListView line = null;
	
	private Service_Node service_Node = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_line);
		service_Node = new Service_Node(this);
		init();
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
	//好友成长信息按钮点击事件
	public void onClick_Node(View view){
		Intent intent = new Intent(this,Friend_Node.class);
		startActivity(intent);
	}
	//初始化
	private void init(){
		line = (ListView)findViewById(R.id.line);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String id = bundle.getString("id");
		Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
		
		List<?> list = service_Node.line(1);
		
		List<HashMap<String, String>> myList = new ArrayList<HashMap<String, String>>();
		
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Line_Data line_Data = (Line_Data)list.get(i);
				//用HashMap做映射
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("text", line_Data.getTitle());
				map.put("textid", String.valueOf(line_Data.getNodeid()));
				myList.add(map);
			}
		}
		//用给ListView绑定数据
		SimpleAdapter adapter = new SimpleAdapter(this, 
				myList, //数据来源
				R.layout.friend_list_item, //ListView的XML实现
				new String[]{"text","textid"}, //动态数组与name对应的子项
				new int[]{R.id.text,R.id.textid});
		line.setAdapter(adapter);
		//为ListView添加点击事件
		line.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				TextView text = (TextView)arg1.findViewById(R.id.textid);
				String id = text.getText().toString();
				Intent intent = new Intent(Friend_Line.this,Friend_Node.class);
				intent.putExtra("id", id);
				startActivity(intent);
			}
		});
	}
}
