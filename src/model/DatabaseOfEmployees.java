package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class DatabaseOfEmployees {

	private int countId = 1;
	private ArrayList<Employee> employees;

	// ukl�d�n� na disk
	String path;
	File fPath;
	File fDatabase;

	// konstruktor - UPRAVIT "throw exception by asi nem�l byt v catchi
	public DatabaseOfEmployees(String databaseName) throws Exception {
		employees = new ArrayList<>();

		// ukl�d�n� na dik
		path = System.getenv("APPDATA") + File.separator + "SpravaFirmy";
		fPath = new File(path);

		// pt�m se jestli directory u� existuje a jestli ne tak ho vytvo��m - pokud se
		// vytvo�en� nepovedlo, vyp�u chybu
		if (!fPath.isDirectory()) {
			if (!fPath.mkdirs()) {
				throw new Exception(String.format("P�i vytv��en� adres��e do�lo k chyb�"));
			}
		}

		// vytvo��m abstraktn� tex��k v dann� slo�ce
		fDatabase = new File(path + File.separator + databaseName + ".csv");
		// pokud tex��k u� existuje - na�tu jej do databaze v programu
		if (fDatabase.exists()) {
			try (BufferedReader br = new BufferedReader(new FileReader(fDatabase))) {
				String csvLine;
				while ((csvLine = br.readLine()) != null) {
					if (!addEmployee(csvLine))
						throw new Exception(String.format("P�i na��t�n� ��dku do�lo k chyb�. %s", csvLine));
				}

			} catch (Exception e) {
				throw new Exception(String.format("P�i na��t�n� datab�ze do�lo k chyb�: %s", e.getMessage()));
			}
			// pokud tex��k neexistuje (prvn� spu�t�n�) - vytvo��m ho
		} else {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(fDatabase))) {
				bw.flush();
			} catch (Exception e) {
				throw new Exception(String.format("P�i vytv��en� datab�ze do�lo k chyb�: %s", e.getMessage()));
			}
		}
	}

	// p�id�n� zam�stnance
	private boolean addEmployee(Employee employee) {
		// taky by �lo napsat if employee instanceof Director
		if ((employee.getPosition() == Position.director) && isDirectorAlready()
				|| findEmployee(employee.getId()) != null) {
			return false;
		}
		employees.add(employee);
		countId++;
		return true;
	}

	public boolean addEmployee(String name, String surname, Position position) {
		return addEmployee(makeEmployee(name, surname, position));
	}

	private boolean addEmployee(String csvLine) {
		String[] values = csvLine.split(";");

		Position position;
		switch (values[4]) {
		case "asistent":
			position = Position.assistant;
			break;
		case "technick� pracovn�k":
			position = Position.technicalWorker;
			break;
		case "v�vojov� pracovn�k":
			position = Position.developer;
			break;
		case "�editel":
			position = Position.director;
			break;
		default:
			return false;
		}

		this.countId = Integer.parseInt(values[0]);
		Employee employee = makeEmployee(values[1], values[2], position);
		employee.setEvaluation(Integer.parseInt(values[5]));
		employee.addWorkOfType(WorkType.administration, Integer.parseInt(values[6]));
		employee.addWorkOfType(WorkType.documentation, Integer.parseInt(values[7]));
		employee.addWorkOfType(WorkType.development, Integer.parseInt(values[8]));

		if (values[3].contentEquals("false")) {
			employee.setIll();
		}
		return addEmployee(employee);
	}

	private Employee makeEmployee(String name, String surname, Position position) {
		switch (position) {
		case director:
			Director director = new Director(countId, name, surname);
			return director;
		case developer:
			Developer developer = new Developer(countId, name, surname);
			return developer;
		case technicalWorker:
			TechnicalWorker technicalWorker = new TechnicalWorker(countId, name, surname);
			return technicalWorker;
		case assistant:
			Assistant assistant = new Assistant(countId, name, surname);
			return assistant;
		default:
			return null;
		}
	}

	public void saveToCSV() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fDatabase))) {
			for (Employee employee : employees) {
				bw.write(employee.toCSV());
				bw.newLine();
			}
			bw.flush();
		} catch (Exception e) {
			System.out.printf("P�i ulo�en� datab�ze do�lo k chyb�: %s", e.getMessage());
		}

	}

// pr�ce s pracovn�mi hodinami
	/**
	 * Efektivn� rozd�l� dan� po�et pr�ce mezi v�echny zam�stnance v datab�zi, aby
	 * pr�ce vy�la co nejlevn�ji. Vr�t�, kolik se nepovedlo rozd�lit.
	 * 
	 * @param workType     Enum typu pr�ce kter� chci nastavit.
	 * @param howManyHours Po�et hodin kter� chci p�idat.
	 * @return kolik se nepovedlo rozd�lit.
	 */
	public int divideTheWorkEffectively(WorkType workType, int howManyHours) {
		int positionNumber = 1;
		while (howManyHours > 0) {
			if (positionNumber > Position.director.positionNumber) {
				return howManyHours;
			}

			for (Employee e : employees) {
				if (e.getPosition().positionNumber == positionNumber && e.canIDoThisWorkType(workType)
						&& howManyHours != 0 && e.isHealthy()) {
					howManyHours = e.addWorkOfType(workType, howManyHours);
				}
			}
			positionNumber++;
		}
		return howManyHours;
	}

	public int removeTheWorkEffectively(WorkType workType, int howManyHours) {
		int positionNumber = Position.director.positionNumber;
		while (howManyHours > 0) {
			if (positionNumber < 1) {
				return howManyHours;
			}
			for (Employee e : employees) {
				if (e.getPosition().positionNumber == positionNumber && e.getHowMuchWorkDoIHave(workType) > 0
						&& howManyHours != 0) {
					howManyHours = e.deleteWorkOfType(workType, howManyHours);
				}
			}
			positionNumber--;
		}
		return howManyHours;
	}

	// v�pisy
	public void listOfEmployeesInCSVById() {
		Collections.sort(employees, Employee.idComparator);
		for (Employee e : employees) {
			System.out.println(e.toCSV());
		}
	}

	public void listOfEmployeesInCSV() {
		for (Employee e : employees) {
			System.out.println(e.toCSV());
		}
	}

	public void listOfEmployeesInCSVBySurname() {
		Collections.sort(employees, Employee.surnameComparator);
		for (Employee e : employees) {
			System.out.println(e.toCSV());
		}
		Collections.sort(employees, Employee.idComparator);
	}

	public void listOfEmployees() {
		for (Employee e : employees) {
			System.out.println(e);
		}
	}

	public void listOfEmployeesBySurname() {
		Collections.sort(employees, Employee.surnameComparator);
		for (Employee z : employees) {
			System.out.println(z);
		}
		Collections.sort(employees, Employee.idComparator);
	}

	public void listOfEmployeesBySurname(Position position) {
		Collections.sort(employees, Employee.surnameComparator);
		for (Employee z : employees) {
			if (z.getPosition() == position) {
				System.out.println(z);
			}
		}
		Collections.sort(employees, Employee.idComparator);
	}

	public void listOfEmployeesBySurnameWithWork() {
		Collections.sort(employees, Employee.surnameComparator);
		for (Employee z : employees) {
			System.out.println(z);
			System.out.println(z.infoWork());
			if (!z.infoWork().contentEquals(""))
				System.out.println();
		}
		Collections.sort(employees, Employee.idComparator);
	}

	public void listOfEmployeesBySurnameWitnWork(Position position) {
		Collections.sort(employees, Employee.surnameComparator);
		for (Employee z : employees) {
			if (z.getPosition() == position) {
				System.out.println(z);
				System.out.println(z.infoWork());
				if (!z.infoWork().contentEquals(""))
					System.out.println();
			}
		}
		Collections.sort(employees, Employee.idComparator);
	}

	public void listOfEmployeesById() {
		Collections.sort(employees, Employee.idComparator);
		for (Employee z : employees) {
			System.out.println(z);
		}
	}

	public void listOfEmployeesById(Position position) {
		Collections.sort(employees, Employee.idComparator);
		for (Employee z : employees) {
			if (z.getPosition() == position) {
				System.out.println(z);
			}
		}
	}

	public void listOfEmployeesByIdWithWork() {
		Collections.sort(employees, Employee.idComparator);
		for (Employee z : employees) {
			System.out.println(z);
			System.out.println(z.infoWork());
			if (!z.infoWork().contentEquals(""))
				System.out.println();
		}
	}

	public void listOfEmployeesByIdWithWork(Position position) {
		Collections.sort(employees, Employee.idComparator);
		for (Employee z : employees) {
			if (z.getPosition() == position) {
				System.out.println(z);
				System.out.println(z.infoWork());
				if (!z.infoWork().contentEquals(""))
					System.out.println();
			}
		}
	}
	
	public String listOfEmployeesByIdToString() {
		Collections.sort(employees, Employee.idComparator);
		String s="";
		for (Employee z : employees) {
			s+=z;
			s+="\n";
		}
		return s;
	}

// ostatn� fce
	public boolean deleteEmployee(int id) {
		Employee z = findEmployee(id);
		if (z == null)
			return false;

		employees.remove(z);

		divideTheWorkEffectively(WorkType.administration, z.getHowMuchWorkDoIHave(WorkType.administration));
		divideTheWorkEffectively(WorkType.documentation, z.getHowMuchWorkDoIHave(WorkType.documentation));
		divideTheWorkEffectively(WorkType.development, z.getHowMuchWorkDoIHave(WorkType.development));

		return true;
	}

	public boolean setEmployeeIll(int id) {
		Employee z = findEmployee(id);
		if (z == null)
			return false;
		z.setIll();
		divideTheWorkEffectively(WorkType.administration, z.getHowMuchWorkDoIHave(WorkType.administration));
		divideTheWorkEffectively(WorkType.documentation, z.getHowMuchWorkDoIHave(WorkType.documentation));
		divideTheWorkEffectively(WorkType.development, z.getHowMuchWorkDoIHave(WorkType.development));
		z.setWithoutWork();
		return true;
	}

	public boolean setEmployeeHealthy(int id) {
		if (findEmployee(id) != null) {
			findEmployee(id).setHealthy();
			return true;
		}
		return false;
	}

	public Employee findEmployee(int id) {
		for (Employee z : employees) {
			if (z.getId() == id) {
				return z;
			}
		}
		return null;
	}

	public boolean isDirectorAlready() {

		for (Employee z : employees) {
			if (z.getPosition() == Position.director) {
				return true;
			}
		}
		return false;
	}

	public int getCosts() {
		int costs = 0;
		for (Employee z : employees) {
			costs += z.getWage();
		}
		return costs;
	}

	public ArrayList<Employee> getArrayList() {
		return employees;
	}

	public boolean setMaxWorkingHours(int id, int maxWorkingHours) {
		Employee e = findEmployee(id);
		if (e == null)
			return false;
		e.setMaxWorkingHours(maxWorkingHours);
		return true;
	}

	public void setMaxWorkingHours(int maxWorkingHours) {
		for (Employee e : employees) {
			e.setMaxWorkingHours(maxWorkingHours);
		}
	}
}