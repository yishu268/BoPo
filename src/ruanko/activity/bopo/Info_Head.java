package ruanko.activity.bopo;

import java.util.ArrayList;
import java.util.HashMap;

import ruanko.model.bopo.Data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

//ͷ��ѡ����棨Info_Head��
public class Info_Head extends Activity{
	//�����ؼ�
	private GridView head = null;

	private Data data = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_head);
		data = (Data)getApplication();
		init();
	}
	
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Info_Change.class);
		startActivity(intent);
		finish();
	}
	//��ʼ��
	private void init(){
		head = (GridView)findViewById(R.id.head);
		ArrayList<HashMap<String, Object>> imageList = new ArrayList<HashMap<String,Object>>();
		for (int i = 0; i < 10; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("head", data.getImage()[i]); //���ͼ����ԴID
			imageList.add(map);
		}
		SimpleAdapter sImage = new SimpleAdapter(this, 
				imageList, //������Դ
				R.layout.head_grid, //grid��XMLʵ��
				new String[]{"head"}, //��̬������ImageItem��Ӧ������
				new int[]{R.id.head_image}); //grid��XML�ļ������ID
		head.setAdapter(sImage); //��Ӳ�����ʾ
		head.setOnItemClickListener(new HeadSelect());
	}	
	//ͷ��ѡ��
	class HeadSelect implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			data.setHead_id(position);
			Intent intent = new Intent(Info_Head.this,Info_Change.class);
			startActivity(intent);
			finish();
			// TODO Auto-generated method stub
			
		}
		
	}
}
