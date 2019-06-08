package Control;

import Model.GameData;

public class ValidPlace {
	GameData data = GameData.getInstance();
	int [] choseState;
	boolean[] playerMove = new boolean[5];
	
	void setValidPlaceMap(int state, int num) {
		choseState[0] = data.getChoseStateST();
		choseState[1] = data.getChoseStateNU();
		for(int i = 0;i < 5; i++) {
			playerMove[i] = false;
		}
		for (int i = 0; i < 5; i++) {//get player's move data
			for (int j = 0; j < 3; j++) {
				if(data.findPlayerMove(data.getTeamData(j, choseState[1]), i))
				playerMove[i] = true;
			}
		}
		//check chose state
		if(playerMove[0]) {
			//player has Do move
			if(choseState[0] == 0) {//chose state is normal state
				if (choseState[1] != 3 && choseState[1] != 7 && choseState[1] != 11 && choseState[1] != 15 && choseState[1] != 17 && choseState[1] != 19 && choseState[1] != 21 && choseState[1] != 23)
					data.setValidPlace(0, choseState[1] + 1);
				else if(choseState[1] == 3)
					data.setValidPlace(1, 0);
				else if(choseState[1] == 7)
					data.setValidPlace(1, 1);
				else if(choseState[1] == 11 || choseState[1] == 19)
					data.setValidPlace(1, 2);
				else if(choseState[1] == 15 || choseState[1] == 23)
					data.setValidPlace(2, 0);
				else if(choseState[1] == 17 || choseState[1] == 21)
					data.setValidPlace(1, 3);
			}
			else if(choseState[0] == 1) {
				if(choseState[1] == 0) 
					data.setValidPlace(0, 16);
				else if(choseState[1] == 1) 
					data.setValidPlace(0, 20);
				else if(choseState[1] == 2) 
					data.setValidPlace(0, 12);
				else if(choseState[1] == 3) 
					data.setValidPlace(0, 22);
			}
			else if(choseState[0] == 2) {
				data.setValidPlace(4, 0);
			}
			else if(choseState[0] == 3) {
				data.setValidPlace(0, 0);
			}
		}
		if(playerMove[1]) {
			//player has Gae move
			if(choseState[0] == 0) {
				if(choseState[1] == 0 || choseState[1] == 1 || choseState[1] == 4 || choseState[1] == 5 || choseState[1] == 8 || choseState[1] == 9 || choseState[1] == 12 || choseState[1] == 13)
					data.setValidPlace(0, choseState[1] + 2);
				else if(choseState[1] == 3 || choseState[1] == 7 || choseState[1] == 11 || choseState[1] == 17 || choseState[1] == 19 || choseState[1] == 21)
					data.setValidPlace(0, choseState[1] + 1);
				else if(choseState[1] == 2)
					data.setValidPlace(1, 0);
				else if(choseState[1] == 6)
					data.setValidPlace(1, 1);
				else if(choseState[1] == 10 || choseState[1] == 18)
					data.setValidPlace(1, 2);
				else if(choseState[1] == 14 || choseState[1] == 22)
					data.setValidPlace(2, 0);
				else if(choseState[1] == 15 || choseState[1] == 23) {
					data.setValidPlace(4, 0);
				}
			}
			else if(choseState[0] == 1) {
				if(choseState[1] == 0)
					data.setValidPlace(0, 17);
				if(choseState[1] == 1)
					data.setValidPlace(0, 21);
				if(choseState[1] == 2)
					data.setValidPlace(0, 13);
				if(choseState[1] == 3)
					data.setValidPlace(0, 23);
			}
			else if(choseState[0] == 2) {
				data.setValidPlace(4, 0);
			}
			else if(choseState[0] == 3) {
				data.setValidPlace(0, 1);
			}
		}
		if(playerMove[2]) {
			//player has Geol move
			if(choseState[0] == 0) {
				if(choseState[1] == 0 || choseState[1] == 4 || choseState[1] == 8 || choseState[1] == 12)
					data.setValidPlace(0, choseState[1] + 3);
				else if (choseState[1] == 2 || choseState[1] == 3 || choseState[1] == 6 || choseState[1] == 7 || choseState[1] == 10 || choseState[1] == 11 || choseState[1] == 16 || choseState[1] == 17 || choseState[1] == 20 || choseState[1] == 21)
					data.setValidPlace(0, choseState[1] + 2);
				else if(choseState[1] == 1)
					data.setValidPlace(1, 0);
				else if(choseState[1] == 5)
					data.setValidPlace(1, 1);
				else if(choseState[1] == 9)
					data.setValidPlace(1, 2);
				else if(choseState[1] == 13)
					data.setValidPlace(2, 0);
				else if(choseState[1] == 18 || choseState[1] == 19)
					data.setValidPlace(0, choseState[1] - 6);
				else if(choseState[1] == 14 || choseState[1] == 15 || choseState[1] == 22 || choseState[1] == 23) {
					data.setValidPlace(4, 0);
				}
			}
			else if(choseState[0] == 1) {
				if(choseState[1] == 0)
					data.setValidPlace(1, 3);
				if(choseState[1] == 1)
					data.setValidPlace(1, 3);
				if(choseState[1] == 2)
					data.setValidPlace(0, 14);
				if(choseState[1] == 3)
					data.setValidPlace(2, 0);
			}
			else if(choseState[0] == 2) {
				data.setValidPlace(4, 0);
			}
			else if(choseState[0] == 3) {
				data.setValidPlace(0, 2);
			}
		}
		if(playerMove[3]) {
			//player has Yut move
			if(choseState[0] == 0) {
				if(choseState[1] == 1 || choseState[1] == 2 || choseState[1] == 3 || choseState[1] == 5 || choseState[1] == 6 || choseState[1] == 7 || choseState[1] == 9 || choseState[1] == 10 || choseState[1] == 11 || choseState[1] == 16 || choseState[1] == 20)
					data.setValidPlace(0, choseState[1] + 3);
				else if (choseState[1] == 0)
					data.setValidPlace(1, 0);
				else if(choseState[1] == 4)
					data.setValidPlace(1, 1);
				else if(choseState[1] == 8 || choseState[1] == 17)
					data.setValidPlace(1, 2);
				else if(choseState[1] == 18 || choseState[1] == 19)
					data.setValidPlace(0, choseState[1] - 5);
				else if(choseState[1] == 21 || choseState[1] == 12)
					data.setValidPlace(2, 0);
				else if(choseState[1] == 13 || choseState[1] == 14 || choseState[1] == 15 || choseState[1] == 22 || choseState[1] == 23)
					data.setValidPlace(4, 0);
			}
			else if(choseState[0] == 1) {
				if(choseState[1] == 0)
					data.setValidPlace(0, 18);
				if(choseState[1] == 1)
					data.setValidPlace(0, 22);
				if(choseState[1] == 2)
					data.setValidPlace(0, 15);
				if(choseState[1] == 3)
					data.setValidPlace(4, 0);
			}
			else if(choseState[0] == 2) {
				data.setValidPlace(4, 0);
			}
			else if(choseState[0] == 3) {
				data.setValidPlace(0, 3);
			}
		}
		if(playerMove[4]) {
			//player ha Mo move
			if(choseState[0] == 0) {
				if(choseState[1] >= 0 && choseState[1] <12)
					data.setValidPlace(0, choseState[1] + 4);
				else if (choseState[1] == 17)
					data.setValidPlace(0, 12);
				else if(choseState[1] == 18 || choseState[1] == 19)
					data.setValidPlace(0, choseState[1] - 4);
				else if(choseState[1] == 16)
					data.setValidPlace(1, 2);
				else if(choseState[1] == 20)
					data.setValidPlace(2, 0);
				else if(choseState[1] == 12 || choseState[1] == 13 || choseState[1] == 14 || choseState[1] == 15 || choseState[1] == 21 || choseState[1] == 22 || choseState[1] == 23)
					data.setValidPlace(4, 0);
			}
			else if(choseState[0] == 1) {
				if(choseState[1] == 0)
					data.setValidPlace(0, 19);
				if(choseState[1] == 1)
					data.setValidPlace(0, 23);
				if(choseState[1] == 2)
					data.setValidPlace(2, 0);
				if(choseState[1] == 3)
					data.setValidPlace(4, 0);
			}
			else if(choseState[0] == 2) {
				data.setValidPlace(4, 0);
			}
			else if(choseState[0] == 3) {
				data.setValidPlace(1, 0);
			}
		}
	}
	
	public boolean checkValidPlace(int state, int num) {
		setValidPlaceMap(state, num);
		return data.getValidPlace(state, num);
	}
}
