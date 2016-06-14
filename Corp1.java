package raffleGUI;

import raffleGUI.RafflerGUIT;

public class Corp1 {

	// FIELDS
	//private static Ticket1 t80 = new Ticket1("Name/ Name & Location", <Number of tickets>);

	// METHODS
	public static void addTickets(Ticket1 t, Hat1 h) {

		int numFish;

		numFish = t.getNumFish();

		for (int i = 0; i < numFish; i++) {

			h.addTicket(t);

		}
	}

	public static void addAll() {

		//addTickets(t80, RafflerGUIT.getCorpHat());

	}
}
