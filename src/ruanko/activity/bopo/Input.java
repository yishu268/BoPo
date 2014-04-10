package ruanko.activity.bopo;

import ruanko.model.bopo.Node_Data;
import ruanko.service.bopo.Service_Node;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Input extends Activity{

	private EditText title = null;
	private EditText type = null;
	private EditText text = null;
	private EditText date = null;
	private EditText user_id = null;
	private EditText review_id = null;

	private Service_Node service_Node = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input);
		service_Node = new Service_Node(this); 
		init();
	}
	
	public void onClick_Save(View view){
		service_Node.input(getContent());
	}
	public void onClick_Delete(View view){
		service_Node.delete();
	}
	
	private void init(){
		title = (EditText)findViewById(R.id.title);
		type = (EditText)findViewById(R.id.type);
		text = (EditText)findViewById(R.id.text);
		date = (EditText)findViewById(R.id.date);
		user_id = (EditText)findViewById(R.id.user_id);
		review_id = (EditText)findViewById(R.id.review_id);
	}
	
	private Node_Data getContent(){
		Node_Data node_Data = new Node_Data();
		node_Data.setTitle(title.getText().toString());
		node_Data.setType(type.getText().toString());
		node_Data.setText(text.getText().toString());
		node_Data.setDate(date.getText().toString());
		node_Data.setUser_id(user_id.getText().toString());
		node_Data.setReview_id(review_id.getText().toString());
		return node_Data;		
	}

}
