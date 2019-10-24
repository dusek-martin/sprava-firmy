package swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import model.DatabaseOfEmployees;
import model.Employee;
import model.Position;
import model.WorkType;

public class JFrameMainWindow extends JFrame {

	private DatabaseOfEmployees datZam;
	private JPanel contentPane;
	private JPanel panelCenterMain;
	private JPanel panelEmployeesList;
	private JPanel panelAdd;
	private JPanel panelDel;
	private JLabel lblTitle;
	private JLabel lblNumberOfEmployees;
	private JLabel lblDirectorsName;
	private JLabel lblWageIntensity;
	private JLabel lblAddName;
	private JLabel lblAddSurname;
	private JScrollPane scrollPane;
	private JTextArea txtrListOfEmployees;
	private JTextArea txtrListOfEmployeesDel;
	private JTextField textAddName;
	private JTextField textAddSurname;
	private JTextField txtHoursNumber;
	private JButton btnList;
	private JButton btnAdd;
	private JButton btnDelIll;
	private JButton btnClose;
	private JButton btnAddEmployeeToDatabase;
	private JButton btnConfirmChangesWorkingHours;
	private ButtonGroup btnGrp;
	private JRadioButton rdbtnAddDirector;
	private JRadioButton rdbtnAddDeveloper;
	private JRadioButton rdbtnAddTechnicalWorker;
	private JRadioButton rdbtnAddAssistant;
	private JButton btnSetEmployeeIll;
	private JButton btnDeleteEmployee;
	private JComboBox comboBoxEmployeeDel;
	private JComboBox comboBoxWorkAddDel;
	private JComboBox comboBoxWorkType;
	private JButton btnWork;
	private JPanel panelWork;

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

		setTitle("Správa firmy");

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
		panelLeftMain.setBackground(SystemColor.menu);
		panelLeftMain.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.LIGHT_GRAY));
		contentPane.add(panelLeftMain, BorderLayout.WEST);
		GridBagLayout gbl_panelLeftMain = new GridBagLayout();
		gbl_panelLeftMain.columnWidths = new int[] { 100, 0 };
		gbl_panelLeftMain.rowHeights = new int[] { 39, 1, 0, 0, 0, 0, 0, 0 };
		gbl_panelLeftMain.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelLeftMain.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelLeftMain.setLayout(gbl_panelLeftMain);

		Component horizontalStrut = Box.createHorizontalStrut(100);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.anchor = GridBagConstraints.WEST;
		gbc_horizontalStrut.fill = GridBagConstraints.VERTICAL;
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		panelLeftMain.add(horizontalStrut, gbc_horizontalStrut);

		btnList = new JButton("LIST");
		GridBagConstraints gbc_btnList = new GridBagConstraints();
		gbc_btnList.fill = GridBagConstraints.BOTH;
		gbc_btnList.insets = new Insets(5, 10, 5, 10);
		gbc_btnList.gridx = 0;
		gbc_btnList.gridy = 2;
		panelLeftMain.add(btnList, gbc_btnList);

		btnAdd = new JButton("ADD");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.insets = new Insets(5, 10, 5, 10);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 3;
		panelLeftMain.add(btnAdd, gbc_btnAdd);

		btnDelIll = new JButton("DEL/ILL");
		GridBagConstraints gbc_btnDel = new GridBagConstraints();
		gbc_btnDel.fill = GridBagConstraints.BOTH;
		gbc_btnDel.insets = new Insets(5, 10, 5, 10);
		gbc_btnDel.gridx = 0;
		gbc_btnDel.gridy = 4;
		panelLeftMain.add(btnDelIll, gbc_btnDel);

		btnWork = new JButton("WORK");
		GridBagConstraints gbc_btnWork = new GridBagConstraints();
		gbc_btnWork.fill = GridBagConstraints.BOTH;
		gbc_btnWork.insets = new Insets(5, 10, 5, 10);
		gbc_btnWork.gridx = 0;
		gbc_btnWork.gridy = 5;
		panelLeftMain.add(btnWork, gbc_btnWork);

		btnClose = new JButton("CLOSE");
		GridBagConstraints gbc_btnClose = new GridBagConstraints();
		gbc_btnClose.insets = new Insets(5, 10, 5, 10);
		gbc_btnClose.fill = GridBagConstraints.BOTH;
		gbc_btnClose.gridx = 0;
		gbc_btnClose.gridy = 6;
		panelLeftMain.add(btnClose, gbc_btnClose);

		EventButton eventButton = new EventButton();
		btnList.addActionListener(eventButton);
		btnAdd.addActionListener(eventButton);
		btnDelIll.addActionListener(eventButton);
		btnWork.addActionListener(eventButton);
		btnClose.addActionListener(eventButton);

		JPanel panelTopMain = new JPanel();
		panelTopMain.setBackground(SystemColor.menu);
		panelTopMain.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		contentPane.add(panelTopMain, BorderLayout.NORTH);

		lblTitle = new JLabel("LIST OF EMPLOYEES");
		panelTopMain.add(lblTitle);

		Component verticalStrut = Box.createVerticalStrut(40);
		panelTopMain.add(verticalStrut);

		panelCenterMain = new JPanel();
		contentPane.add(panelCenterMain, BorderLayout.CENTER);
		panelCenterMain.setLayout(new CardLayout(0, 0));

		panelEmployeesList = new JPanel();
		panelEmployeesList.setBackground(SystemColor.menu);
		panelCenterMain.add(panelEmployeesList, "name_103383212123600");

		scrollPane = new JScrollPane();

		lblWageIntensity = new JLabel("Mìsíèní mzdová nároènost: " + datZam.getCosts() + " Kè");
		lblNumberOfEmployees = new JLabel("Poèet zamìstnancù celkem: " + datZam.getArrayList().size());
		lblDirectorsName = new JLabel("Øeditel: " + datZam.findEmployee(datZam.getDirectorsId()).getName() + " "
				+ datZam.findEmployee(datZam.getDirectorsId()).getSurname() + ", ID " + datZam.getDirectorsId() + " ");

		GroupLayout gl_panelEmployeesList = new GroupLayout(panelEmployeesList);
		gl_panelEmployeesList.setHorizontalGroup(gl_panelEmployeesList.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelEmployeesList.createSequentialGroup().addGroup(gl_panelEmployeesList
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelEmployeesList.createSequentialGroup().addContainerGap()
								.addComponent(lblDirectorsName))
						.addGroup(gl_panelEmployeesList.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelEmployeesList.createSequentialGroup().addContainerGap()
										.addComponent(lblNumberOfEmployees))
								.addGroup(gl_panelEmployeesList.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelEmployeesList.createSequentialGroup().addContainerGap()
												.addComponent(lblWageIntensity))
										.addGroup(gl_panelEmployeesList.createSequentialGroup().addGap(40).addComponent(
												scrollPane, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)))))
						.addGap(100)));
		gl_panelEmployeesList.setVerticalGroup(gl_panelEmployeesList.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelEmployeesList.createSequentialGroup().addGap(40)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE).addGap(15)
						.addComponent(lblDirectorsName).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNumberOfEmployees).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblWageIntensity).addContainerGap()));

		txtrListOfEmployees = new JTextArea();
		txtrListOfEmployees.setEditable(false);
		txtrListOfEmployees.setText(datZam.listOfEmployeesByIdWithWorkToString());
		scrollPane.setViewportView(txtrListOfEmployees);
		panelEmployeesList.setLayout(gl_panelEmployeesList);

		panelAdd = new JPanel();
		panelAdd.setBackground(SystemColor.menu);
		panelCenterMain.add(panelAdd, "name_103423694458300");

		lblAddName = new JLabel("Name:");

		lblAddSurname = new JLabel("Surname:");

		textAddName = new JTextField();
		textAddName.setColumns(10);

		textAddSurname = new JTextField();
		textAddSurname.setColumns(10);

		JLabel lblAddPozice = new JLabel("Position:");
		btnGrp = new ButtonGroup();
		rdbtnAddDirector = new JRadioButton("Director");
		rdbtnAddDeveloper = new JRadioButton("Developer");
		rdbtnAddTechnicalWorker = new JRadioButton("Technical worker");
		rdbtnAddAssistant = new JRadioButton("Assistant");
		btnGrp.add(rdbtnAddDirector);
		btnGrp.add(rdbtnAddDeveloper);
		btnGrp.add(rdbtnAddTechnicalWorker);
		btnGrp.add(rdbtnAddAssistant);

		btnAddEmployeeToDatabase = new JButton("ADD EMPLOYEE");
		btnAddEmployeeToDatabase.addActionListener(eventButton);

		GroupLayout gl_panelAdd = new GroupLayout(panelAdd);
		gl_panelAdd.setHorizontalGroup(gl_panelAdd.createParallelGroup(Alignment.TRAILING).addGroup(gl_panelAdd
				.createSequentialGroup().addGap(40)
				.addGroup(gl_panelAdd.createParallelGroup(Alignment.LEADING).addComponent(lblAddName)
						.addComponent(lblAddSurname).addComponent(lblAddPozice))
				.addGap(32)
				.addGroup(gl_panelAdd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAdd.createSequentialGroup().addComponent(rdbtnAddDirector).addGap(18)
								.addComponent(rdbtnAddDeveloper).addGap(18).addComponent(rdbtnAddTechnicalWorker)
								.addGap(18).addComponent(rdbtnAddAssistant))
						.addGroup(gl_panelAdd.createParallelGroup(Alignment.LEADING, false).addComponent(textAddSurname)
								.addComponent(textAddName, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
				.addContainerGap(90, Short.MAX_VALUE))
				.addGroup(gl_panelAdd.createSequentialGroup().addContainerGap(494, Short.MAX_VALUE)
						.addComponent(btnAddEmployeeToDatabase, GroupLayout.PREFERRED_SIZE, 150,
								GroupLayout.PREFERRED_SIZE)
						.addGap(20)));
		gl_panelAdd.setVerticalGroup(gl_panelAdd.createParallelGroup(Alignment.LEADING).addGroup(gl_panelAdd
				.createSequentialGroup().addGap(40)
				.addGroup(gl_panelAdd.createParallelGroup(Alignment.BASELINE).addComponent(lblAddName).addComponent(
						textAddName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panelAdd.createParallelGroup(Alignment.BASELINE).addComponent(lblAddSurname).addComponent(
						textAddSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addGroup(gl_panelAdd.createParallelGroup(Alignment.BASELINE).addComponent(lblAddPozice)
						.addComponent(rdbtnAddDirector).addComponent(rdbtnAddDeveloper)
						.addComponent(rdbtnAddTechnicalWorker).addComponent(rdbtnAddAssistant))
				.addPreferredGap(ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
				.addComponent(btnAddEmployeeToDatabase, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addGap(20)));
		panelAdd.setLayout(gl_panelAdd);

		panelDel = new JPanel();
		panelDel.setBackground(SystemColor.menu);
		panelCenterMain.add(panelDel, "name_103427308961800");

		JScrollPane scrollPaneListDel = new JScrollPane();

		comboBoxEmployeeDel = new JComboBox();
		comboBoxEmployeeDel.addItem("Vyber zamìstnance ze seznamu níže:");
		for (Employee e : datZam.getArrayList()) {
			comboBoxEmployeeDel.addItem(e.toString());
		}

		btnSetEmployeeIll = new JButton("SET EMPLOYEE ILL/HEALTHY");

		btnDeleteEmployee = new JButton("DELETE EMPLOYEE");

		btnSetEmployeeIll.addActionListener(eventButton);
		btnDeleteEmployee.addActionListener(eventButton);

		GroupLayout gl_panelDel = new GroupLayout(panelDel);
		gl_panelDel.setHorizontalGroup(gl_panelDel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelDel.createSequentialGroup()
						.addGroup(gl_panelDel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelDel.createSequentialGroup().addContainerGap().addComponent(
										btnDeleteEmployee, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelDel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelDel.createSequentialGroup()
												.addContainerGap(364, Short.MAX_VALUE).addComponent(btnSetEmployeeIll,
														GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelDel.createSequentialGroup().addGap(40)
												.addGroup(gl_panelDel.createParallelGroup(Alignment.TRAILING)
														.addComponent(comboBoxEmployeeDel, Alignment.LEADING, 0, 484,
																Short.MAX_VALUE)
														.addComponent(scrollPaneListDel, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)))))
						.addGap(100)));
		gl_panelDel.setVerticalGroup(gl_panelDel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDel.createSequentialGroup().addGap(40)
						.addComponent(scrollPaneListDel, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE).addGap(20)
						.addComponent(comboBoxEmployeeDel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(20)
						.addComponent(btnSetEmployeeIll, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(15)
						.addComponent(btnDeleteEmployee, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(40)));

		txtrListOfEmployeesDel = new JTextArea();
		txtrListOfEmployeesDel.setText(datZam.listOfEmployeesByIdWithWorkToString());
		txtrListOfEmployeesDel.setEditable(false);
		scrollPaneListDel.setViewportView(txtrListOfEmployeesDel);
		panelDel.setLayout(gl_panelDel);

		panelWork = new JPanel();
		panelCenterMain.add(panelWork, "name_13075724238800");

		comboBoxWorkAddDel = new JComboBox();
		comboBoxWorkAddDel.addItem("Pøidat nebo odebrat?");
		comboBoxWorkAddDel.addItem("Pøidat:");
		comboBoxWorkAddDel.addItem("Odebrat:");

		txtHoursNumber = new JTextField();
		txtHoursNumber.setText("poèet hodin");
		txtHoursNumber.setColumns(10);

		comboBoxWorkType = new JComboBox();
		comboBoxWorkType.addItem("Vyber typ práce ze seznamu níže:");
		int workTypeNumber = 1;
		while (WorkType.getWorkType(workTypeNumber) != null) {
			comboBoxWorkType.addItem(WorkType.getWorkType(workTypeNumber));
			workTypeNumber++;
		}

		btnConfirmChangesWorkingHours = new JButton("CONFIRM");
		btnConfirmChangesWorkingHours.addActionListener(eventButton);
		GroupLayout gl_panelWork = new GroupLayout(panelWork);
		gl_panelWork.setHorizontalGroup(gl_panelWork.createParallelGroup(Alignment.LEADING).addGroup(gl_panelWork
				.createSequentialGroup().addGap(40)
				.addComponent(comboBoxWorkAddDel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
				.addGap(40).addComponent(txtHoursNumber, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
				.addGap(40).addComponent(comboBoxWorkType, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						gl_panelWork.createSequentialGroup().addContainerGap(364, Short.MAX_VALUE)
								.addComponent(btnConfirmChangesWorkingHours, GroupLayout.PREFERRED_SIZE, 250,
										GroupLayout.PREFERRED_SIZE)
								.addGap(40)));
		gl_panelWork.setVerticalGroup(gl_panelWork.createParallelGroup(Alignment.LEADING).addGroup(gl_panelWork
				.createSequentialGroup().addGap(40)
				.addGroup(gl_panelWork.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxWorkAddDel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtHoursNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxWorkType, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
				.addComponent(btnConfirmChangesWorkingHours, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addGap(20)));
		panelWork.setLayout(gl_panelWork);
	}

	private class EventButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnList) {
				changePanelCentralMain(panelEmployeesList);
				// other changes
				lblTitle.setText("LIST OF EMPLOYEES");
			} else if (e.getSource() == btnAdd) {
				changePanelCentralMain(panelAdd);
				// other changes
				lblTitle.setText("ADD NEW EMPLOYEE");
			} else if (e.getSource() == btnDelIll) {
				changePanelCentralMain(panelDel);
				// other changes
				lblTitle.setText("DELETE AN EMPLOYEE OR SET EMPLOYEE ILL/HEALTHY");
			} else if (e.getSource() == btnWork) {
				changePanelCentralMain(panelWork);
				// other changes
				lblTitle.setText("ADD OR REMOVE SOME WORKING HOURS");
			} else if (e.getSource() == btnAddEmployeeToDatabase) {
				btnAddEmployeeToDatabase();
			} else if (e.getSource() == btnSetEmployeeIll) {
				btnSetEmployeeIll();
			} else if (e.getSource() == btnDeleteEmployee) {
				btnDeleteEmployee();
			} else if (e.getSource() == btnConfirmChangesWorkingHours) {
				btnConfirmChangesWorkingHours();
			} else if (e.getSource() == btnClose) {
				System.exit(0);
			}
		}

		private void refresh() {
			datZam.saveToCSV();
			txtrListOfEmployees.setText(datZam.listOfEmployeesByIdWithWorkToString());
			txtrListOfEmployeesDel.setText(datZam.listOfEmployeesByIdWithWorkToString());
			textAddName.setText("");
			textAddSurname.setText("");
			lblNumberOfEmployees.setText("Poèet zamìstnancù celkem: " + datZam.getArrayList().size());
			lblDirectorsName.setText("Øeditel: " + datZam.findEmployee(datZam.getDirectorsId()).getName() + " "
					+ datZam.findEmployee(datZam.getDirectorsId()).getSurname() + ", ID " + datZam.getDirectorsId()
					+ " ");
			lblWageIntensity.setText("Mìsíèní mzdová nároènost: " + datZam.getCosts() + " Kè");

			comboBoxWorkAddDel.setSelectedIndex(0);
			comboBoxWorkType.setSelectedIndex(0);
			txtHoursNumber.setText("poèet hodin");
			comboBoxEmployeeDel.removeAllItems();
			comboBoxEmployeeDel.addItem("Vyber zamìstnance ze seznamu níže:");
			for (Employee employee1 : datZam.getArrayList()) {
				comboBoxEmployeeDel.addItem(employee1.toString());
			}
		}

		private void changePanelCentralMain(JPanel jPanel) {
			// removing panel
			panelCenterMain.removeAll();
			panelCenterMain.repaint();
			panelCenterMain.revalidate();
			// adding panel
			panelCenterMain.add(jPanel);
			panelCenterMain.repaint();
			panelCenterMain.revalidate();
		}

		private void btnAddEmployeeToDatabase() {
			String name = textAddName.getText();
			String surname = textAddSurname.getText();
			Position position;
			if (rdbtnAddDirector.isSelected()) {
				position = Position.director;
			} else if (rdbtnAddDeveloper.isSelected()) {
				position = Position.developer;
			} else if (rdbtnAddTechnicalWorker.isSelected()) {
				position = Position.technicalWorker;
			} else if (rdbtnAddAssistant.isSelected()) {
				position = Position.assistant;
			} else {
				return;
			}
			if ((name != null && !name.isEmpty()) && (surname != null && !surname.isEmpty())) {
				btnGrp.clearSelection();
				datZam.addEmployee(name, surname, position);
				refresh();
			} else {
				return;
			}
			changePanelCentralMain(panelEmployeesList);
			// other changes
			lblTitle.setText("LIST OF EMPLOYEES");
		}

		private void btnSetEmployeeIll() {
			boolean succes = false;
			for (Employee employee : datZam.getArrayList()) {
				if (((String) comboBoxEmployeeDel.getSelectedItem()).equals(employee.toString())) {

					if (employee.isHealthy()) {
						datZam.setEmployeeIll(employee.getId());
					} else {
						datZam.setEmployeeHealthy(employee.getId());
					}
					comboBoxEmployeeDel.setSelectedIndex(0);
					refresh();
					succes = true;
					break;
				}
			}
			if (!succes) {
				return;
			}
			changePanelCentralMain(panelDel);
			// other changes
			lblTitle.setText("EMPLOYEE'S HEALTH CHANGED");
		}

		private void btnDeleteEmployee() {
			boolean succes = false;
			for (Employee employee : datZam.getArrayList()) {
				if (((String) comboBoxEmployeeDel.getSelectedItem()).equals(employee.toString())) {
					datZam.deleteEmployee(employee.getId());
					comboBoxEmployeeDel.setSelectedIndex(0);
					refresh();
					succes = true;
					break;
				}
			}
			if (!succes) {
				return;
			}
			changePanelCentralMain(panelDel);
			// other changes
			lblTitle.setText("EMPLOYEE DELETED");
		}

		private void btnConfirmChangesWorkingHours() {
			
			if ((txtHoursNumber.getText() == null && txtHoursNumber.getText().isEmpty()) || (!isThisInteger(txtHoursNumber.getText()))) {
				return;
			}
			
			WorkType workType = (WorkType)comboBoxWorkType.getSelectedItem();
			txtHoursNumber.setText(txtHoursNumber.getText().trim());
			int hoursNumber = Integer.parseInt(txtHoursNumber.getText());
			
			if (comboBoxWorkAddDel.getSelectedIndex() == 1) {
				datZam.divideTheWorkEffectively((WorkType)comboBoxWorkType.getSelectedItem(), hoursNumber);
				// other changes
				lblTitle.setText("ADDED "+hoursNumber+" HOURS OF "+((WorkType)comboBoxWorkType.getSelectedItem()).toString());
				refresh();
				changePanelCentralMain(panelEmployeesList);
			} else if (comboBoxWorkAddDel.getSelectedIndex() == 2) {
				datZam.removeTheWorkEffectively((WorkType)comboBoxWorkType.getSelectedItem(), hoursNumber);
				// other changes
				lblTitle.setText("REMOVED "+hoursNumber+" HOURS OF "+((WorkType)comboBoxWorkType.getSelectedItem()).toString());
				refresh();
				changePanelCentralMain(panelEmployeesList);
			} else {
				return;
			}
		}
		
		private boolean isThisInteger(String number) {
			try {
				int i = Integer.parseInt(number);
				return true;
			} catch (Exception e) {
				return false;
			}
		}

	}
}
