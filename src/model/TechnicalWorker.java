package model;

public class TechnicalWorker extends Employee {

	public TechnicalWorker(int id, String name, String surname) {
		super(id, name, surname, Position.technicalWorker);
	}

	public void iamTechnicalWorker() {
		System.out.println("Iam technical worker.");
	}

}
