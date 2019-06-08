package Model;

import java.util.ArrayList;
import java.util.Iterator;

class stateData{
	int team;
	int number;
	
	public stateData() {
		this.team = 9;//9 means state empty
		this.number = 0;
	}
}

class playerData{
	int team;
	int number;
	int throwCount;
	ArrayList<Integer> moves = new ArrayList<Integer>();
	/*
	 * 0 = do
	 * 1 = gae 
	 * 2 = geol
	 * 3 = yut
	 * 4 = mo
	 */
	public playerData() {
		this.team = 9;
		this.number = 0;
		this.throwCount = 1;
	}
	
	public boolean findMove(int move) {
		Iterator it = moves.iterator();
		while(it.hasNext()) {
			int val = (int)it.next();
			if (val == move) {
				return true;
			}
		}
		return false;
	}
}

public class GameData {
	private stateData[] normalState = new stateData[24];
	private stateData[] cornerCenterState = new stateData[4];
	private stateData startState = new stateData();
	private int numberOfPlayers;
	private int numberOfStones;
	private playerData[] player; 
	
	public GameData() {
		this.numberOfPlayers = 4;
		this.numberOfStones = 3;
		player = new playerData[this.numberOfPlayers];
		for (int i = 0; i < this.numberOfPlayers; i++) {
			player[i].team = i;
			player[i].number = this.numberOfStones;
		}
	}
	
	public GameData(int numberOfPlayers, int numberOfStones) {
		this.numberOfPlayers = numberOfPlayers;
		this.numberOfStones = numberOfStones;
		player = new playerData[this.numberOfPlayers];
		for (int i = 0; i < this.numberOfPlayers; i++) {
			player[i].team = i;
			player[i].number = this.numberOfStones;
		}
	}
	
//get state data	
	public int getNsTeamData(int num) {
		return normalState[num].team;
	}
	
	public int getNsNumData(int num) {
		return normalState[num].number;
	}
	
	public int getCcsTeamData(int num) {
		return cornerCenterState[num].team;
	}
	
	public int getCcsNumData(int num) {
		return cornerCenterState[num].number;
	}
	
	public int getSsTeamData() {
		return startState.team;
	}

	public int getSsNumData() {
		return startState.number;
	}
//set state data
	public void setNsTeamData(int num, int val) {
		normalState[num].team = val;
	}
	
	public void setNsNumData(int num, int val) {
		normalState[num].number = val;
	}
	
	public void setCcsTeamData(int num, int val) {
		cornerCenterState[num].team = val;
	}
	
	public void setCcsNumData(int num, int val) {
		cornerCenterState[num].number = val;
	}

	public void setSsTeamData(int val) {
		startState.team = val;
	}
	
	public void setSsNumData(int val) {
		startState.number = val;
	}
//get player data	
	public int getPlayerData(int num) {
		return player[num].number;
	}
//set player data
	public void setPlayerData(int num, int val) {
		player[num].number = val;
	}	
}
