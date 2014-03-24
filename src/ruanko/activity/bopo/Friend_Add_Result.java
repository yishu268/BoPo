package ruanko.activity.bopo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//�û�����������棨Friend_Add_Result��
public class Friend_Add_Result extends Activity{

	//����ListView
	private ListView result = null;
	
	private int[] data = null;
	
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
		
		Bundle id = this.getIntent().getExtras();
		data = id.getIntArray("name");
				
		
		List<String> data_add = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			data_add.add("" + data[i]);
		}
		// �ڶ�����newһ����������controller��
	    // ����1��Context
	    // ����2��ListView��item����
	    // ����3�����������item�����µ��Ǹ��ؼ�id
	    // ����4����������
		//ArrayAdapter<Friend_Info_Data> adapter = new ArrayAdapter<Friend_Info_Data>(this, 
		//		R.layout.friend_list_item, R.id.text, data);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				R.layout.friend_list_item, R.id.text, data_add);
		// ����������ListView������������view��
		result.setAdapter(adapter);
		//ΪListView��ӵ���¼�
		result.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(Friend_Add_Result.this,Friend_Info.class);
				startActivity(intent);
			}
		});
	}
}
