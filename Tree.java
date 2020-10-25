
public class Tree {
	
	private Node root;
	
	public Tree() {
		root = null;
	}
	
	public Node root() {
		return root;
	}
	
	public int element(Node n) {					//
		return n.getElement();
	}
	
	public Node parent(Node n) {					//
		return n.getParent();
	}
	
	public Node[] children(Node n) {				//
		return n.getArray();
	}
	
	public boolean isInternal(Node n) {
		Node[] array = n.getArray();
		for(int i=0; i<array.length; i++)
			if(array[i] != null)
				return true;
		return false;
	}
	
	public boolean isExternal(Node n) {
		return !isInternal(n);
	}
	
	public boolean isRoot(Node n) {					//
		return root == n;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public boolean havePlace(Node n) {
		Node[] array = n.getArray();
		for(int i=0; i<array.length; i++) {
			if(array[i] == null)
				return true;
		}
		return false;
	}
	
	public void insert(Node insertEdilenNode, Node insertEdilecekNode) {
		Node[] array = insertEdilenNode.getArray();
		for(int i=0; i<array.length; i++) {
			if(array[i] == null) {
				array[i] = insertEdilecekNode;
				insertEdilecekNode.setParent(insertEdilenNode);
				break;
			}
		}
	}
	
	public void addTree(Node kendisineElemanEklenecekNode, Node eklenecekNode) {
		if(isEmpty())
			root = eklenecekNode;
		else {
			if(havePlace(kendisineElemanEklenecekNode))
				insert(kendisineElemanEklenecekNode, eklenecekNode);
			else {
				Node[] tempArray = kendisineElemanEklenecekNode.getArray();
				addTree(tempArray[0],eklenecekNode);
			}	
		}
	}
	
	public Node firstNodeOf(Node n) {
		Node[] array = n.getArray();
		return array[0];
	}
	
	public void inOrderTraversal(Node node) {
		if(isExternal(node)) {									// base case
			System.out.print(node.getElement() + " ");
			return;
		}
		else													// visit left-most subtree
			inOrderTraversal(firstNodeOf(node));
		
		System.out.print(node.getElement() + " ");				// visit root
		
		Node[] array = node.getArray();							// visit remaining right tree
		for(int i=1; i<array.length; i++) {
			if(array[i] != null)
				inOrderTraversal(array[i]);
			else
				return;
		}
	}
}
