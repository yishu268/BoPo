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

//�û�����������棨Friend_Add_Result��
public class Friend_Add_Result extends Bottom{

	//����ListView
	private ListView result = null;
	
	private Data data = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add_result);
		data = (Data)getApplication();
		init();
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
	//���غ����б�ť����¼�
	public void onClick_Back_Friend(View view){
		Intent intent = new Intent(this,Friend.class);
		startActivity(intent);
		finish();
	}
	
	//��ListView��ֵ ��ʼ�����ݰ�
	private void init() {

		//��ListView��Ӽ�����
		result = (ListView)findViewById(R.id.result);
		
		//��һ�����������Դ��model��
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String json = bundle.getString("json");
		
		if (json.equals("")||json == null) {
			Toast.makeText(this, "δ�ҵ������������û�", Toast.LENGTH_SHORT).show();
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
					myList, //������Դ
					R.layout.friend_list_item, //ListView��XMLʵ��
					new String[]{"head","text","textid"}, //��̬������name��Ӧ������
					new int[]{R.id.head,R.id.text,R.id.textid});
			result.setAdapter(adapter);
		}

		//ΪListView��ӵ���¼�
		result.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				TextView text = (TextView)arg1.findViewById(R.id.textid);
				String name = text.getText().toString();
				
				int name_id = Integer.valueOf(name).intValue();
				
				//��id���ݵ�info
				Intent intent = new Intent(Friend_Add_Result.this,Friend_Info.class);
				Bundle bundle = new Bundle();
				bundle.putInt("name_id", name_id);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}
}
