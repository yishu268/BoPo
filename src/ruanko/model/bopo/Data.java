package ruanko.model.bopo;

import ruanko.activity.bopo.R;
import android.app.Application;

//ȫ�ֱ�������
public class Data extends Application{
	//ͷ��
	private int image[] = {R.drawable.image0,R.drawable.image1,R.drawable.image2,
			R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,
			R.drawable.image7,R.drawable.image8,R.drawable.image9};
	
	private int person_id = 0;
	
	private int head_id = 0;
	
	private String node_id = "";

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public int[] getImage() {
		return image;
	}

	public void setImage(int[] image) {
		this.image = image;
	}

	public int getHead_id() {
		return head_id;
	}

	public void setHead_id(int head_id) {
		this.head_id = head_id;
	}

	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

}
