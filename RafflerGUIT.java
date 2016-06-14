package raffleGUI;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class RafflerGUIT {

	// INSTANCE VARIABLE(S)
	private static RafflerGUIT rGUI;
	private JTabbedPane tabbedPane;
	private JFrame frame;
	private RafflePanel buttonPanelWest;
	private JButton corp, site;
	private CorpButtonListener corpListener;
	private SiteButtonListener siteListener;
	private JTextPane printArea;
	private static Hat1 corpHat = new Hat1();
	private static Hat1 siteHat = new Hat1();
	private JPanel tab1, tab1South, tab2;
	private JTextArea tab1SouthText, tab2Text;
	private JScrollPane tab2Scroll;
	private int numOfSiteWinners, numOfCorpWinners, totalNumOfWinners;

	// MAIN
	public static void main(String[] args) {

		Corp1.addAll();
		Site1.addAll();

		rGUI = new RafflerGUIT();
		rGUI.launch();

	}

	// METHOD(S)
	private void launch() {

		// Instantiate frame; set close
		frame = new JFrame("MagicHat");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create button listeners
		corpListener = new CorpButtonListener();
		siteListener = new SiteButtonListener();

		// Create buttons; register listeners
		corp = new JButton("Draw from Corporate");
		site = new JButton("Draw from Site");
		corp.addActionListener(corpListener);
		site.addActionListener(siteListener);

		// Instantiate printArea; set font
		printArea = new JTextPane();
		Font printAreaFont = new Font("TimesNewRoman", Font.BOLD, 60);
		printArea.setFont(printAreaFont);

		// Format printArea
		try {

			printArea.setEditorKit(new MyEditorKit());
			SimpleAttributeSet attrs = new SimpleAttributeSet();
			StyleConstants.setAlignment(attrs, StyleConstants.ALIGN_CENTER);
			StyledDocument doc = (StyledDocument) printArea.getDocument();
			doc.insertString(0,
					"Welcome to MagicHat\n Click a button, draw a winner!",
					attrs);
			doc.setParagraphAttributes(0, doc.getLength() - 1, attrs, false);

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		// Instantiate buttonpanel; add buttons (WHY button panel? Grid layout?)
		buttonPanelWest = new RafflePanel();
		buttonPanelWest.setLayout(new GridLayout(10, 1));
		buttonPanelWest.add(corp);
		buttonPanelWest.add(site);
		buttonPanelWest.setBackground(Color.GRAY);

		// Instantiate tab1SouthText; instantiate tab1South
		tab1SouthText = new JTextArea();
		tab1SouthText.setText("0/0 (Site/ Corporate)");
		Font tab1SouthTextFont = new Font("TimesNewRoman", Font.BOLD, 12);
		tab1SouthText.setFont(tab1SouthTextFont);

		tab1South = new JPanel();
		tab1South.add(tab1SouthText);

		// Instantiate tab1
		tab1 = new JPanel();
		tab1.setLayout(new BorderLayout());
		tab1.add(BorderLayout.WEST, buttonPanelWest);
		tab1.add(BorderLayout.CENTER, printArea);
		tab1.add(BorderLayout.SOUTH, tab1South);

		// Instantiate tab2
		tab2 = new JPanel();
		tab2.setLayout(new BorderLayout());

		// Instantiate tab2 text area
		tab2Text = new JTextArea();
		tab2Text.setLineWrap(true);
		Font tab2Font = new Font("TimesNewRoman", Font.BOLD, 30);
		tab2Text.setFont(tab2Font);
		tab2Text.append("Previous Winners: \n");

		// Instantiate tab2 scroll pane
		tab2Scroll = new JScrollPane(tab2Text);
		tab2Scroll
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tab2Scroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		tab2.add(BorderLayout.CENTER, tab2Scroll);

		// Instantiate tab pane; add tabs
		tabbedPane = new JTabbedPane();
		tabbedPane.add("Draw Winners", tab1);
		tabbedPane.add("Previous Winners", tab2);

		frame.getContentPane().add(BorderLayout.CENTER, tabbedPane);

		frame.setSize(1000, 750);
		frame.setVisible(true);

	}

	public static Hat1 getSiteHat() {

		return siteHat;

	}

	public static Hat1 getCorpHat() {

		return corpHat;

	}

	@SuppressWarnings("serial")
	// NESTED CLASS(ES)
	class RafflePanel extends JPanel {

		@Override
		public void paintComponent(Graphics g) {

			super.paintComponent(g);

		}
	}

	class CorpButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {

			String currentWinner = corpHat.printWinner();
			printArea.setText(currentWinner);

			if (!currentWinner.equals("There are no tickets in this hat.")) {

				totalNumOfWinners++;
				numOfCorpWinners++;
				tab1SouthText.setText(numOfSiteWinners + "/" + numOfCorpWinners
						+ " (Site/ Corporate)");
				tab2Text.append(totalNumOfWinners + ") " + currentWinner + "\n");

				// I/O CODE
				// try {
				//
				// File previousWinners = new File(
				// "C:\\Users\\anthony\\Desktop\\Previous Winners.txt");
				// FileWriter winnerWriter = new FileWriter(previousWinners,
				// true);
				// BufferedWriter bufferedWinnerWriter = new BufferedWriter(
				// winnerWriter);
				// bufferedWinnerWriter.write(currentWinner);
				// bufferedWinnerWriter.newLine();
				// bufferedWinnerWriter.close();
				//
				// } catch (Exception ex) {
				//
				// ex.printStackTrace();
				//
				// }

			}

		}
	}

	class SiteButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {

			String currentWinner = siteHat.printWinner();
			printArea.setText(currentWinner);

			if (!currentWinner.equals("There are no tickets in this hat.")) {

				totalNumOfWinners++;
				numOfSiteWinners++;
				tab1SouthText.setText(numOfSiteWinners + "/" + numOfCorpWinners
						+ " (Site/ Corporate)");
				tab2Text.append(totalNumOfWinners + ") " + currentWinner + "\n");

				// I/O CODE
				try {

					File previousWinners = new File(
							"C:\\Users\\anthony\\Desktop\\Previous Winners.txt");
					FileWriter winnerWriter = new FileWriter(previousWinners,
							true);
					BufferedWriter bufferedWinnerWriter = new BufferedWriter(
							winnerWriter);
					bufferedWinnerWriter.write(currentWinner);
					bufferedWinnerWriter.newLine();
					bufferedWinnerWriter.close();

				} catch (Exception ex) {

					ex.printStackTrace();

				}

			}

		}

	}

}
