package model;

public enum Position {
	assistant(1, "asistent", 150),
	technicalWorker(2, "technick� pracovn�k", 200),
	developer(3, "v�vojov� pracovn�k", 250),
	director(4, "�editel", 350); 
	
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
	
	@Override
	public String toString() {
		return title;
	}
}
