package swing;

import javax.swing.JFrame;

public class SwingMainWindow {

	public static void main(String[] args) {
		try {
			Gui frame = new Gui("Hlavní okno");
			frame.setSize(800, 400);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			// frame.pack(); // velikost okna pøímo na komponenty
		} catch (Exception e) {
			System.out.println("Swing main catch chyba.");
		}

	}

}
