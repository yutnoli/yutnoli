package View;

import java.awt.*;
import View.GetInitData;

public class GameMain{
	
	public static void main(String[] args) {
		GetInitData initGame = new GetInitData();
		MapPrint mainMap = new MapPrint();
		initGame.getDataStart(0, mainMap);
	}
}
