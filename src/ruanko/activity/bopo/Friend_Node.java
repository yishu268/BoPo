package ruanko.activity.bopo;

import org.json.JSONObject;

import ruanko.model.bopo.Node_Data;
import ruanko.util.bopo.HttpUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//好友成长记录界面（Friend_Node）
public class Friend_Node extends Bottom{
	//声明控件
	private TextView title = null;
	private TextView text = null;
	
	private Node_Data node_Data = new Node_Data();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_node);
		//service_Node = new Service_Node(this);
		init();
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
	//评论按钮点击事件
	public void onClick_Review(View view){
		Intent intent = new Intent(this,Review_Add.class);
		startActivity(intent);
	}
	//初始化
	private void init(){
		title = (TextView)findViewById(R.id.title);
		text = (TextView)findViewById(R.id.text);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String nodeid = bundle.getString("id");
		//Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
		
		String json = query(nodeid);
		
		try {
			JSONObject object = new JSONObject(json);
			node_Data.setId(Integer.parseInt(object.getString("id")));
			node_Data.setTitle(object.getString("notesTitle"));
			node_Data.setDate((object.getString("notesTime")));
			node_Data.setType((object.getString("notesType")));
			node_Data.setInfo(object.getString("notesInfo"));
			node_Data.setImage(object.getString("notesImg"));
			node_Data.setUser_id(object.getString("notesUserId"));
			Toast.makeText(this, object.getString("notesTitle"), Toast.LENGTH_SHORT).show();
			
		} catch (Exception e) {
			Toast.makeText(this, "用户信息加载异常", Toast.LENGTH_SHORT).show();
		}
		//node_Data = service_Node.show(Integer.parseInt(id));
		title.setText(node_Data.getTitle());
		text.setText(node_Data.getInfo());
	}
	
	private String query(String id){
		String queryString = "id="+id;
		String url = HttpUtil.BASE_URL+"servlet/showNBIdServlet?"+queryString;
		return HttpUtil.queryStringForPost(url);
    }
}
