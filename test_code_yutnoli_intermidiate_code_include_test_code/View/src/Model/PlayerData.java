package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayerData{
	
	int team;
	int number;
	int throwCount;
	int finish;
	ArrayList<Integer> moves = new ArrayList<Integer>();
	
	/*
	 * 0 = do
	 * 1 = gae 
	 * 2 = geol
	 * 3 = yut
	 * 4 = mo
	 */
	
	public PlayerData() {
		this.team = 1;
		this.number = 0;
		this.throwCount = 1;
		this.finish = 0;
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
	
	/* To get TEAM member variable of this object. */
	public int getTeam() {
		return team;
	}
	
	/* To get NUMBER member variable of this object. */
	public int getNumber() {
		return number;
	}
	
	/* To get THORWCOUNT member variable of this object. */
	public int getThrowCount() {
		return throwCount;
	}
	
	/* To get FINISH member variable of this object. */
	public int getFinish() {
		return finish;
	}
	
	/* To get MOVES member variable of this object. */
	public ArrayList<Integer> getMoves() {
		return moves;
	}
	
//	/* method for unit-test in TestStateData.java */
//	public boolean verifyMemberVariable() {
//		try {
//			member
//		}
//	}
}