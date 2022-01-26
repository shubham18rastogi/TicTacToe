package game;

//No setter to make object immutable
public class Player {
	String name;
	Marker marker;

	public Player(String name, Marker marker) {
		super();
		this.name = name;
		this.marker = marker;
	}

	public String getName() {
		return name;
	}

	public Marker getMarker() {
		return marker;
	}

}
