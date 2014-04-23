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

//���ѳɳ�����棨Friend_Line��
public class Friend_Line extends Activity{
	//�����ؼ�
	private ListView line = null;
	
	private Service_Node service_Node = null;
	//private Service_Friend service_Friend = null;
	
	//private Data data = null;
	
	private String id = null;
	//private String id2 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_line);
		service_Node = new Service_Node(this);
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
		id = bundle.getString("id");
		Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
		
		List<?> list = service_Node.line(Integer.parseInt(id));
		
		List<HashMap<String, String>> myList = new ArrayList<HashMap<String, String>>();
		
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Line_Data line_Data = (Line_Data)list.get(i);
				//��HashMap��ӳ��
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("text", line_Data.getTitle());
				map.put("textid", String.valueOf(line_Data.getNodeid()));
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
}
