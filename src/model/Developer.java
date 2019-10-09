package model;

public class Developer extends Employee {

	public Developer(int id, String name, String surname) {
		super(id, name, surname, Position.developer);
	}

	public void imDeveloper() {
		System.out.println("Iam developer.");
	}

}
