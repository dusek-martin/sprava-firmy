package model;

public enum WorkType {

	administration(1, "administration"), documentation(2, "documentation"),
	development(3, "development");

	// definice

	public final int workNumber;
	private final String title;

	WorkType(int workNumber, String title) {
		this.workNumber = workNumber;
		this.title = title;
	}

	public static WorkType getWorkType(int workNumber) {
		switch (workNumber) {
		case 1:
			return WorkType.administration;
		case 2:
			return WorkType.documentation;
		case 3:
			return WorkType.development;
		default:
			return null;
		}
	}

	@Override
	public String toString() {
		return title;
	}
}
