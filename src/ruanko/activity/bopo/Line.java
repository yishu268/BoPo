package ruanko.activity.bopo;

import ruanko.model.bopo.Data;
import ruanko.service.bopo.Service_User;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

//成长轴界面（Line）
public class Line extends Bottom{

	private ImageButton head = null;
	private Data data = null;
	
	
	private final int space_year = 5;
	private final int space_month = 5;
	private String[] year = { "2010", "2011", "2012", "2013" };
	private String[][] month = { { "01", "03", "04", "11" }, { "07" }, { "01", "03", "04", "11" },
			{ "07" } };
	//private String[][][] day ={{{"01"},{"03"},{"04"},{"11"}},{{"07"}},{{"01"},{"03"},{"04"},{"11"}},{{"07"}}};
		
	
	boolean menu_falg = false;// 单击改变菜单图标

	private TextView[] tv_year;
	private TextView[] tv_month;
	private TextView tv_content;
	
	private LinearLayout xxx;
	
	private Service_User service_User = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.line);
		data = (Data)getApplication();
		service_User = new Service_User(this);
		init();
	}
	//重载获取数据
	@Override  
	protected void onNewIntent(Intent intent) {        
	    super.onNewIntent(intent);  
	    setIntent(intent);
		init();
	    //here we can use getIntent() to get the extra data.
	}
	//头像按钮点击事件
	public void onClick_Info(View view){
		Intent intent = new Intent(this,Info.class);
		startActivity(intent);
	}
	//添加按钮点击事件
	public void onClick_Add(View view){
		Intent intent = new Intent(this,Node_Add.class);
		startActivity(intent);
	}
	//初始化
	private void init(){
		head = (ImageButton)findViewById(R.id.per_infor);
		head.setImageResource(data.getImage()[Integer.parseInt(service_User.head(data.getPerson_id()))]);
		initLayout();
	}
	
	/**
	 * 
	 */
	private void initLayout()
	{
		//LinearLayout btnback = (LinearLayout) findViewById(R.id.history_layouthome);
		//final TextView btnhome = (TextView) findViewById(R.id.history_btnhome);


		//content = (TextView) findViewById(R.id.content);
		LinearLayout timelayout = (LinearLayout) findViewById(R.id.timelayout);
		tv_year = new TextView[year.length];
		for (int i = 0; i < year.length; i++)
		{
			tv_year[i] = new TextView(this);
			tv_year[i].setPadding(
					10,
					i == 0 ? space_year : space_year
							* (13 - Integer.parseInt(month[i - 1][month[i - 1].length - 1])), 0, 0);
			tv_year[i].getPaint().setFakeBoldText(true);
			tv_year[i].setTextSize(14);
			tv_year[i].setTag(year[i]);
			tv_year[i].setText(year[i] + "	--");
			
			String yearthis = year[i];
			//tv_year[i].setOnClickListener(new TimeLineClickListener(tv_year[i]));
			timelayout.addView(tv_year[i]);
			tv_month = new TextView[year.length];
			for (int j = 0; j < month[i].length; j++)
			{
				xxx = new LinearLayout(this);
				xxx.setOrientation(LinearLayout.HORIZONTAL);
				timelayout.addView(xxx);
				
				tv_month[i] = new TextView(this);
				if (j == 0)
				{
					tv_month[i].setPadding(20, space_month * Integer.parseInt(month[i][j]), 0, 0);
				} else
				{
					tv_month[i].setPadding(20, space_month
							* (Integer.parseInt(month[i][j]) - Integer.parseInt(month[i][j - 1])),
							0, 0);
				}
				tv_month[i].setTextSize(12);
				tv_month[i].setText(month[i][j] + "月  --");
				tv_month[i].setTag(year[i] + "-" + month[i][j]);
				//tv_month[i].setOnClickListener(new TimeLineClickListener(tv_month[i]));
				xxx.addView(tv_month[i]);
				
			
				tv_content = new TextView(this);
				tv_content.setTextSize(12);
				tv_content.setText(yearthis + "-" + month[i][j]);
				
				xxx.addView(tv_content);
				
			
				
				
			}
		}

	}

}
