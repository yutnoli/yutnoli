package Control;

import Model.GameData;
import Control.ThrowingYut;

public class ControlMain {
	GameData data = GameData.getInstance();
	ThrowingYut throwYut = new ThrowingYut();
	boolean clicked = false;
	boolean buttonFlowThrow = true;//this makes ignoring other wrong clicks.
	boolean buttonFlowState = false;

	
//if other button added overload right below function	
	public void recieveAction(int state, int num) {//receive state button action
		if(buttonFlowState) {
			if(!clicked) {
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
			}
			else if(clicked) {
				
			}
		}
	}
	
	public void recieveAction(int throwOption) {//receive throw button action
		
	}
}