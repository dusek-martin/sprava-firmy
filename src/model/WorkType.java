package model;

public enum WorkType {

	administration(1, "vývojové práce"), 
	documentation(2, "technická dokumentace"),
	development(3, "administrativní práce");

	// definice

	public final int workNumber;
	private final String title;

	WorkType(int workNumber, String title) {
		this.workNumber = workNumber;
		this.title = title;
	}

	@Override
	public String toString() {
		return title;
	}
}
