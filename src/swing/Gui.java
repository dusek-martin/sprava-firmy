package swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.DatabaseOfEmployees;

public class Gui extends JFrame {
	private JTextArea employeesToString;
	private JLabel title;
	private JLabel employeesID;
	private Event event;
	private JButton buttonList;
	private JButton buttonAdd;
	private JButton buttonDel;
	private JPanel panel1;
	private JPanel panel2;
	private DatabaseOfEmployees datZam;

	public Gui(String title) throws Exception {
		super(title); // parametr je titulek

		datZam = new DatabaseOfEmployees("databaze");
		Container con = getContentPane();
		con.setBackground(new Color(245, 245, 250));

		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
//		FlowLayout layout = new FlowLayout();
		setLayout(layout);

		
		panel1 = new JPanel(); 
//		add(panel1); // Color color = new Color(150,75,130);
		panel1.setBackground(new Color(150, 75, 130)); // panel1.setLocation(0, 0);;
//		Dimension d = new Dimension(150, 400); panel1.setMaximumSize(d);
		 
//		panel2 = new JPanel(); add(panel2); panel2.setBackground(Color.red);
		

		buttonList = new JButton("vypsat zamìstnance");
		buttonAdd = new JButton("pøidat zamìstnance");
		buttonDel = new JButton("smazat zamìstnance");
		// button.addActionListener(event);
		EventButton eventButton = new EventButton();
		
		buttonList.addActionListener(eventButton);
		buttonAdd.addActionListener(eventButton);
		buttonDel.addActionListener(eventButton);
	
		panel1.add(buttonList);
		panel1.add(buttonAdd);
		panel1.add(buttonDel);
		gbc.gridx = 0;
		gbc.gridy = 1;
		con.add(panel1, gbc);

		this.title = new JLabel(title);
		gbc.gridx = 1;
		gbc.gridy = 0;
		con.add(this.title, gbc);

/*
		gbc.gridx = 0;
		gbc.gridy = 1;
		con.add(buttonList, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		con.add(buttonAdd, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		con.add(buttonDel, gbc);
*/
		employeesToString = new JTextArea("aaaaaaaaaaaaaaaaaaaaa");
		gbc.gridx = 2;
		gbc.gridy = 1;
		con.add(employeesToString, gbc);


		/*
	 	panel1.add(button); panel2.add(employeesToString);
		 */
	}

	private class EventButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonList){
				employeesToString.setText(datZam.listOfEmployeesByIdToString());
			} else if (e.getSource() == buttonAdd) {
				employeesToString.setText("bbbbbbbbbbbbbbbbbbb");
			} else if (e.getSource() == buttonDel) {
				employeesToString.setText("ccccccccccccccccc");
			}
			
/*	
			switch (((JButton)e.getSource()).getName()) {
			case "list":
				employeesToString.setText(datZam.listOfEmployeesByIdToString());
				break;
			case "add":
				break;
			case "del":
				break;
			default:
				break;
			}
 */
		}
	}
}
