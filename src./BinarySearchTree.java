public class BinarySearchTree implements BinarySearchTreeADT{
	// implementation from class
	
	private BNode rootnode; 
	//helper function to find location of node
	private BNode findNode (BNode node, Location k) {
		if (node.isLeaf()) {
			return node;
		}
		// Compare the location to this internal node
		int compareLoc = node.getData().getLocus().compareTo(k);
		
		// if location is greater go to right 
		if (compareLoc == 1) {
			return findNode(node.leftChild(), k);
			
		} 
		// Location is equal to this internal node
		else if (compareLoc == 0) {
					return node;
		}
		// go to left side if 
		else {
			return findNode(node.rightChild(), k);
		}
	}
	
	// creates a node that is the root of the tree
	public BinarySearchTree() {
		rootnode = new BNode();
	}
	

	@Override
	// returns root 
	public BNode getRoot() {
		return rootnode;
	}
	
	// find node using helper function
	@Override
	public Pel get(BNode r, Location key) {
		return findNode(r,key).getData();
	
	}



	
	@Override
	// method finds largest value in the tree
	public Pel largest(BNode r) throws EmptyTreeException {
		//if root is a not a leaf
		if(!this.getRoot().isLeaf()) {
			BNode nodeNeeded = r;
			while(!nodeNeeded.isLeaf()) {
				nodeNeeded = nodeNeeded.rightChild();
			}
			return nodeNeeded.parent().getData();
		}
			
		
		else {
			throw new EmptyTreeException(null);
		}
		
	}
	@Override
	// finds smallest obj in tree
	public Pel smallest(BNode r) throws EmptyTreeException {
		// if node is leaf
		if(!r.isLeaf()) {
			// assign to variable and loop through left children
			BNode nodeNeeded = r;
			while(!nodeNeeded.isLeaf()) {
				nodeNeeded = nodeNeeded.leftChild();
				}
			return nodeNeeded.parent().getData();
						
			
		}
		// if node is not a leaf
		else {
			throw new EmptyTreeException(null);			
		}
	}


	@Override
	// finds next largest value for the target
	public Pel successor(BNode r, Location key) {
		// if r is not a leaf
		if(!r.isLeaf()) {
			// finds location of node
			BNode nodeNeeded = findNode(r,key);
			// if node is not a leaf and right child is not a leaf
			if (!nodeNeeded .isLeaf() && !nodeNeeded .rightChild().isLeaf()) {
				nodeNeeded  = nodeNeeded .rightChild();
				// loops through tree
				while (!nodeNeeded .isLeaf()) {
					nodeNeeded  = nodeNeeded .leftChild();
				}
				return nodeNeeded .parent().getData();
			}
			// if node and right child are leaves
			else {
				// make node that is parent
				BNode node = nodeNeeded .parent();
				// loops through tree
				while (node != null && node.rightChild() == nodeNeeded ) {
					nodeNeeded  = node;
					node = node.parent();
				}
				if (node == null) {
					return null;
				}
				else {
					return node.getData();
				}
			}
			
		}
		else {
			return null;
		}
			
	}
	@Override
	// finds next smallest value for the target value 
	public Pel predecessor(BNode r, Location key) {
		// if r is a leaf
		if(r.isLeaf()) {
			return null;
		}
		// if r is not a leaf
		else {
			BNode nodeNeeded = findNode(r,key);
			// if left child or node is not a leaf
			if(!nodeNeeded.leftChild().isLeaf() && !nodeNeeded.isLeaf()) {
				// get left child of main node
				BNode left = nodeNeeded.leftChild();
				// loops through left side of tree
				while(!left.isLeaf()) {
					left = left.rightChild();
				}
				return left.parent().getData();
			}
			// if left and main child is a leaf
			else {
				BNode parent = nodeNeeded.parent();
				// loops through trees
				while(parent.leftChild() == nodeNeeded && parent != null) {
					nodeNeeded = parent;
					parent = parent.parent();
				}
				// if parent is not null return data
				if(parent != null) {
					return parent.getData();
				}
				else {
					return null;
				}
			}
		}
		
	}
	// puts a object into the tree
	public void put(BNode r, Pel data) throws DuplicatedKeyException {
		// finds location of the node 
		BNode nodeNeeded = findNode(r,data.getLocus());
		// if node is a leaf
		if(nodeNeeded.isLeaf()){
			nodeNeeded.setContent(data);
			BNode rightNode = new BNode();
			BNode leftNode = new BNode();
			// sets children
			nodeNeeded.setRightChild(rightNode);
			nodeNeeded.setLeftChild(leftNode);
			// sets parents
			rightNode.setParent(nodeNeeded);
			leftNode.setParent(nodeNeeded);
		}
		
		// if node is a internal node
		else {
			throw new DuplicatedKeyException(null);
		}
				
	}
	@Override
	// removes a node in the tree
	public void remove(BNode r, Location key) throws InexistentKeyException {
		BNode nodeNeeded = findNode(r,key); 
		// if nodes are not leaves
		if(!nodeNeeded.isLeaf()) {
			if(nodeNeeded.rightChild().isLeaf() || nodeNeeded.leftChild().isLeaf()) {
				// if left child is a leaf
				if(nodeNeeded.leftChild().isLeaf()) {
						// makes parent of primary node
						BNode parentNode = nodeNeeded.parent();
						// makes right child of primary node 
						BNode rightNode = nodeNeeded.rightChild();
					
					if (parentNode != null) {
						// if parent right child equals parent
						if(parentNode.rightChild().equals(nodeNeeded)) {
							// sets right child as parent of P'
							parentNode.setRightChild(rightNode);
							//sets rightNodes parent as the parent of primary Node
							rightNode.setParent(parentNode);
						}
						else {
							parentNode.setLeftChild(rightNode);
							rightNode.setParent(parentNode);
						}
					}
					// if parent is null
					else {
						
						this.rootnode = rightNode;
						rightNode.setParent(null);
						
						
					}
				
			}
				// if the right node is a leaf
				else {
					BNode parentNode = nodeNeeded.parent();
					BNode leftNode = nodeNeeded.leftChild();
					//if parent is not null
					if (parentNode != null) {
						if(parentNode.rightChild().equals((nodeNeeded))) {
							parentNode.setRightChild(leftNode);
							leftNode.setParent(parentNode);
							
						}
						else {
							parentNode.setLeftChild(leftNode);
							leftNode.setParent(parentNode);
							
							}
					}
				
						
					//if parent is null
					else {
						this.rootnode = leftNode;
						leftNode.setParent(null);
					}
						
				}
			
			
			
			}
			// if no children are leaves
			else {
				BNode node2 = nodeNeeded.rightChild();
				//lopps through tree
				while(!node2.isLeaf()) {
					node2 = node2.leftChild();
				}
				node2 = node2.parent();
				
				//puts data into main node
				nodeNeeded.setContent(node2.getData());
				BNode smallest = node2.parent();
				
				// if leftchild equals node2
				if(smallest.leftChild().equals(node2)) {
					smallest.setLeftChild(node2.rightChild());
					
				}
				else {
					smallest.setRightChild(node2.rightChild());
				}
				node2.rightChild().setParent(smallest);
				
			}
		}
		
			
		
		// if node is a leaf
		else {
			throw new InexistentKeyException(null);
		}
					
	}

	
	
	

}
