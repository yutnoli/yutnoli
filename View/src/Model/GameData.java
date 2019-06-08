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
		Iterator<Integer> it = moves.iterator();
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
	private static GameData gameData;//this variable if for Singleton Pattern
	private stateData[] normalState = new stateData[24];
	private stateData[] cornerCenterState = new stateData[4];
	private stateData startState = new stateData();
	private int numberOfPlayers;
	private int numberOfStones;
	private playerData[] player; 
	private int[] yut = new int[4];//0 means round part, 1 means flat part
	private int turn;
	private int[] stateChose = new int[2];
	private boolean[] validPlace = new boolean[30];
	
	public static GameData getInstance() {//this function returns instance, which already exists
		if(gameData == null) {
			gameData = new GameData();
		}
		return gameData;
	}
//must call this function after make GameData	
	public void initGameData(int numberOfPlayers, int numberOfStones) {
		this.numberOfPlayers = numberOfPlayers;
		this.numberOfStones = numberOfStones;
		this.turn = 0;
		for(int i = 0; i < 4; i++) {
			this.yut[i] = 0;
		}
		player = new playerData[this.numberOfPlayers];//maybe this occurs error.(Check and changed it into dynamic allocation.)
		for (int i = 0; i < this.numberOfPlayers; i++) {
			player[i].team = i;
			player[i].number = this.numberOfStones;
			player[i].throwCount = 1;
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
	public int getPlayerData(int team) {
		return player[team].number;
	}
//set player data
	public void setPlayerData(int team, int val) {
		player[team].number = val;
	}
//get player throwCount
	public int getPlayerThrowCount(int team) {
		return player[team].throwCount;
	}
//set player throwCount
	public void setPlayerThrowCount(int team, int val) {
		player[team].throwCount = val;
	}
//increase player throwCount
	public void incPlayerThrowCount(int team) {
		player[team].throwCount++;
	}
//decrease player throwCount
	public void decPlayerCount(int team) {
		player[team].throwCount--;
	}
//find player move
	public boolean findPlayerMove(int team, int move) {
		return player[team].findMove(move);
	}
//add player move
	public void addPlayerMove(int team, int move) {
		player[team].moves.add(move);
	}
//remove player move
	public boolean removePlayerMove(int team, int move) {
		Iterator<Integer> it = player[team].moves.iterator();
		while(it.hasNext()) {
			int val = (int)it.next();
			if (val == move) {
				it.remove();
				return true;
			}
		}
		return false;
	}
//get yut position	
	public int[] getYutPosition() {
		return yut;
	}
//set yut postion
	public void setYutPosition(int[] newPosition) {
		for (int i = 0; i < 4; i++) {
			 yut[i] = newPosition[i];
		}
	}
//get turn
	public int getTurn() {
		return turn;
	}
//move turn
	public void moveTurn() {
		turn = (turn+1)%numberOfPlayers;
	}
//get chose state
	public int[] getChoseState() {
		return stateChose;//this return reference so you have to fix it later
	}
//set chose state
	public void setChoseState(int state, int num) {
		stateChose[0] = state;
		stateChose[1] = num;
	}
//reset valid place
	public void resetValidPlace() {
		for (int i = 0; i < 30; i++) {
			validPlace[i] = false;
		}
	}
	
//get valid place
	public boolean getValidPlace(int state, int num) {
		if(state == 0) {
			if(num >=0 && num<4) {
				return validPlace[num];
			}
			else if(num>3 && num<8) {
				return validPlace[num + 1];
			}
			else if (num > 7 && num <12) {
				return validPlace[num + 2];
			}
			else if (num > 11 && num < 18) {
				return validPlace[num + 3];
			}
			else if (num > 17 && num < 24) {
				return validPlace[num + 4];
			}
			else
				return false;
		}
		else if(state == 1) {
			if(num == 0)
				return validPlace[4];
			else if(num == 1) 
				return validPlace[9];
			else if (num == 2)
				return validPlace[14];
			else if (num == 3) {
				return validPlace[21];
			}
			else
				return false;
		}
		else if(state == 2) {
			return validPlace[28];
		}
		else if(state == 4) {
			return validPlace[29];
		}
		else
			return false;
	}
//set valid Place with Real State shape mode
	public void setValidPlace(int state, int num) {
		if(state == 0) {
			if(num >=0 && num<4) {
				validPlace[num] = true;
			}
			else if(num>3 && num<8) {
				validPlace[num + 1] = true;
			}
			else if (num > 7 && num <12) {
				validPlace[num + 2] = true;
			}
			else if (num > 11 && num < 18) {
				validPlace[num + 3] = true;
			}
			else if (num > 17 && num < 24) {
				validPlace[num + 4] = true;
			}
		}
		else if(state == 1) {
			if(num == 0)
				validPlace[4] = true;
			else if(num == 1) 
				validPlace[9] = true;
			else if (num == 2)
				validPlace[14] = true;
			else if (num == 3) {
				validPlace[21] = true;
			}
		}
		else if(state == 2) {
			validPlace[28] = true;
		}
		else if(state == 4) {
			validPlace[29] = true;
		}
	}
}
