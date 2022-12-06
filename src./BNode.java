public class BNode {
	// variables
	
	// value stored in pel
	private Pel value;
	// left child of node
	private BNode left;
	// parent of node
	private BNode parent;
	// right child of node
	private BNode right;
	public BNode(Pel value, BNode left, BNode right, BNode parent) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
		
	// sets info of node
	public BNode() {
		value = null;
		left = null;
		right = null;
		parent = null;
		
	}
	// returns parent of node
	public BNode parent() {
		return this.parent;
	}
	// assigns parent of node
	public void setParent(BNode newParent) {
		this.parent = newParent;
	}
	// assigns left child of node
	public void setLeftChild (BNode p) {
		this.left = p;
	}
	// assigns right child of node
	public void setRightChild (BNode p) {
		this.right = p;
	}
	// assigns value to new value of node
	public void setContent (Pel value) {
		this.value = value;
	}
	// isLeaf method will help
	// true if the node is a leaf, if not returns false
	public boolean isLeaf() {
		return value == null && left == null && right == null;
	}
	// returns value of the pel
	public Pel getData () {
		return this.value;
	}
	// returns left child of node
	 public BNode leftChild() {
		 return this.left;
	 }
	 // returns right child of node
	 public BNode rightChild() {
		 return this.right;
	 }

}
