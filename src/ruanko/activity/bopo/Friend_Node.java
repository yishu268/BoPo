package ruanko.activity.bopo;

import ruanko.model.bopo.Node_Data;
import ruanko.service.bopo.Service_Node;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//���ѳɳ���¼���棨Friend_Node��
public class Friend_Node extends Activity{
	//�����ؼ�
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
	//���ذ�ť����¼�
	public void onClick_Back(View view){
		finish();
	}
	//���۰�ť����¼�
	public void onClick_Review(View view){
		Intent intent = new Intent(this,Review_Add.class);
		startActivity(intent);
	}
	//��ʼ��
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
