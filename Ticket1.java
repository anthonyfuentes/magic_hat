package raffleGUI;

public class Ticket1 {

	// FIELDS
	private String nameAndLocation;
	private int numFish;

	// CONSTRUCTOR
	public Ticket1(String nameAndLocation, int numFish) {

		this.nameAndLocation = nameAndLocation;
		this.numFish = numFish;

	}

	// METHODS
	public String getNameAndLocation() {

		return nameAndLocation;

	}

	public int getNumFish() {

		return numFish;

	}
}
