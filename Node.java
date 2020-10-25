
public class Node {
	
	private int element;
	private Node parent;
	private Node [] array;
	
	public Node(int e, int length) {
		element = e;
		array = new Node[length];
	}
	
	public void setElement(int e) {
		element = e;
	}
	
	public void setParent(Node n) {
		parent = n;
	}
	
	public void setArray(int position, Node n) {
		array[position] = n;
	}
	
	public int getElement() {
		return element;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public Node[] getArray() {
		return array;
	}
}
