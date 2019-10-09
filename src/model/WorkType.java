package model;

public enum WorkType {

	administration(1, "v�vojov� pr�ce"), 
	documentation(2, "technick� dokumentace"),
	development(3, "administrativn� pr�ce");

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
