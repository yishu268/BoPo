package ruanko.activity.bopo;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

//���ѽ��棨Friend��
public class Friend extends Bottom{

	
	private ListView friend_list = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend);
		init();
	}
	
	//��Ӱ�ť����¼�
	public void onClick_Add(View view){
		Intent intent = new Intent(this,Friend_Add.class);
		startActivity(intent);
	}
	
	private void init() {
		int size = 1;
		//��ListView��Ӽ�����
		friend_list = (ListView)findViewById(R.id.friend_list);
		if (friend_list == null)
			return;
		//��һ�����������Դ��model��
		List<String> data = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			data.add("" + size++);
		}
		// �ڶ�����newһ����������controller��
	    // ����1��Context
	    // ����2��ListView��item����
	    // ����3�����������item�����µ��Ǹ��ؼ�id
	    // ����4����������
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				R.layout.friend_list_item, R.id.text, data);
		// ����������ListView������������view��
		friend_list.setAdapter(adapter);
		//ΪListView��ӵ���¼�
		friend_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(Friend.this,Friend_Line.class);
				startActivity(intent);
			}
		});
	}
}
