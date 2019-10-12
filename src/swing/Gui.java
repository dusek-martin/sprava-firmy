package swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DatabaseOfEmployees;

public class Gui extends JFrame implements ActionListener {
	private JLabel employeesToString;
	private JLabel employeesID;
	private Event event;
	private JButton button;
	private JPanel panel1;
	private JPanel panel2;
	private DatabaseOfEmployees datZam;

	public Gui(String title) throws Exception {
		super(title); // parametr je titulek

		datZam = new DatabaseOfEmployees("databaze");
		event = new Event();
		Container con = getContentPane();
		con.setBackground(new Color(245, 245, 250));

		FlowLayout layout = new FlowLayout();
		setLayout(layout);

		panel1 = new JPanel();
		add(panel1);
//		Color color = new Color(150,75,130);
		panel1.setBackground(new Color(150, 75, 130));
//		panel1.setLocation(0, 0);;
		Dimension d = new Dimension(150, 400);
		panel1.setMaximumSize(d);

		panel2 = new JPanel();
		add(panel2);
		panel2.setBackground(Color.red);

		employeesToString = new JLabel("");

		button = new JButton("Vypsat zamìstnance");
		//button.addActionListener(event);
		button.addActionListener(this);
		
		panel1.add(button);
		panel2.add(employeesToString);
	}

	public void actionPerformed(ActionEvent e) {

		employeesToString.setText(datZam.findEmployee(1).toString());

	}

}
