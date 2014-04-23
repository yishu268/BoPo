package ruanko.model.bopo;

public class Review_Data {
	private int id;
	private String reviewer_name;
	private String node_id;
	private String review_time;
	private String review_info;
	
	public Review_Data(){
		id = 0;
		reviewer_name = "";
		node_id = "";
		review_time = "";
		review_info = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public String getReview_time() {
		return review_time;
	}

	public void setReview_time(String review_time) {
		this.review_time = review_time;
	}

	public String getReview_info() {
		return review_info;
	}

	public void setReview_info(String review_info) {
		this.review_info = review_info;
	}

	public String getReviewer_name() {
		return reviewer_name;
	}

	public void setReviewer_name(String reviewer_name) {
		this.reviewer_name = reviewer_name;
	}
}