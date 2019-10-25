package model;

public enum Position {
	assistant(1, "assistant", 150),
	designer(2, "designer", 200),
	developer(3, "developer", 250),
	director(4, "director", 350); 
	
	// definice
	private final String title;
	public final int positionNumber;
	private int evaluation;

	Position(int positionNumber, String title, int evaluation) {
		this.positionNumber = positionNumber;
		this.title = title;
		this.evaluation = evaluation;
	}
	
	public void setEvaluation(int newEvaluation) {
		this.evaluation = newEvaluation;
	}
	
	public int getEvaluation() {
		return evaluation;
	}
	
	public static Position getPosition(int positionNumber) {
		switch (positionNumber) {
		case 1:
			return Position.assistant;
		case 2:
			return Position.designer;
		case 3:
			return Position.developer;
		case 4:
			return Position.director;
		default:
			return null;
		}
	}
	
	@Override
	public String toString() {
		return title;
	}
}
