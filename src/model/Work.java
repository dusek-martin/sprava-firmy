package model;

public class Work {

	private int maxWorkingHours = 160;
	private int freeWorkingHours = maxWorkingHours;

	private Position position;
	private int evaluation;
	private int wageWithoutWork = 500;

	// if -1: cant do this type of work
	// if not -1: can do this type of work
	private int howManyAdministrationHours = -1;
	private int howManyDocumentationHours = -1;
	private int howManyDevelopmentHours = -1;

	public Work(Position position) {
		this.position = position;
		this.evaluation = position.getEvaluation();

		switch (position) {
		case director:
			howManyAdministrationHours = 0;
			howManyDocumentationHours = 0;
			howManyDevelopmentHours = 0;
			break;
		case developer:
			howManyDocumentationHours = 0;
			howManyDevelopmentHours = 0;
			break;
		case designer:
			howManyAdministrationHours = 0;
			howManyDocumentationHours = 0;
			break;
		case assistant:
			howManyAdministrationHours = 0;
			break;
		default:
			break;
		}
	}

	/**
	 * Pøidá daný poèet hodin danému typu práce a vrátí, kolik se nepovedlo pøidat.
	 * 
	 * @param workType     Enum typu práce který chci nastavit.
	 * @param howManyHours Poèet hodin které chci pøidat.
	 * @return kolik se nepovedlo pøidat.
	 */
	public int addWorkOfType(WorkType workType, int howManyHours) {

		switch (workType) {
		case administration:
			if (howManyAdministrationHours != -1) {
				if (howManyHours > freeWorkingHours) {
					howManyHours -= freeWorkingHours;
					howManyAdministrationHours += freeWorkingHours;
					freeWorkingHours = 0;
				} else {
					howManyAdministrationHours += howManyHours;
					freeWorkingHours -= howManyHours;
					howManyHours = 0;
				}
			}
			break;
		case documentation:
			if (howManyDocumentationHours != -1) {
				if (howManyHours > freeWorkingHours) {
					howManyHours -= freeWorkingHours;
					howManyDocumentationHours += freeWorkingHours;
					freeWorkingHours = 0;
				} else {
					howManyDocumentationHours += howManyHours;
					freeWorkingHours -= howManyHours;
					howManyHours = 0;
				}
			}
			break;
		case development:
			if (howManyDevelopmentHours != -1) {
				if (howManyHours > freeWorkingHours) {
					howManyHours -= freeWorkingHours;
					howManyDevelopmentHours += freeWorkingHours;
					freeWorkingHours = 0;
				} else {
					howManyDevelopmentHours += howManyHours;
					freeWorkingHours -= howManyHours;
					howManyHours = 0;
				}
			}
			break;
		default:
			return howManyHours;
		}
		return howManyHours;
	}

	/**
	 * Odebere daný poèet hodin danému typu práce a vrátí, kolik se nepovedlo
	 * odebrat.
	 * 
	 * @param workType     Enum typu práce který chci nastavit.
	 * @param howManyHours Poèet hodin které chci odebrat.
	 * @return kolik se nepovedlo oderbat.
	 */
	public int deleteWorkOfType(WorkType workType, int howManyHours) {

		switch (workType) {
		case administration:
			if (howManyAdministrationHours != -1) {
				if (howManyHours > howManyAdministrationHours) {
					freeWorkingHours += howManyAdministrationHours;
					howManyHours -= howManyAdministrationHours;
					howManyAdministrationHours = 0;
				} else {
					howManyAdministrationHours -= howManyHours;
					freeWorkingHours += howManyHours;
					howManyHours = 0;
				}
			}
			break;
		case documentation:
			if (howManyDocumentationHours != -1) {
				if (howManyHours > howManyDocumentationHours) {
					freeWorkingHours += howManyDocumentationHours;
					howManyHours -= howManyDocumentationHours;
					howManyDocumentationHours = 0;
				} else {
					howManyDocumentationHours -= howManyHours;
					freeWorkingHours += howManyHours;
					howManyHours = 0;
				}
			}
			break;
		case development:
			if (howManyDevelopmentHours != -1) {
				if (howManyHours > howManyDevelopmentHours) {
					freeWorkingHours += howManyDevelopmentHours;
					howManyHours -= howManyDevelopmentHours;
					howManyDevelopmentHours = 0;
				} else {
					howManyDevelopmentHours -= howManyHours;
					freeWorkingHours += howManyHours;
					howManyHours = 0;
				}
			}
			break;
		default:
			return howManyHours;
		}
		return howManyHours;

	}

	public boolean canIDoThisWorkType(WorkType workType) {
		switch (workType) {
		case administration:
			if (howManyAdministrationHours != -1) {
				return true;
			}
			break;
		case documentation:
			if (howManyDocumentationHours != -1) {
				return true;
			}
			break;
		case development:
			if (howManyDevelopmentHours != -1) {
				return true;
			}
			break;
		default:
			return false;
		}
		return false;
	}

	public int getFreeWorkingHours() {
		return freeWorkingHours;
	}

	public int getFreeWorkingHours(WorkType workType) {
		if (canIDoThisWorkType(workType)) {
			return freeWorkingHours;
		}
		return 0;
	}

	public int getMaxWorkingHours() {
		return maxWorkingHours;
	}

	public boolean setMaxWorkingHours(int maxWorkingHours) {
		if (maxWorkingHours >= getHowMuchWorkDoIHave()) {
			freeWorkingHours += maxWorkingHours - this.maxWorkingHours;
			this.maxWorkingHours = maxWorkingHours;
			return true;
		} else {
			return false;
		}
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public void setWithoutWork() {
		deleteWorkOfType(WorkType.administration, maxWorkingHours);
		deleteWorkOfType(WorkType.documentation, maxWorkingHours);
		deleteWorkOfType(WorkType.development, maxWorkingHours);
		freeWorkingHours = maxWorkingHours;
	}

	public int getHowMuchWorkDoIHave() {
		return maxWorkingHours - freeWorkingHours;
	}

	public int getHowMuchWorkDoIHave(WorkType typeOfWork) {
		switch (typeOfWork) {
		case administration:
			return howManyAdministrationHours;
		case documentation:
			return howManyDocumentationHours;
		case development:
			return howManyDevelopmentHours;
		default:
			return 0;
		}
	}

	public int getWage() {
		if (freeWorkingHours == maxWorkingHours)
			return wageWithoutWork;
		return getHowMuchWorkDoIHave() * evaluation;
	}

	public Position getPosition() {
		return position;
	}

	/**
	 * Zmìní pozici na tu v argumentu, vynuluje všechnu práci co zde byla.
	 * 
	 * @param position Enum pozice kterou chci nastavit.
	 * @return true, pokud se to povedlo, false, pokud ne.
	 */
	public boolean setPosition(Position position) {
		switch (position) {
		case assistant:
			howManyAdministrationHours = 0;
			howManyDocumentationHours = -1;
			howManyDevelopmentHours = -1;
			break;
		case designer:
			howManyAdministrationHours = 0;
			howManyDocumentationHours = 0;
			howManyDevelopmentHours = -1;
			break;
		case developer:
			howManyAdministrationHours = -1;
			howManyDocumentationHours = 0;
			howManyDevelopmentHours = 0;
			break;
		case director:
			howManyAdministrationHours = 0;
			howManyDocumentationHours = 0;
			howManyDevelopmentHours = 0;
			break;
		default:
			return false;
		}
		this.position = position;
		return true;
	}

	public String getPositionTitle() {
		return position.toString();
	}

	public int getPositionNumber() {
		return position.positionNumber;
	}

	public String infoWork() {
		String s = "";
		if (howManyAdministrationHours != -1) {
			s += String.format("\n%d hodin administrativy", howManyAdministrationHours);
		}
		if (howManyDocumentationHours != -1) {
			s += String.format("\n%d hodin dokumentace", howManyDocumentationHours);
		}
		if (howManyDevelopmentHours != -1) {
			s += String.format("\n%d hodin vývoje", howManyDevelopmentHours);
		}
		if (!s.contentEquals(""))
			s = "Mám na práci:" + s;
		return s;
	}
	
	/**
	 * Vrátí poèet hodin jednotlivých prací. Pokud nevykonávám danný typ práce, vrátí -1.
	 * 
	 * @return pole, index[0] administrativa, index[1] dokumentace, index[2] vývoj
	 */
	public int[] getWorkTypeHours() {
		int[] howMuchWorkDoIHave = {howManyAdministrationHours,howManyDocumentationHours,howManyDevelopmentHours};
		return howMuchWorkDoIHave;
	}

	public String workToCSV() {
		return position + ";" + getEvaluation() + ";" + getMaxWorkingHours() + ";" + String.valueOf(howManyAdministrationHours) + ";"
				+ String.valueOf(howManyDocumentationHours) + ";" + String.valueOf(howManyDevelopmentHours);
	}

}
