package ruanko.model.bopo;

public class Line_Data {
	int id;
	String title;
	int nodeid;
	
	public Line_Data(){
		id = 0;
		title = "";
		nodeid = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNodeid() {
		return nodeid;
	}

	public void setNodeid(int nodeid) {
		this.nodeid = nodeid;
	}
	
}
