package ruanko.model.bopo;

public class Friend_Data {

	private int id;
	private String name = null;
	private String remark = null;
	
	public Friend_Data(){
		id = 0;
		name = "";
		remark = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
