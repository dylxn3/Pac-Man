
public class MyObject implements MyObjectADT{
	// assign variables

	private int width;
	private int height;
	private int id;
	private String type;
	private Location position;
	private BinarySearchTree tree;
	//constructor of class... assigns variables
	public MyObject (int id, int width, int height, String type, Location pos){
		// assign variables
		
		this.width = width;
		this.height = height;
		this.id = id;
		this.type = type;
		this.position = pos;
	    tree = new BinarySearchTree();
	}
	// helper method to find location in pel
	private boolean findPel(Location p){
		Pel obj = tree.get(tree.getRoot(), p);
		
		if(obj != null){
			return true;
		}

		else{
			return false;
		}
	}

	@Override
	//return width
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	//return height
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	//return type
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	//return its id
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	//return its location
	public Location getLocus() {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	//set location
	public void setLocus(Location value) {
		this.position = value;
		
	}

	@Override
	//set the type
	public void setType(String t) {
		this.type = t;
		
	}

	@Override
	//add pel obj into the tree
	public void addPel(Pel pix) throws DuplicatedKeyException {
		// puts pel into tree
		tree.put(tree.getRoot(),pix);
		
	}
	
	// check to see if trees are intersecting
	public boolean intersects(MyObject fig) {
		
		// TODO Auto-generated method stub
		// find coordinates
		// set value to null;
		Pel smallest = null;
		boolean flag = true;		
		
		int x2 = fig.getLocus().getx();
		int y2 = fig.getLocus().gety();
		int x1 = getLocus().getx();
		int y1 = getLocus().gety();
		
		
		 try {
			smallest = fig.tree.smallest(tree.getRoot());
		} catch (EmptyTreeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// loops through tree from smallest to largest
		while(tree.successor(tree.getRoot(), smallest.getLocus()) != null){
			//coordinates
			int x;
			int y;
			// get location 
			y = smallest.getLocus().gety()+y1-y2;
			x = smallest.getLocus().getx()+x1-x2;
			if(fig.findPel(new Location(x,y))){
				return flag;
			}
			smallest = tree.successor(tree.getRoot(), smallest.getLocus());
		}
		
		return flag = false;
		
	}

}