package Control;

import Model.GameData;
import Control.ThrowingYut;

public class ControlMain {
	GameData data = GameData.getInstance();
	DeleteMove delete = new DeleteMove();
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
		System.out.println("function stateAction");
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
						System.out.println("state == 3 if statement inside, first if");
						if(data.getPlayerNum(num) != 0) {
							System.out.println("state == 3 if statement inside, second if");
							data.setChoseState(3, num);
							clicked = true;
						}
						else;//do nothing
					}
				}
				else;//do nothing
			}
			else if(clicked) {//second click
				if(choseState[0] == state && choseState[1] == num) {
					clicked = false;
				}
				else {
					if(validPlaceControl.checkValidPlace(state, num)) {//check clicked state is valid to move
						if(state >= 0 && state < 3) {
							if(data.getTeamData(state, num) == turn) {
								numCount = data.getNumData(state, num);
								numCount += data.getNumData(choseState[0], choseState[1]);
								data.setStateData(state, num, turn, numCount);
								if(choseState[0] == 3) {
									data.setPlayerNum(choseState[1], data.getPlayerNum(choseState[1])-1);
									data.setTeamDataChanged(choseState[1]);
									data.setStateChanged(state, num);
									delete.deletUsedMove(state, num);
									clicked = false;
								}
								else {
									data.setStateData(choseState[0], choseState[1], 9, 0);
									data.setStateChanged(choseState[0], choseState[1]);
									data.setStateChanged(state, num);
									delete.deletUsedMove(state, num);
									clicked = false;
								}
							}
							else if(data.getTeamData(state, num) == 0) {
								data.incPlayerThrowCount(turn);
								numCount = data.getNumData(state, num);
								data.setPlayerNum(0, data.getPlayerNum(0) + numCount);
								data.setTeamDataChanged(0);
								data.setStateData(state, num, data.getTeamData(choseState[0], choseState[1]), data.getNumData(choseState[0], choseState[1]));
								data.setStateChanged(state, num);
								if(choseState[0] == 3) {
									data.setPlayerNum(choseState[1], data.getPlayerNum(choseState[1])-1);
									data.setTeamDataChanged(choseState[1]);
									delete.deletUsedMove(state, num);
									clicked = false;
								}
								else {
									data.setStateData(choseState[0], choseState[1], 9, 0);
									data.setStateChanged(choseState[0], choseState[1]);
									delete.deletUsedMove(state, num);
									clicked = false;
								}
							}
							else if(data.getTeamData(state, num) == 1) {
								data.incPlayerThrowCount(turn);
								numCount = data.getNumData(state, num);
								data.setPlayerNum(1, data.getPlayerNum(1) + numCount);
								data.setTeamDataChanged(1);
								data.setStateData(state, num, data.getTeamData(choseState[0], choseState[1]), data.getNumData(choseState[0], choseState[1]));
								data.setStateChanged(state, num);
								if(choseState[0] == 3) {
									data.setPlayerNum(choseState[1], data.getPlayerNum(choseState[1])-1);
									data.setTeamDataChanged(choseState[1]);
									delete.deletUsedMove(state, num);
									clicked = false;
								}
								else {
									data.setStateData(choseState[0], choseState[1], 9, 0);
									data.setStateChanged(choseState[0], choseState[1]);
									delete.deletUsedMove(state, num);
									clicked = false;
								}
							}
							else if(data.getTeamData(state, num) == 2) {
								data.incPlayerThrowCount(turn);
								numCount = data.getNumData(state, num);
								data.setPlayerNum(2, data.getPlayerNum(2) + numCount);
								data.setTeamDataChanged(2);
								data.setStateData(state, num, data.getTeamData(choseState[0], choseState[1]), data.getNumData(choseState[0], choseState[1]));
								data.setStateChanged(state, num);
								if(choseState[0] == 3) {
									data.setPlayerNum(choseState[1], data.getPlayerNum(choseState[1])-1);
									data.setTeamDataChanged(choseState[1]);
									delete.deletUsedMove(state, num);
									clicked = false;
								}
								else {
									data.setStateData(choseState[0], choseState[1], 9, 0);
									data.setStateChanged(choseState[0], choseState[1]);
									delete.deletUsedMove(state, num);
									clicked = false;
								}
							}
							else if(data.getTeamData(state, num) == 3) {
								data.incPlayerThrowCount(turn);
								numCount = data.getNumData(state, num);
								data.setPlayerNum(3, data.getPlayerNum(3) + numCount);
								data.setTeamDataChanged(3);
								data.setStateData(state, num, data.getTeamData(choseState[0], choseState[1]), data.getNumData(choseState[0], choseState[1]));
								data.setStateChanged(state, num);
								if(choseState[0] == 3) {
									data.setPlayerNum(choseState[1], data.getPlayerNum(choseState[1])-1);
									data.setTeamDataChanged(choseState[1]);
									delete.deletUsedMove(state, num);
									clicked = false;
								}
								else {
									data.setStateData(choseState[0], choseState[1], 9, 0);
									data.setStateChanged(choseState[0], choseState[1]);
									delete.deletUsedMove(state, num);
									clicked = false;
								}
							}
							else {
								System.out.println("Control Main, choseState[0]: " + choseState[0]);
								System.out.println("Control Main, choseState[1]: " + choseState[1]);
								System.out.println("Control Main, data.getTeamData: " + data.getTeamData(choseState[0], choseState[1]));
								data.setStateData(state, num, data.getTeamData(choseState[0], choseState[1]), data.getNumData(choseState[0], choseState[1]));
								data.setStateChanged(state, num);
								if(choseState[0] == 3) {
									data.setPlayerNum(choseState[1], data.getPlayerNum(choseState[1])-1);
									data.setTeamDataChanged(choseState[1]);
									delete.deletUsedMove(state, num);
									clicked = false;
								}
								else {
									data.setStateData(choseState[0], choseState[1], 9, 0);
									data.setStateChanged(choseState[0], choseState[1]);
									delete.deletUsedMove(state, num);
									clicked = false;
								}
							}
						}
						else if(state == 4) {
							data.setFinishable(true);
						}
					}
					else {
						if(data.getTeamData(state, num) == data.getTurn()) {
							data.setChoseState(state, num);
						}
						else {
							clicked = false;
						}
					}
				}
			}
		}
	}
	
	public void finishStone() {
		int numCount = 0;
		int[] choseState = new int[2];
		int endCheck = 9;
		choseState[0] = data.getChoseStateST();
		choseState[1] = data.getChoseStateNU();
		numCount = data.getFinishedStones(turn);
		numCount += data.getNumData(choseState[0], choseState[1]);
		data.setFinishedStones(turn, numCount);
		data.setStateData(choseState[0], choseState[1], 9, 0);
		data.setStateChanged(choseState[0], choseState[1]);
		data.setFinishable(false);
		
		endCheck = checkGameEnd();
		if(endCheck != 9) {
			data.setEndCheck(endCheck);
		}
		
		if(data.getPlayerThrowCount(turn) == 0 && data.checkMoveEmpty(turn)) {
			data.incPlayerThrowCount(data.getTurn());
			data.moveTurn();
		}
		clicked = false;
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
		System.out.println("function recieveStateAction");
		mainFlow(1);
		return checkGameEnd();
	}
	
	public void recieveThrowAction() {
		this.throwOption = 0;
		mainFlow(0);
	}
	
	public void recieveThrowAction(int selected) {
		this.throwOption = 1;
		this.selected = selected;
		mainFlow(0);
	}
	
	void mainFlow(int recieveAction) {//recieveAction '0' means throw action, '1' means state action.
		turn = data.getTurn();
		if(recieveAction == 0) {
			if(data.getPlayerThrowCount(turn)>0) {
				_throwYut();
				System.out.println("Right after Throw Yut!!!!!!!!!!!");
				if(data.checkMoveEmpty(turn))
					data.moveTurn();
			}
		}
		else if(recieveAction == 1) {
			System.out.println("function mainFlow");
			stateAction();
			if(data.getPlayerThrowCount(turn) == 0 && data.checkMoveEmpty(turn)) {
				data.incPlayerThrowCount(data.getTurn());
				data.moveTurn();
			}
		}
		System.out.println("turn : " + data.getTurn());
	}
}
