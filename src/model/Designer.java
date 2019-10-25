package model;

public class Designer extends Employee {

	public Designer(int id, String name, String surname) {
		super(id, name, surname, Position.designer);
	}

	public void iamTechnicalWorker() {
		System.out.println("Iam technical worker.");
	}

}
