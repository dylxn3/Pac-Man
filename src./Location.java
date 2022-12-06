public class Location {
	private int xCord;
	private int yCord;
	
	// assigns coordinates to pel object {constructor}
	public Location(int x, int y) {
		this.xCord = x;
		this.yCord = y;
	}
	// returns x coordinate
	public int getx() {
		return xCord;
	}
	// return y coordinate
	public int gety() {
		return yCord;
	}
	// 
	public int compareTo(Location p) {
		if (this.gety() > p.gety())
			return 1;
		else if (this.gety() == p.gety() && this.getx() > p.getx()) {
			return 1;
		}
		else if (this.gety() == p.gety() && this.getx() == p.getx()) {
			return 0;
		}
		else if (this.gety() < p.gety()) {
			return -1;
		}
		else {
			return -1;
		}
		
		
	}
}
