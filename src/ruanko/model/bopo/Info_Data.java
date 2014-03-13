package ruanko.model.bopo;

//用户信息数据实体类
public class Info_Data {
	private String number =  null;
	private String name = null;
	private String password = null;
	private String mail = null;
	private String node = null;
	private String image= null;
	
	public Info_Data(){
		number = "";
		name = "";
		password = "";
		mail = "";
		node = "";
		image = "";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
