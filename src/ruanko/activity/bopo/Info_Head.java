package ruanko.activity.bopo;

import java.util.ArrayList;
import java.util.HashMap;

import ruanko.model.bopo.Data;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

//头像选择界面（Info_Head）
public class Info_Head extends Bottom{
	//声明控件
	private GridView head = null;

	private Data data = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_head);
		data = (Data)getApplication();
		init();
	}
	
	//返回按钮点击事件
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Info_Change.class);
		startActivity(intent);
		finish();
	}
	//初始化
	private void init(){
		head = (GridView)findViewById(R.id.head);
		ArrayList<HashMap<String, Object>> imageList = new ArrayList<HashMap<String,Object>>();
		for (int i = 0; i < 10; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("head", data.getImage()[i]); //添加图像资源ID
			imageList.add(map);
		}
		SimpleAdapter sImage = new SimpleAdapter(this, 
				imageList, //数据来源
				R.layout.head_grid, //grid的XML实现
				new String[]{"head"}, //动态数组与ImageItem对应的子项
				new int[]{R.id.head_image}); //grid的XML文件里面的ID
		head.setAdapter(sImage); //添加并且显示
		head.setOnItemClickListener(new HeadSelect());
	}	
	//头像选择
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
