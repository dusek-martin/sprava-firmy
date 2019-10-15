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
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

public class JFrameMainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panelCenterMain;
	private JLabel lblTitle;
	private JButton btnList;
	private JButton btnAdd;
	private JButton btnDel;
	private JButton btnClose;
	private DatabaseOfEmployees datZam;
	private JPanel panelEmployeesList;
	private JPanel panelAdd;
	private JPanel panelDel;
	private JTextArea txtrListOfEmployees;
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
		panelLeftMain.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.LIGHT_GRAY));
		contentPane.add(panelLeftMain, BorderLayout.WEST);
		GridBagLayout gbl_panelLeftMain = new GridBagLayout();
		gbl_panelLeftMain.columnWidths = new int[]{100, 0};
		gbl_panelLeftMain.rowHeights = new int[]{39, 1, 0, 0, 0, 0, 0};
		gbl_panelLeftMain.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelLeftMain.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		btnClose = new JButton("Close");
		GridBagConstraints gbc_btnClose = new GridBagConstraints();
		gbc_btnClose.insets = new Insets(5, 10, 5, 10);
		gbc_btnClose.fill = GridBagConstraints.BOTH;
		gbc_btnClose.gridx = 0;
		gbc_btnClose.gridy = 5;
		panelLeftMain.add(btnClose, gbc_btnClose);
		
		EventButton eventButton = new EventButton();
		btnList.addActionListener(eventButton);
		btnAdd.addActionListener(eventButton);
		btnDel.addActionListener(eventButton);
		btnClose.addActionListener(eventButton);
		
		JPanel panelTopMain = new JPanel();
		panelTopMain.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		contentPane.add(panelTopMain, BorderLayout.NORTH);
		
		lblTitle = new JLabel("LIST OF EMPLOYEES");
		panelTopMain.add(lblTitle);
		
		Component verticalStrut = Box.createVerticalStrut(60);
		panelTopMain.add(verticalStrut);
		
		panelCenterMain = new JPanel();
		contentPane.add(panelCenterMain, BorderLayout.CENTER);
		panelCenterMain.setLayout(new CardLayout(0, 0));
		
		panelEmployeesList = new JPanel();
		panelCenterMain.add(panelEmployeesList, "name_103383212123600");
		
		txtrListOfEmployees = new JTextArea();
		txtrListOfEmployees.setEditable(false);
		txtrListOfEmployees.setWrapStyleWord(true);
		txtrListOfEmployees.setText(datZam.listOfEmployeesByIdToString());
		GroupLayout gl_panelEmployeesList = new GroupLayout(panelEmployeesList);
		gl_panelEmployeesList.setHorizontalGroup(
			gl_panelEmployeesList.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelEmployeesList.createSequentialGroup()
					.addGap(40)
					.addComponent(txtrListOfEmployees, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
					.addGap(100))
		);
		gl_panelEmployeesList.setVerticalGroup(
			gl_panelEmployeesList.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEmployeesList.createSequentialGroup()
					.addGap(40)
					.addComponent(txtrListOfEmployees, GroupLayout.PREFERRED_SIZE, 136, Short.MAX_VALUE)
					.addGap(20))
		);
		panelEmployeesList.setLayout(gl_panelEmployeesList);
		
		panelAdd = new JPanel();
		panelAdd.setBackground(Color.RED);
		panelCenterMain.add(panelAdd, "name_103423694458300");
		
		panelDel = new JPanel();
		panelDel.setBackground(Color.GREEN);
		panelCenterMain.add(panelDel, "name_103427308961800");
	}
	
	private class EventButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnList){
				// removing panel
				panelCenterMain.removeAll();
				panelCenterMain.repaint();
				panelCenterMain.revalidate();
				
				//adding panel
				panelCenterMain.add(panelEmployeesList);
				panelCenterMain.repaint();
				panelCenterMain.revalidate();

				// other changes
				lblTitle.setText("LIST OF EMPLOYEES");
			} else if (e.getSource() == btnAdd) {	
				// removing panel
				panelCenterMain.removeAll();
				panelCenterMain.repaint();
				panelCenterMain.revalidate();
				
				//adding panel
				panelCenterMain.add(panelAdd);
				panelCenterMain.repaint();
				panelCenterMain.revalidate();
				
				// other changes
				lblTitle.setText("ADD NEW EMPLOYEE");
			} else if (e.getSource() == btnDel) {	
				// removing panel
				panelCenterMain.removeAll();
				panelCenterMain.repaint();
				panelCenterMain.revalidate();
				
				//adding panel
				panelCenterMain.add(panelDel);
				panelCenterMain.repaint();
				panelCenterMain.revalidate();

				// other changes
				lblTitle.setText("DELETE AN EMPLOYEE");
			} else if (e.getSource() == btnClose) {
				System.exit(0);
			}
		}
	}
}
