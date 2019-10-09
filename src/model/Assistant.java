package model;

public class Assistant extends Employee {

	public Assistant(int id, String name, String surname) {
		super(id, name, surname, Position.assistant);
	}

	public void iamAssistant() {
		System.out.println("Iam  assistant.");
	}

}
