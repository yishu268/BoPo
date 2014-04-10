package ruanko.dao.bopo;

import java.util.List;

import ruanko.model.bopo.Node_Data;

public interface Node_ManageDAO {
	public List<?> line(int id);
	public Node_Data show(int id);
	public void input(Node_Data node_Data);
	public void delete();
}
