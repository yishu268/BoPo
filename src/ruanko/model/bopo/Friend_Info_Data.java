package ruanko.model.bopo;

//好友信息实体类
public class Friend_Info_Data{
	
	private int id;
	private String name = null;
	private String mail = null;
	private String gender = null;
	private String phone = null;
	private String image= null;
	private String location = null;
	private String age = null;
	private String birth = null;
	private int node_id;
	
	public Friend_Info_Data(){
		id = 0;
		name = "";
		mail = "";
		gender = "";
		phone = "";
		image = "";
		location = "";
		age = "";
		birth = "";
		node_id = 0;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getNode_id() {
		return node_id;
	}

	public void setNode_id(int node_id) {
		this.node_id = node_id;
	}

}
