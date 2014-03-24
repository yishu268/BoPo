package ruanko.model.bopo;

import java.io.Serializable;

//好友信息实体类
public class Friend_Info_Data implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name = null;
	private String password = null;
	private String mail = null;
	private String node_id = null;
	private String image= null;
	
	public Friend_Info_Data(){
		id = 0;
		name = "";
		password = "";
		mail = "";
		node_id = "";
		image = "";
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

	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
