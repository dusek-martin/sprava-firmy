package model;

import java.util.Comparator;

public class Employee extends Work {

	private final int id; // Je k nìèemu dávat private a zároveò final?
	private String name;
	private String surname;
	private boolean health;

	public Employee(int id, String name, String surname, Position position) {
		super(position);
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.health = true;
	}

	@Override
	public String toString() {
		String health;
		if (isHealthy())
			health = "healthy";
		else
			health = "ill";
		return "ID: " + id + ", " + name + " " + surname + ", " + getPositionTitle() + ", " + health + ", wage: " + super.getWage() + ", evaluation: " + super.getEvaluation() + " Kè/h, max number of working hours: " + super.getMaxWorkingHours();
	}

	public String toCSV() {
		return id + ";" + name + ";" + surname + ";" + health + ";" + super.workToCSV();
	}

	// informace o osobì
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public boolean isHealthy() {
		return health;
	}

	public void setIll() {
		health = false;
	}

	public void setHealthy() {
		health = true;
	}

// øazení 
	public static Comparator<Employee> idComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee z1, Employee z2) {
			return (z2.getId() > z1.getId() ? -1 : (z2.getId() == z1.getId() ? 0 : 1));
		}
	};

	public static Comparator<Employee> surnameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee z1, Employee z2) {
			return (int) (z1.getSurname().compareTo(z2.getSurname()));
		}
	};
}
