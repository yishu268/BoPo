package ruanko.model.bopo;

import ruanko.activity.bopo.R;
import android.app.Application;

//ȫ�ֱ�������
public class Data extends Application{
	//ͷ��
	private int image[] = {R.drawable.image0,R.drawable.image1,R.drawable.image2,
			R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,
			R.drawable.image7,R.drawable.image8,R.drawable.image9};

	public int[] getImage() {
		return image;
	}

	public void setImage(int[] image) {
		this.image = image;
	} 
}
