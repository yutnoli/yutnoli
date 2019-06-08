package Model;

public class StateData{
	int team;
	int number;
	
	public StateData() {
		this.team = 9;//9 means state empty
		this.number = 0;
	}
	
	/* To get TEAM member variable of this object. */
	public int getTeam() {
		return team;
	}
	
	/* To get NUMBER member variable of this object. */
	public int getNumber() {
		return number;
	}
}