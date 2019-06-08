package Control;

import Model.GameData;
import java.util.Random;

public class ThrowingYut {
	GameData data = GameData.getInstance();
	int[] yut =  new int[4];
	
	public boolean checkThrowCount(int team) {
		if(0 != data.getPlayerThrowCount(team)) {
			return  true;
		}
		return false;
	}
	
	int checkYutPosition() {
		int count = 0;
		for(int i = 0; i < 4; i++) {
			if(yut[i] == 1) {
				count++;
			}
		}
		if(count == 0) {
			return 4;
		}
		else if(count ==1) {
			return 0;
		}
		else if(count ==2) {
			return 1;
		}
		else if (count ==3) {
			return 2;
		}
		else if (count ==4) {
			return 3;
		}
		return 0;
	}
	
	public void throwRandom(int team) {
		Random random = new Random();
		int rand;
		int yutPosition;
		for(int i = 0; i< 4; i++) {
			rand = random.nextInt(3);
			if(rand == 0) {
				yut[i] = 0;
			}
			else {
				yut[i] = 1;
			}
		}
		data.setYutPosition(yut);
		yutPosition = checkYutPosition();
		data.addPlayerMove(team, yutPosition);
		if(yutPosition == 3 || yutPosition ==4) {
			data.incPlayerThrowCount(team);
		}
		data.decPlayerCount(team);
	}
	
	public void selectedThrow(int team, int selected) {
		int yutPosition;
		/*
		 * 0 = do
		 * 1 = gae 
		 * 2 = geol
		 * 3 = yut
		 * 4 = mo
		 */
		if(selected == 0) {
			yut[0]= 1;
			yut[1] = 0;
			yut[2] = 0;
			yut[3] = 0;
		}
		else if(selected == 1) {
			yut[0]= 1;
			yut[1] = 1;
			yut[2] = 0;
			yut[3] = 0;
		}
		else if(selected == 2) {
			yut[0]= 1;
			yut[1] = 1;
			yut[2] = 1;
			yut[3] = 0;
		}
		else if(selected == 3) {
			yut[0]= 1;
			yut[1] = 1;
			yut[2] = 1;
			yut[3] = 1;
		}
		else if(selected == 4) {
			yut[0]= 0;
			yut[1] = 0;
			yut[2] = 0;
			yut[3] = 0;
		}
		data.setYutPosition(yut);
		yutPosition = checkYutPosition();
		data.addPlayerMove(team, yutPosition);
		if(yutPosition == 3 || yutPosition ==4) {
			data.incPlayerThrowCount(team);
		}
		data.decPlayerCount(team);
	}
}
