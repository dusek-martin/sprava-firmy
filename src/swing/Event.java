package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DatabaseOfEmployees;

public class Event implements ActionListener {

	public Event() {
		try {
			DatabaseOfEmployees datZam = new DatabaseOfEmployees("databaze");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void actionPerformed(ActionEvent e) {

		//employeesName.setText(datZam.findEmployee(1).toString());

	}
}

