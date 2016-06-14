package raffleGUI;

import raffleGUI.RafflerGUIT;

public class Site1 {

	// FIELDS
	//private static Ticket1 t1 = new Ticket1("<Name/ Name & Location>", <Number of tickets>);

	// METHODS
	public static void addTickets(Ticket1 t, Hat1 h) {

		int numFish = t.getNumFish();

		for (int i = 0; i < numFish; i++) {

			h.addTicket(t);

		}
	}

	public static void addAll() {

		//addTickets(t1, RafflerGUIT.getSiteHat());

	}
}
