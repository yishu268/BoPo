package ruanko.model.bopo;

public class Friend_Data {

	private String number = null;
	private String name = null;
	private String remark = null;
	
	public Friend_Data(){
		number = "";
		name = "";
		remark = "";
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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
