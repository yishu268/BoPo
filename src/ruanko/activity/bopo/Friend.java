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

//���ѽ��棨Friend��
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
	//���ػ�ȡ����
		@Override  
		protected void onNewIntent(Intent intent) {        
		    super.onNewIntent(intent);  
		    setIntent(intent);
			init();
		    //here we can use getIntent() to get the extra data.
		}
	
	//��Ӱ�ť����¼�
	public void onClick_Add(View view){
		Intent intent = new Intent(this,Friend_Add.class);
		startActivity(intent);
	}
	
	private void init() {

		//��ListView��Ӽ�����
		friend_list = (ListView)findViewById(R.id.friend_list);
		if (friend_list == null)
			return;
		//��һ�����������Դ��model��
		List<?> friendList = new ArrayList<Friend_Data>();
		friendList = service_Friend.show();
		List<HashMap<String, String>> myList = new ArrayList<HashMap<String, String>>();
		
		if (friendList != null) {
			for (int i = 0; i < friendList.size(); i++) {
				Friend_Data friend_Data = (Friend_Data)friendList.get(i);
				//��HashMap��ӳ��
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("text", friend_Data.getName());
				map.put("textid", String.valueOf(friend_Data.getId()));
				myList.add(map);
			}
		}
		//�ø�ListView������
		SimpleAdapter adapter = new SimpleAdapter(this, 
				myList, //������Դ
				R.layout.friend_list_item, //ListView��XMLʵ��
				new String[]{"text","textid"}, //��̬������name��Ӧ������
				new int[]{R.id.text,R.id.textid});
		friend_list.setAdapter(adapter);
		//ΪListView��ӵ���¼�
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
