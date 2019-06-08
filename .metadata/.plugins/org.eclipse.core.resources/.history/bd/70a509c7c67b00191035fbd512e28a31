package Control;

import Model.GameData;

public class ValidPlace {
	GameData data = GameData.getInstance();
	int [] choseState;
	boolean[] playerMove = new boolean[5];
	
	public boolean checkValidPlace(int state, int num) {
		choseState = data.getChoseState();
		for (int i = 0; i < 5; i++) {
			if (choseState[0] == 0) {
				playerMove[i] = data.findPlayerMove(data.getNsTeamData(choseState[1]), i);
			}
			else if ( choseState[0] == 1) {
				playerMove[i] = data.findPlayerMove(data.getCcsTeamData(choseState[1]), i);
			}
			else {
				playerMove[i] = data.findPlayerMove(data.getSsTeamData(), i);
			}
		}
		if (choseState[0] == 0) {
			if(num>=0 && num<4) {//located at right vertical
				if (num == 0) {
					if(playerMove[0])
						return false;
				}
				else if (num == 1) {
					if(playerMove[0])
						return true;
					else
						return false;
				}
				else if (num == 2) {
					if(playerMove[1])
						return true;
					else
						return false;
				}
				else if (num == 3) {
					if(playerMove[2])
						return true;
					else
						return false;
				}
				else {
					if(playerMove[4])
						return true;
					else
						return false;
				}
			}
			else if() {//located at upper horizontal
				
			}
			else if() {//located at left vertical
				
			}
			else if() {//located at lower horizontal
				
			}
			else if() {//located at right to left diagonal
				
			}
			else if() {//located at left to right diagonal
				
			}
		}
	}
	
}
