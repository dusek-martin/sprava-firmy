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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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

public class JFrameMainWindow extends JFrame implements ActionListener, FocusListener {

	private DatabaseOfEmployees datZam;
	private JPanel contentPane;
	private JPanel panelCenterMain;
	private JPanel panelEmployeesList;
	private JPanel panelAdd;
	private JPanel panelDel;
	private JPanel panelWork;
	private JLabel lblTitle;
	private JLabel lblNumberOfEmployees;
	private JLabel lblDirectorsName;
	private JLabel lblWageIntensity;
	private JLabel lblAddName;
	private JLabel lblAddSurname;
	private JLabel lblHowMuchWork;
	private JLabel lblWorkHowMuchAdministration;
	private JLabel lblWorkHowMuchDocumentation;
	private JLabel lblWorkHowMuchDevelopment;
	private JScrollPane scrollPane;
	private JTextArea txtrListOfEmployees;
	private JTextField textAddName;
	private JTextField textAddSurname;
	private JTextField txtHoursNumber;
	private JButton btnList;
	private JButton btnAdd;
	private JButton btnDelIll;
	private JButton btnClose;
	private JButton btnAddEmployeeToDatabase;
	private JButton btnConfirmChangesWorkingHours;
	private JButton btnChangeEmployeeHealth;
	private JButton btnDeleteEmployee;
	private JButton btnWork;
	private JButton btnEmployeeChangeEvaluation;
	private JButton btnEmployeeChangeMaxWorkingHours;
	private JButton btnSortById;
	private JButton btnSortBySurname;
	private JButton btnSortByIdClean;
	private JButton btnSortBySurnameClean;
	private JButton btnConfirmChangesMaxWorkingHoursAll;
	private ButtonGroup btnGrp;
	private JRadioButton rdbtnAddDirector;
	private JRadioButton rdbtnAddDeveloper;
	private JRadioButton rdbtnAddTechnicalWorker;
	private JRadioButton rdbtnAddAssistant;
	private JComboBox comboBoxWorkAddDel;
	private JComboBox comboBoxWorkType;
	private JTextField txtEmployeeChangeEvaluation;
	private JTextField txtEmployeeMaxWorkingHours;
	private JLabel lblChangeMaxWorkingHoursAll;
	private JTextField txtMaxWorkingHoursAll;
	private DefaultListModel modelSelectEmployee;
	private JList listSelectEmployee;
	
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
			setTitle("Couldn't load the database.");
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 550);
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

		btnAdd = new JButton("ADD EMP");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.insets = new Insets(5, 10, 5, 10);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 3;
		panelLeftMain.add(btnAdd, gbc_btnAdd);

		btnDelIll = new JButton("EDIT EMP");
		GridBagConstraints gbc_btnDel = new GridBagConstraints();
		gbc_btnDel.fill = GridBagConstraints.BOTH;
		gbc_btnDel.insets = new Insets(5, 10, 5, 10);
		gbc_btnDel.gridx = 0;
		gbc_btnDel.gridy = 4;
		panelLeftMain.add(btnDelIll, gbc_btnDel);

		btnWork = new JButton("WORK CHNG");
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

		btnList.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDelIll.addActionListener(this);
		btnWork.addActionListener(this);
		btnClose.addActionListener(this);

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

		lblWageIntensity = new JLabel("Monthly salary payment: " + datZam.getCosts() + " Kè");
		lblNumberOfEmployees = new JLabel("Number of employees: " + datZam.getArrayList().size());
		lblDirectorsName = new JLabel("");
		if (datZam.isDirectorAlready()) {
			lblDirectorsName.setText(
					String.format("Director: %s %s, ID %d", datZam.findEmployee(datZam.getDirectorsId()).getName(),
							datZam.findEmployee(datZam.getDirectorsId()).getSurname(), datZam.getDirectorsId()));
		} else {
			lblDirectorsName.setText("Company has not any director!");
		}

		/*
		 * lblDirectorsName = new JLabel("Øeditel: " +
		 * datZam.findEmployee(datZam.getDirectorsId()).getName() + " " +
		 * datZam.findEmployee(datZam.getDirectorsId()).getSurname() + ", ID " +
		 * datZam.getDirectorsId() + " ");
		 */

		btnSortById = new JButton("BY ID");
		btnSortBySurname = new JButton("BY SURNAME");
		btnSortByIdClean = new JButton("ID CLEAN");
		btnSortBySurnameClean = new JButton("BY SUR CLEAN");
		btnSortById.addActionListener(this);
		btnSortBySurname.addActionListener(this);
		btnSortByIdClean.addActionListener(this);
		btnSortBySurnameClean.addActionListener(this);

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
												scrollPane, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)))))
						.addGap(10)
						.addGroup(gl_panelEmployeesList.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelEmployeesList.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnSortById, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSortBySurname, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(btnSortByIdClean, GroupLayout.PREFERRED_SIZE, 130,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSortBySurnameClean, GroupLayout.PREFERRED_SIZE, 130,
										GroupLayout.PREFERRED_SIZE))
						.addGap(10)));
		gl_panelEmployeesList.setVerticalGroup(gl_panelEmployeesList.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelEmployeesList.createSequentialGroup().addGap(40).addGroup(gl_panelEmployeesList
						.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
						.addGroup(gl_panelEmployeesList.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSortById, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(btnSortBySurname, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(btnSortByIdClean, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(btnSortBySurnameClean, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 213, Short.MAX_VALUE)))
						.addGap(15).addComponent(lblDirectorsName).addPreferredGap(ComponentPlacement.RELATED)
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
		rdbtnAddTechnicalWorker = new JRadioButton("Designer");
		rdbtnAddAssistant = new JRadioButton("Assistant");
		btnGrp.add(rdbtnAddDirector);
		btnGrp.add(rdbtnAddDeveloper);
		btnGrp.add(rdbtnAddTechnicalWorker);
		btnGrp.add(rdbtnAddAssistant);

		btnAddEmployeeToDatabase = new JButton("ADD EMPLOYEE");
		btnAddEmployeeToDatabase.addActionListener(this);

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

		btnChangeEmployeeHealth = new JButton("SET EMPLOYEE ILL/HEALTHY");

		btnDeleteEmployee = new JButton("DELETE EMPLOYEE");

		btnChangeEmployeeHealth.addActionListener(this);
		btnDeleteEmployee.addActionListener(this);

		txtEmployeeChangeEvaluation = new JTextField();
		txtEmployeeChangeEvaluation.setText("hour evaluation");
		txtEmployeeChangeEvaluation.setColumns(10);
		txtEmployeeChangeEvaluation.addFocusListener(this);

		btnEmployeeChangeEvaluation = new JButton("CHANGE EMPLOYEE'S EVALUATION");

		txtEmployeeMaxWorkingHours = new JTextField();
		txtEmployeeMaxWorkingHours.setText("max number of working hours");
		txtEmployeeMaxWorkingHours.setColumns(10);
		txtEmployeeMaxWorkingHours.addFocusListener(this);

		btnEmployeeChangeMaxWorkingHours = new JButton("CHANGE EMPLOYEE'S MAX WORKING HOURS");
		btnEmployeeChangeEvaluation.addActionListener(this);
		btnEmployeeChangeMaxWorkingHours.addActionListener(this);

		GroupLayout gl_panelDel = new GroupLayout(panelDel);
		gl_panelDel.setHorizontalGroup(
			gl_panelDel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelDel.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_panelDel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelDel.createSequentialGroup()
							.addComponent(txtEmployeeMaxWorkingHours, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEmployeeChangeMaxWorkingHours, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
							.addComponent(btnDeleteEmployee, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDel.createSequentialGroup()
							.addComponent(txtEmployeeChangeEvaluation, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnEmployeeChangeEvaluation, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
							.addComponent(btnChangeEmployeeHealth, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPaneListDel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE))
					.addGap(40))
		);
		gl_panelDel.setVerticalGroup(
			gl_panelDel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDel.createSequentialGroup()
					.addGap(40)
					.addComponent(scrollPaneListDel, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
					.addGap(20)
					.addGroup(gl_panelDel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChangeEmployeeHealth, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmployeeChangeEvaluation, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEmployeeChangeEvaluation, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panelDel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeleteEmployee, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmployeeMaxWorkingHours, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEmployeeChangeMaxWorkingHours, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		
		modelSelectEmployee = new DefaultListModel();
		listSelectEmployee = new JList(modelSelectEmployee);
		scrollPaneListDel.setViewportView(listSelectEmployee);
		int index = 0;
		for (Employee e: datZam.getArrayList()) {
			modelSelectEmployee.add(index, e);
			index++;
		}
		
		panelDel.setLayout(gl_panelDel);

		panelWork = new JPanel();
		panelCenterMain.add(panelWork, "name_13075724238800");

		comboBoxWorkAddDel = new JComboBox();
		comboBoxWorkAddDel.addItem("Add or remove?");
		comboBoxWorkAddDel.addItem("Add:");
		comboBoxWorkAddDel.addItem("Remove:");

		txtHoursNumber = new JTextField();
		txtHoursNumber.setText("number of hours");
		txtHoursNumber.setColumns(10);
		txtHoursNumber.addFocusListener(this);

		comboBoxWorkType = new JComboBox();
		comboBoxWorkType.setToolTipText("choose type of work");
//		comboBoxWorkType.setModel(new DefaultComboBoxModel(WorkType.values()));
		comboBoxWorkType.addItem("Choose type of work:");
		int workTypeNumber = 1;
		while (WorkType.getWorkType(workTypeNumber) != null) {
			comboBoxWorkType.addItem(WorkType.getWorkType(workTypeNumber));
			workTypeNumber++;
		}

		btnConfirmChangesWorkingHours = new JButton("CONFIRM");
		btnConfirmChangesWorkingHours.addActionListener(this);

		lblWorkHowMuchAdministration = new JLabel(
				String.format("Total %d hours of administration", datZam.getWorkTypeHours()[0]));
		lblWorkHowMuchDocumentation = new JLabel(
				String.format("Total %d hours of documentation", datZam.getWorkTypeHours()[1]));
		lblWorkHowMuchDevelopment = new JLabel(
				String.format("Total %d hours of development", datZam.getWorkTypeHours()[2]));
		lblHowMuchWork = new JLabel(String.format("TOTAL: %d hours of work",
				(datZam.getWorkTypeHours()[0] + datZam.getWorkTypeHours()[1] + datZam.getWorkTypeHours()[2])));

		lblChangeMaxWorkingHoursAll = new JLabel("Change maximum working hours per moth for all:");

		txtMaxWorkingHoursAll = new JTextField();
		txtMaxWorkingHoursAll.setText("160");
		txtMaxWorkingHoursAll.setColumns(10);
		txtMaxWorkingHoursAll.addFocusListener(this);

		btnConfirmChangesMaxWorkingHoursAll = new JButton("CONFIRM");
		btnConfirmChangesMaxWorkingHoursAll.addActionListener(this);

		GroupLayout gl_panelWork = new GroupLayout(panelWork);
		gl_panelWork.setHorizontalGroup(
			gl_panelWork.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWork.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_panelWork.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHowMuchWork)
						.addComponent(lblWorkHowMuchDevelopment, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWorkHowMuchDocumentation, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWorkHowMuchAdministration, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelWork.createSequentialGroup()
							.addGroup(gl_panelWork.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelWork.createSequentialGroup()
									.addComponent(comboBoxWorkAddDel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGap(40)
									.addComponent(txtHoursNumber, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelWork.createSequentialGroup()
									.addComponent(lblChangeMaxWorkingHoursAll, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
									.addGap(5)
									.addComponent(txtMaxWorkingHoursAll, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
							.addGap(35)
							.addGroup(gl_panelWork.createParallelGroup(Alignment.LEADING)
								.addComponent(btnConfirmChangesMaxWorkingHoursAll)
								.addGroup(gl_panelWork.createSequentialGroup()
									.addComponent(comboBoxWorkType, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
									.addComponent(btnConfirmChangesWorkingHours, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_panelWork.setVerticalGroup(
			gl_panelWork.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWork.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_panelWork.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxWorkAddDel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtHoursNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxWorkType, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConfirmChangesWorkingHours, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addComponent(lblWorkHowMuchAdministration, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblWorkHowMuchDocumentation, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblWorkHowMuchDevelopment, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHowMuchWork)
					.addGap(20)
					.addGroup(gl_panelWork.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChangeMaxWorkingHoursAll, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMaxWorkingHoursAll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConfirmChangesMaxWorkingHoursAll))
					.addContainerGap(236, Short.MAX_VALUE))
		);
		panelWork.setLayout(gl_panelWork);
	}

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
		} else if (e.getSource() == btnSortById) {
			txtrListOfEmployees.setText(datZam.listOfEmployeesByIdWithWorkToString());
		} else if (e.getSource() == btnSortBySurname) {
			txtrListOfEmployees.setText(datZam.listOfEmployeesBySurnameWithWorkToString());
		} else if (e.getSource() == btnSortByIdClean) {
			txtrListOfEmployees.setText(datZam.listOfEmployeesByIdToString());
		} else if (e.getSource() == btnSortBySurnameClean) {
			txtrListOfEmployees.setText(datZam.listOfEmployeesBySurnameToString());
		} else if (e.getSource() == btnAddEmployeeToDatabase) {
			onAddEmployeeToDatabase();
		} else if (e.getSource() == btnChangeEmployeeHealth) {
			onChangeEmployeesHealth();
		} else if (e.getSource() == btnDeleteEmployee) {
			onDeleteEmployee();
		} else if (e.getSource() == btnEmployeeChangeEvaluation) {
			onEmployeeChangeEvaluation();
		} else if (e.getSource() == btnEmployeeChangeMaxWorkingHours) {
			onEmployeeChangeMaxWorkingHours();
		} else if (e.getSource() == btnConfirmChangesWorkingHours) {
			onConfirmChangesWorkingHours();
		} else if (e.getSource() == btnConfirmChangesMaxWorkingHoursAll) {
			onConfirmChangesMaxWorkingHoursAll();
		} else if (e.getSource() == btnClose) {
			System.exit(0);
		}
	}

	public void focusGained(FocusEvent e) {
		if (e.getSource() == txtEmployeeChangeEvaluation) {
			txtEmployeeChangeEvaluation.setText("");
		} else if (e.getSource() == txtEmployeeMaxWorkingHours) {
			txtEmployeeMaxWorkingHours.setText("");
		} else if (e.getSource() == txtHoursNumber) {
			txtHoursNumber.setText("");
		} else if (e.getSource() == txtMaxWorkingHoursAll) {
			txtMaxWorkingHoursAll.setText("");
		}
	}

	public void focusLost(FocusEvent e) {
		if (e.getSource() == txtEmployeeChangeEvaluation) {
			if ((((String) txtEmployeeChangeEvaluation.getText()).trim().isEmpty())) {
				txtEmployeeChangeEvaluation.setText("hour evaluation");
			}
		} else if (e.getSource() == txtEmployeeMaxWorkingHours) {
			if ((((String) txtEmployeeMaxWorkingHours.getText()).trim().isEmpty())) {
				txtEmployeeMaxWorkingHours.setText("max number of working hours");
			}
		} else if (e.getSource() == txtHoursNumber) {
			if ((((String) txtHoursNumber.getText()).trim().isEmpty())) {
				txtHoursNumber.setText("number of hours");
			}
		} else if (e.getSource() == txtMaxWorkingHoursAll) {
			if ((((String) txtMaxWorkingHoursAll.getText()).trim().isEmpty())) {
				txtMaxWorkingHoursAll.setText("160");
			}
		}
	}

	private void refresh() {
		datZam.saveToCSV();
		txtrListOfEmployees.setText(datZam.listOfEmployeesByIdWithWorkToString());
		textAddName.setText("");
		textAddSurname.setText("");
		lblNumberOfEmployees.setText("Number of employees: " + datZam.getArrayList().size());
		if (datZam.isDirectorAlready()) {
			lblDirectorsName.setText(
					String.format("Director: %s %s, ID %d", datZam.findEmployee(datZam.getDirectorsId()).getName(),
							datZam.findEmployee(datZam.getDirectorsId()).getSurname(), datZam.getDirectorsId()));
		} else {
			lblDirectorsName.setText("Company has not any director!");
		}
		lblWageIntensity.setText("Monthly salary payment: " + datZam.getCosts() + " Kè");

		lblHowMuchWork.setText(String.format("TOTAL: %d hours of work",
				(datZam.getWorkTypeHours()[0] + datZam.getWorkTypeHours()[1] + datZam.getWorkTypeHours()[2])));
		lblWorkHowMuchAdministration
				.setText(String.format("Total: %d hours of administration", datZam.getWorkTypeHours()[0]));
		lblWorkHowMuchDocumentation
				.setText(String.format("Total: %d hours of documentation", datZam.getWorkTypeHours()[1]));
		lblWorkHowMuchDevelopment.setText(String.format("Total: %d hours of development", datZam.getWorkTypeHours()[2]));
		comboBoxWorkAddDel.setSelectedIndex(0);
		comboBoxWorkType.setSelectedIndex(0);
		txtHoursNumber.setText("number of hours");

		txtEmployeeChangeEvaluation.setText("hour evaluation");
		txtEmployeeMaxWorkingHours.setText("max number of working hours");
		txtMaxWorkingHoursAll.setText("160");
		
		int index = 0;
		modelSelectEmployee.clear();
		for (Employee e: datZam.getArrayList()) {
			modelSelectEmployee.add(index, e);
			index++;
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

	private void onAddEmployeeToDatabase() {
		String name = textAddName.getText().trim();
		String surname = textAddSurname.getText().trim();

		Position position;
		if (rdbtnAddDirector.isSelected()) {
			position = Position.director;
		} else if (rdbtnAddDeveloper.isSelected()) {
			position = Position.developer;
		} else if (rdbtnAddTechnicalWorker.isSelected()) {
			position = Position.designer;
		} else if (rdbtnAddAssistant.isSelected()) {
			position = Position.assistant;
		} else {
			return;
		}
		if ((name != null && !name.isEmpty()) && (surname != null && !surname.isEmpty())) {
			btnGrp.clearSelection();
			datZam.addEmployee(name, surname, position);
			refresh();
			changePanelCentralMain(panelEmployeesList);
			// other changes
			lblTitle.setText("LIST OF EMPLOYEES");
		}
	}

	private void onChangeEmployeesHealth() {
		for (Employee employee : datZam.getArrayList()) {
			if (listSelectEmployee.getSelectedValue() == employee) {

				if (employee.isHealthy()) {
					datZam.setEmployeeIll(employee.getId());
				} else {
					datZam.setEmployeeHealthy(employee.getId());
				}

				refresh();
				// other changes
				lblTitle.setText("EMPLOYEE'S HEALTH CHANGED");
				return;
			}
		}
	}

	private void onDeleteEmployee() {
		// LOOP:
		for (Employee employee : datZam.getArrayList()) {
			if (listSelectEmployee.getSelectedValue() == employee) {
				datZam.deleteEmployee(employee.getId());
				refresh();
				// other changes
				lblTitle.setText("EMPLOYEE DELETED");
				// break loop;
				return;
			}
		}
		lblTitle.setText("FAIL IN DELETING EMPLOYEE");
	}

	private void onEmployeeChangeEvaluation() {
		txtEmployeeChangeEvaluation.setText(txtEmployeeChangeEvaluation.getText().trim());
		if ((txtEmployeeChangeEvaluation.getText() == null && txtEmployeeChangeEvaluation.getText().isEmpty())
				|| (!isInteger(txtEmployeeChangeEvaluation.getText()))) {
			return;
		}
		int newEvaluation = Integer.parseInt(txtEmployeeChangeEvaluation.getText());
		// LOOP:
		for (Employee employee : datZam.getArrayList()) {
			if (listSelectEmployee.getSelectedValue() == employee) {
				employee.setEvaluation(newEvaluation);
				refresh();
				// other changes
				lblTitle.setText("EMPLOYEE'S EVALUATION CAHNGED");
				// break loop;
				return;
			}
		}
		lblTitle.setText("FAIL IN CHANGING EMPLOYEE'S EVALUATION");
	}

	private void onEmployeeChangeMaxWorkingHours() {
		txtEmployeeMaxWorkingHours.setText(txtEmployeeMaxWorkingHours.getText().trim());
		if ((txtEmployeeMaxWorkingHours.getText() == null && txtEmployeeMaxWorkingHours.getText().isEmpty())
				|| (!isInteger(txtEmployeeMaxWorkingHours.getText()))) {
			return;
		}
		int newMaxWorkingHours = Integer.parseInt(txtEmployeeMaxWorkingHours.getText());
		// LOOP:
		for (Employee employee : datZam.getArrayList()) {
			if (listSelectEmployee.getSelectedValue() == employee) {
				if (employee.setMaxWorkingHours(newMaxWorkingHours)) {
					refresh();
					// other changes
					lblTitle.setText("EMPLOYEE'S MAX WORKING HOURS CAHNGED");
					// break loop;
					return;
				} else {
					lblTitle.setText("FAIL IN CHANGING EMPLOYEE'S MAX WORKING HOURS");
					return;
				}
			}
		}
	}

	private void onConfirmChangesWorkingHours() {

		txtHoursNumber.setText(txtHoursNumber.getText().trim());
		if ((txtHoursNumber.getText() == null && txtHoursNumber.getText().isEmpty())
				|| (!isInteger(txtHoursNumber.getText())) || (comboBoxWorkAddDel.getSelectedIndex() == 0)
				|| (comboBoxWorkType.getSelectedIndex() == 0)) {
			return;
		}
//			WorkType workType = (WorkType)comboBoxWorkType.getSelectedItem();
		int hoursNumber = Integer.parseInt(txtHoursNumber.getText());

		if (comboBoxWorkAddDel.getSelectedIndex() == 1) {
			lblTitle.setText(String.format(
					"ADDED %d HOURS OF %s", (hoursNumber - datZam
							.divideTheWorkEffectively((WorkType) comboBoxWorkType.getSelectedItem(), hoursNumber)),
					((WorkType) comboBoxWorkType.getSelectedItem()).toString()));
		} else if (comboBoxWorkAddDel.getSelectedIndex() == 2) {
			lblTitle.setText(String.format("REMOVED %d HOURS OF %s", (hoursNumber
					- (datZam.removeTheWorkEffectively((WorkType) comboBoxWorkType.getSelectedItem(), hoursNumber))),
					(((WorkType) comboBoxWorkType.getSelectedItem()).toString())));
		} else {
			lblTitle.setText("NEPOVEDLO SE PØIDAT/ODEBRAT PRÁCI");
			return;
		}
		refresh();
		changePanelCentralMain(panelWork);
	}

	private void onConfirmChangesMaxWorkingHoursAll() {

		txtMaxWorkingHoursAll.setText(txtMaxWorkingHoursAll.getText().trim());
		if ((txtMaxWorkingHoursAll.getText() == null && txtMaxWorkingHoursAll.getText().isEmpty())
				|| (!isInteger(txtMaxWorkingHoursAll.getText()))) {
			return;
		}
		int newMaxWorkingHoursAll = Integer.parseInt(txtMaxWorkingHoursAll.getText());

		boolean success = true;
		for (Employee employee : datZam.getArrayList()) {
			if (employee.setMaxWorkingHours(newMaxWorkingHoursAll)) {
				} else {
					success = false;
				}
		}
		if (success) {
			lblTitle.setText("VŠEM ZAMÌSTNANCÙM SE POVEDLO ZMÌNIT MAXIMÁLNÍ PRACOVNÍ DOBU");
		} else {
			lblTitle.setText("VŠEM ZAMÌSTNANCÙM SE NEPOVEDLO ZMÌNIT MAXIMÁLNÍ PRACOVNÍ DOBU");
		}
		refresh();
		changePanelCentralMain(panelEmployeesList);
	}
	
	private boolean isInteger(String number) {
		try {
			int i = Integer.parseInt(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
