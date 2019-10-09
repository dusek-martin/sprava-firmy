package swing;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DatabaseOfEmployees;

public class Gui extends JFrame {
	private JLabel employeesName;
	private JLabel employeesSurname;
	private JLabel employeesID;
	private JButton button;
	private JPanel panel1;
	private JPanel panel2;
	private DatabaseOfEmployees datZam;

	public Gui(String title) throws Exception{
		super(title); // parametr je titulek
		
		datZam = new DatabaseOfEmployees("databaze");
		
		FlowLayout layout = new FlowLayout();
		setLayout(layout);

		panel1 = new JPanel();
		add(panel1);
		Color color = new Color(150,75,130);
		panel1.setBackground(color);
		panel2 = new JPanel();
		add(panel2);
		panel2.setBackground(Color.red);

		button = new JButton("vypiš");
		employeesName = new JLabel(datZam.findEmployee(1).getName());
		employeesSurname = new JLabel(datZam.findEmployee(1).getSurname());

		panel1.add(employeesName);
		panel1.add(employeesSurname);
		panel2.add(button);
	}
	public void list(int id) {
		JLabel m = new JLabel(datZam.findEmployee(id).toString());
	}

}
