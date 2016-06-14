package raffleGUI;

import java.util.*;

public class Hat1 {

	// FIELDS
	private List<Ticket1> hat = new ArrayList<Ticket1>();
	private int winnerNumber = 1;

	// METHODS
	public int getSize() {

		return hat.size();

	}

	public void addTicket(Ticket1 t) {

		hat.add(t);

	}

	private String drawWinner() {

		int chance = new Random().nextInt(hat.size());

		return hat.get(chance).getNameAndLocation();

	}

	public String printWinner() {

		if (hat.size() >= 1) {

			String winner = drawWinner();

			System.out.println(winnerNumber + ") " + winner);
			System.out.println();
			winnerNumber++;

			removeWinner(winner);

			return (winner + ".");

		} else {

			return "There are no tickets in this hat.";

		}

	}

	private void removeWinner(String winner) {

		int hatSize = hat.size();

		for (int i = 0; i < hatSize; i++) {

			if (hat.get(i).getNameAndLocation().equals(winner)) {

				hat.remove(i);

				i--;
				hatSize--;

			}
		}
	}

	public void printArrayValues() {

		System.out.println("Tickets in the hat:");
		System.out.println();

		for (int i = 0; i < hat.size(); i++) {

			System.out.println(((i + 1)) + "." + " "
					+ hat.get(i).getNameAndLocation());

		}

		System.out.println();

	}
}
