package model;

public class Director extends Employee {

	public Director(int id, String name, String surname) {
		super(id, name, surname, Position.director);
	}

	public void iamDirector() {
		System.out.println("Iam director.");
	}
}
