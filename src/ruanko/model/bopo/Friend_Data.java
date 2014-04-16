package ruanko.model.bopo;

public class Friend_Data {

	private int id;
	private String name = null;
	private int userid;
	private int friendid;
	private String remark = null;
	
	public Friend_Data(){
		id = 0;
		name = "";
		userid = 0;
		friendid = 0;
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

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getFriendid() {
		return friendid;
	}

	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
