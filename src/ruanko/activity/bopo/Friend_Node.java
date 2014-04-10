package ruanko.activity.bopo;

import ruanko.model.bopo.Node_Data;
import ruanko.service.bopo.Service_Node;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//好友成长记录界面（Friend_Node）
public class Friend_Node extends Activity{
	//声明控件
	private TextView title = null;
	private TextView text = null;
	
	private Service_Node service_Node = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_node);
		service_Node = new Service_Node(this);
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
		String id = bundle.getString("id");
		//Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
		
		Node_Data node_Data = new Node_Data();
		node_Data = service_Node.show(Integer.parseInt(id));
		title.setText(node_Data.getTitle());
		text.setText(node_Data.getText());
	}
}
