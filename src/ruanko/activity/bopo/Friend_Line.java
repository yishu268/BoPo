package ruanko.activity.bopo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import ruanko.model.bopo.Node_Data;
import ruanko.util.bopo.HttpUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

//���ѳɳ�����棨Friend_Line��
public class Friend_Line extends Bottom{
	//�����ؼ�
	private ListView line = null;
	
	private String userid = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_line);
		//service_Node = new Service_Node(this);
		//service_Friend = new Service_Friend(this);
		//data = (Data)getApplication();
		init();
	}
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
	//���ѳɳ���Ϣ��ť����¼�
	public void onClick_Node(View view){
		Intent intent = new Intent(this,Friend_Node.class);
		startActivity(intent);
	}
	//Dialog
	
	//��ʼ��
	private void init(){
		line = (ListView)findViewById(R.id.line);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		userid = bundle.getString("id");
		Toast.makeText(this, userid, Toast.LENGTH_SHORT).show();
		
		//List<?> list = service_Node.line(Integer.parseInt(id));
		
		String json = query(userid);
		
		List<Node_Data> nodeList = new ArrayList<Node_Data>();

		try {
			JSONArray array = new JSONArray(json);
			for (int i = 0; i < array.length(); i++) {
				Node_Data node_Data = new Node_Data();
				JSONObject object = array.getJSONObject(i);
				node_Data.setId(Integer.parseInt(object.getString("notesId")));
				node_Data.setTitle(object.getString("notesTitle"));
				node_Data.setDate(object.getString("notesTime"));
				nodeList.add(node_Data);
				
			//Toast.makeText(this, ff, Toast.LENGTH_SHORT).show();
			}
		} catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(this, "��������쳣��", Toast.LENGTH_SHORT).show();
		}
		
		List<HashMap<String, String>> myList = new ArrayList<HashMap<String, String>>();
		
		if (nodeList != null) {
			for (int i = 0; i < nodeList.size(); i++) {
				Node_Data node_Data = nodeList.get(i);
				//��HashMap��ӳ��
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("text", node_Data.getTitle());
				map.put("textid", String.valueOf(node_Data.getId()));
				myList.add(map);
			}
		}
		//�ø�ListView������
		SimpleAdapter adapter = new SimpleAdapter(this, 
				myList, //������Դ
				R.layout.friend_list_item, //ListView��XMLʵ��
				new String[]{"text","textid"}, //��̬������name��Ӧ������
				new int[]{R.id.text,R.id.textid});
		line.setAdapter(adapter);
		//ΪListView��ӵ���¼�
		line.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				TextView text = (TextView)arg1.findViewById(R.id.textid);
				String id1 = text.getText().toString();
				Intent intent = new Intent(Friend_Line.this,Friend_Node.class);
				intent.putExtra("id", id1);
				startActivity(intent);
			}
		});
	}
	
	private String query(String id){
		String queryString = "id="+id;
		String url = HttpUtil.BASE_URL+"servlet/getUserNotesListServlet?"+queryString;
		return HttpUtil.queryStringForPost(url);
    }
	
}
