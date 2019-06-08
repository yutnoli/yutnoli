package Control;

import Model.GameData;
import Control.ThrowingYut;

public class ControlMain {
	GameData data = GameData.getInstance();
	ThrowingYut throwYut = new ThrowingYut();
	ValidPlace validPlaceControl = new ValidPlace();
	boolean clicked = false;
	boolean buttonFlowThrow = true;//this makes ignoring other wrong clicks.
	boolean buttonFlowState = false;

	
//if other button added overload right below function	
	public void recieveAction(int state, int num) {//receive state button action
		int teamCheck = 9;
		if(buttonFlowState) {
			if(!clicked) {//first click
				if (state == 0) {//normal state
					if(data.getNsTeamData(num) == data.getTurn()) {
						data.setChoseState(0,num);
						clicked = true;
					}
				}
				else if(state == 1) {//cornerCenterState
					if(data.getCcsTeamData(num) == data.getTurn()) {
						data.setChoseState(1, num);
						clicked = true;
					}
				}
				else if(state == 2) {//startState
					if(data.getSsTeamData() == data.getTurn()) {
						data.setChoseState(2, num);
						clicked = true;
					}
				}
				else if(state == 3) {//newStone state //num means team
					if(num == data.getTurn()) {
						if(data.getPlayerData(num) != 0) {
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
					if(state == 0) {
						teamCheck = data.getNsTeamData(num);
						//TODO
					}
					else if(state == 1) {
						
					}
					else if(state == 2) {
						
					}
					else if(state == 4) {
						
					}
				}
				
			}
		}
	}
	
	public void recieveAction(int throwOption) {//receive throw button action
		
	}
}
