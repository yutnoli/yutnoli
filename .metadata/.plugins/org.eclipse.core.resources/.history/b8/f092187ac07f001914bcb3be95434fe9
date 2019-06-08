package Control;

import Model.GameData;
import Control.ThrowingYut;

public class ControlMain {
	GameData data = GameData.getInstance();
	ThrowingYut throwYut = new ThrowingYut();
	ValidPlace validPlaceControl = new ValidPlace();
	boolean clicked = false;
	int turn = 0;
	int state;
	int num;
	int throwOption;
	int selected;

//if other button added overload right below function	
	void stateAction() {//receive state button action
		int numCount = 0;//# of stones in selected state
		int[] choseState = new int[2];
		choseState[0] = data.getChoseStateST();
		choseState[1] = data.getChoseStateNU();
		if(!data.checkMoveEmpty(turn)) {
			if(!clicked) {//first click
				if (state >= 0 && state < 3) {//normal state
					if(data.getTeamData(state, num) == turn) {
						data.setChoseState(state, num);
						clicked = true;
					}
				}
				else if(state == 3) {//newStone state //num means team
					if(num == turn) {
						if(data.getPlayerNum(num) != 0) {
							data.setChoseState(3, num);
							clicked = true;
						}
						else;//do nothing
					}
				}
				else;//do nothing
			}
			else if(clicked) {//second click
				if(validPlaceControl.checkValidPlace(state, num)) {//check clicked state is valid to move
					if(state >= 0 && state < 3) {
						if(data.getTeamData(state, num) == turn) {
							numCount = data.getNumData(state, num);
							numCount += data.getNumData(choseState[0], choseState[1]);
							data.setStateData(state, num, turn, numCount);
							data.setStateData(choseState[0], choseState[1], 9, 0);
							clicked = false;
						}
					}
					else if(state == 4) {
						numCount = data.getFinishedStones(turn);
						numCount += data.getNumData(choseState[0], choseState[1]);
						data.setFinishedStones(turn, numCount);
						data.setStateData(choseState[0], choseState[1], 9, 0);
						clicked = false;
					}
				}
			}
		}
	}
	
	void _throwYut() {//receive throw button action
		//throwOption '0' means random, '1' means selected.
		if(throwOption == 0) 
			throwYut.randomThrow(turn);
		
		else if(throwOption == 1)
			throwYut.selectedThrow(turn, selected);
	}
	
	int checkGameEnd() {//If return is 9 then game is not ended, another number is the number of winner team.
		int numOfPlayers = data.getNumOfPlayers();
		for(int i = 0; i < numOfPlayers; i++ ) {
			if(data.getPlayerNum(i) == 0)
				return i;
		}
		return 9;
	}
	
	public int recieveStateAction(int state, int num) {
		this.state = state;
		this.num = num;
		mainFlow(1);
		return checkGameEnd();
	}
	
	public void recieveThrowAction(int option) {
		this.throwOption = option;
		mainFlow(0);
	}
	
	public void recieveThrowAction(int option, int selected) {
		this.throwOption = option;
		this.selected = selected;
		mainFlow(0);
	}
	
	void mainFlow(int recieveAction) {//recieveAction '0' means throw action, '1' means state action.
		//In this function there should be included moveTurn function.
		turn = data.getTurn();
		if(recieveAction == 0) {
			if(data.getPlayerThrowCount(turn)>0) {
				_throwYut();
			}
		}
		else if(recieveAction == 1) {
			stateAction();
			if(data.getPlayerThrowCount(turn) == 0 && data.checkMoveEmpty(turn)) {
				//make game end algorithm at here checking by checkEnd
				data.moveTurn();
			}
		}
	}
}
