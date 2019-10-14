package swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import model.DatabaseOfEmployees;

public class JFrameMainWindow extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JButton btnList;
	private JButton btnAdd;
	private JButton btnDel;
	private JButton btnClose;
	private JTextArea txtrListOfEmployees;
	private DatabaseOfEmployees datZam;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMainWindow frame = new JFrameMainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameMainWindow() {
		
		setTitle("Spr\u00E1va firmy");
		
		try {
			datZam = new DatabaseOfEmployees("databaze");
		} catch (Exception e) {
			setTitle("Nepovedla se naèíst databáze.");
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLeftMain = new JPanel();
		contentPane.add(panelLeftMain, BorderLayout.WEST);
		GridBagLayout gbl_panelLeftMain = new GridBagLayout();
		gbl_panelLeftMain.columnWidths = new int[]{100, 0};
		gbl_panelLeftMain.rowHeights = new int[]{39, 1, 0, 0, 0, 0};
		gbl_panelLeftMain.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelLeftMain.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelLeftMain.setLayout(gbl_panelLeftMain);
		
		Component horizontalStrut = Box.createHorizontalStrut(100);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.anchor = GridBagConstraints.WEST;
		gbc_horizontalStrut.fill = GridBagConstraints.VERTICAL;
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		panelLeftMain.add(horizontalStrut, gbc_horizontalStrut);
		
		btnList = new JButton("List");
		GridBagConstraints gbc_btnList = new GridBagConstraints();
		gbc_btnList.fill = GridBagConstraints.BOTH;
		gbc_btnList.insets = new Insets(5, 10, 5, 10);
		gbc_btnList.gridx = 0;
		gbc_btnList.gridy = 2;
		panelLeftMain.add(btnList, gbc_btnList);
		
		btnAdd = new JButton("Add");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.insets = new Insets(5, 10, 5, 10);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 3;
		panelLeftMain.add(btnAdd, gbc_btnAdd);
		
		btnDel = new JButton("Del");
		GridBagConstraints gbc_btnDel = new GridBagConstraints();
		gbc_btnDel.fill = GridBagConstraints.BOTH;
		gbc_btnDel.insets = new Insets(5, 10, 5, 10);
		gbc_btnDel.gridx = 0;
		gbc_btnDel.gridy = 4;
		panelLeftMain.add(btnDel, gbc_btnDel);
		
		EventButton eventButton = new EventButton();
		btnList.addActionListener(eventButton);
		btnAdd.addActionListener(eventButton);
		btnDel.addActionListener(eventButton);
		
		JPanel panelTopMain = new JPanel();
		contentPane.add(panelTopMain, BorderLayout.NORTH);
		
		lblTitle = new JLabel("LIST OF EMPLOYEES");
		panelTopMain.add(lblTitle);
		
		Component verticalStrut = Box.createVerticalStrut(60);
		panelTopMain.add(verticalStrut);
		
		JPanel panelCenterMain = new JPanel();
		contentPane.add(panelCenterMain, BorderLayout.CENTER);
		
		txtrListOfEmployees = new JTextArea();
		txtrListOfEmployees.setText("adsfasfass");
		
		JLabel lblListOfEmployees = new JLabel("List of employees");
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(eventButton);
		GroupLayout gl_panelCenterMain = new GroupLayout(panelCenterMain);
		gl_panelCenterMain.setHorizontalGroup(
			gl_panelCenterMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenterMain.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_panelCenterMain.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCenterMain.createSequentialGroup()
							.addComponent(lblListOfEmployees)
							.addContainerGap())
						.addGroup(gl_panelCenterMain.createSequentialGroup()
							.addComponent(txtrListOfEmployees)
							.addGap(5)
							.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(5))))
		);
		gl_panelCenterMain.setVerticalGroup(
			gl_panelCenterMain.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelCenterMain.createSequentialGroup()
					.addGroup(gl_panelCenterMain.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelCenterMain.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCenterMain.createSequentialGroup()
							.addGap(20)
							.addComponent(lblListOfEmployees)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtrListOfEmployees)))
					.addGap(20))
		);
		panelCenterMain.setLayout(gl_panelCenterMain);
	}
	
	private class EventButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnList){
				txtrListOfEmployees.setText(datZam.listOfEmployeesByIdToString());
			} else if (e.getSource() == btnAdd) {
				txtrListOfEmployees.setText("bbbbbbbbbbbbbbbbbbb");
			} else if (e.getSource() == btnDel) {
				txtrListOfEmployees.setText("ccccccccccccccccc");
			} else if (e.getSource() == btnClose) {
				lblTitle.setText("Nevím jak to zavøííííít.");
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
