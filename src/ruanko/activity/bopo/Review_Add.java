package ruanko.activity.bopo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import ruanko.model.bopo.Data;
import ruanko.model.bopo.Review_Data;
import ruanko.service.bopo.Service_Review;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

//添加评论界面（Review_Add）
public class Review_Add extends Bottom{
	
	//声明控件
	private EditText review = null;
	private ListView review_list = null;
	
	private Service_Review service_Review = null;
	private Data data = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.review_add);
		
		//service_Review = new Service_Review(this);
		data = (Data)getApplication();
		list();     //评论列表
		init();
	}
	//完成按钮点击事件
	public void onClick_Finish(View view){
		//Intent intent = new Intent(this,Node_View.class);
		//tartActivity(intent);
		finish();
	}
	
	private void list() {
		//给ListView添加监听器
				review_list = (ListView)findViewById(R.id.review_list);
				if (review_list == null)
					return;
				//第一步：获得数据源（model）
				List<?> reviewList = new ArrayList<Review_Data>();
				reviewList = service_Review.show1(data.getNode_id());
				List<HashMap<String, Object>> myList = new ArrayList<HashMap<String, Object>>();
				
				if (reviewList != null) {
					for (int i = 0; i < reviewList.size(); i++) {
						Review_Data review_Data = (Review_Data)reviewList.get(i);
						//Toast.makeText(this, String.valueOf(friendList.size()), Toast.LENGTH_SHORT).show();
						//用HashMap做映射
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("r_name", review_Data.getReviewer_name());
						map.put("r_info", review_Data.getReview_info());
						map.put("r_time", review_Data.getReview_time());
						myList.add(map);
					}
				}
				//用给ListView绑定数据
				SimpleAdapter adapter = new SimpleAdapter(this, 
						myList, //数据来源
						R.layout.review_list_item, //ListView的XML实现
						new String[]{"r_name","r_info","r_time"}, //动态数组与name对应的子项
						new int[]{R.id.r_name,R.id.r_info,R.id.r_time});
				review_list.setAdapter(adapter);
		
	}
	//发送按钮点击事件
			public void onClick_Send(View view){
				String r = review.getText().toString();
				
				//验证评论是否为空
				if (r.equals("")||r == null) {
					Toast.makeText(this, "评论不能为空", Toast.LENGTH_SHORT).show();
				}
				 
				boolean flag = service_Review.review(getContent());
				if(flag){
					Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
				}else {
					Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
				}
				review.setText("");
			}
			private void init(){
				review = (EditText)findViewById(R.id.review);
			}
			
		//获取评论相关信息
			private Review_Data getContent(){
				Review_Data review_Data = new Review_Data();
				
				//获取当前时间
				SimpleDateFormat formatter=new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
				Date curDate=new Date(System.currentTimeMillis());
				//通过person_id获取评论者名字
				String username = service_Review.reviewer_name(data.getPerson_id());
				
				review_Data.setReview_info(review.getText().toString());
				review_Data.setReview_time(formatter.format(curDate));
				review_Data.setReviewer_name(username);
				review_Data.setNode_id(data.getNode_id());
				return review_Data;		
			}
	}

