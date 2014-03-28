package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

//�û�����������棨Friend_Add_Result��
public class Friend_Add_Result extends Activity{

	//����ListView
	private ListView result = null;
	
	private int[] id = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add_result);
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
		if (result == null)
			return;
		//��һ�����������Դ��model��
		//ArrayList<Friend_Info_Data> data = (ArrayList<Friend_Info_Data>)getIntent().getSerializableExtra("name");
		
		Bundle bundle = this.getIntent().getExtras();
		id = bundle.getIntArray("id");
				
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.friend_list_item,get(id));
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		result.setAdapter(adapter);
		//ΪListView��ӵ���¼�
		result.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				TextView text = (TextView)arg1.findViewById(R.id.text);
				String name = text.getText().toString();
				int name_id = Integer.valueOf(name).intValue(); 
			    //Toast.makeText(Friend_Add_Result.this, name, Toast.LENGTH_SHORT).show();
				//��id���ݵ�info
				Intent intent = new Intent(Friend_Add_Result.this,Friend_Info.class);
				Bundle bundle = new Bundle();
				bundle.putInt("name_id", name_id);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}
	
	private String[] get(int[] id){
		String[] text = new String[10];
		for (int i = 0; i < 10 ; i++) {
			text[i] = String.valueOf(id[i]);
		}
		return text;
		
	}
}
