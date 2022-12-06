public class Pel {
	// variables
	private int pelColor;
	private Location p;
	
	// assigns pel with specificed coordinates and color
	public Pel(Location p, int color) {
		this.pelColor = color;
		this.p = p;
	}
	// returns location of pel
	public Location getLocus() {
		return p;
		
	}
	// returns color of pel
	public int getColor() {
		return pelColor;
	}

}
