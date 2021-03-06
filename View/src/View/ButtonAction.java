package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Control.ControlMain;
import Model.GameData;

public class ButtonAction implements ActionListener{
	JButton[] normalState;
	JButton[] cornerCenterState;
	JButton[] playerInfo;
	JButton startState;
	JButton endStone;
	JButton throwYutRandom;
	JButton throwYutSelect;
	MapPrint mapPrint;
	ControlMain controler = new ControlMain();
	GameData data = GameData.getInstance();
	GetPosition getPos = new GetPosition();
	GetEndMove endMove = new GetEndMove();
	
	public ButtonAction(MapPrint mapPrint, JButton[] normalState, JButton[] cornerCenterState, JButton startState, JButton[] playerInfo, JButton endStone, JButton throwYutRandom, JButton throwYutSelect){
		this.mapPrint = mapPrint;
		this.normalState = normalState;
		this.cornerCenterState = cornerCenterState;
		this.startState = startState;
		this.playerInfo = playerInfo;
		this.endStone = endStone;
		this.throwYutRandom = throwYutRandom;
		this.throwYutSelect = throwYutSelect;
		getPos.initPositionFrame(controler, mapPrint);
		endMove.initPositionFrame(controler, mapPrint);
	}
	
	public void actionPerformed(ActionEvent e) {
		boolean find = false;
		
		for(int i = 0; !find && i < 24; i++) {
			if(e.getSource().equals(normalState[i])) {
				System.out.println("normalState " + i + "번 버튼이 눌렸습니다!!");
				controler.recieveStateAction(0, i);
				mapPrint.playerDataImageChange();
				mapPrint.turnChanged();
				data.resetChangedData();
				find = true;
			}
		}
		
		for(int i = 0; !find && i < 4; i++) {
			if(e.getSource().equals(cornerCenterState[i])) {
				System.out.println("cornerCenterState " + i + "번 버튼이 눌렸습니다!!");
				controler.recieveStateAction(1, i);
				mapPrint.playerDataImageChange();
				mapPrint.turnChanged();
				data.resetChangedData();
				find = true;
			}
		}

		for(int i = 0; !find && i < 4; i++) {
			if(e.getSource().equals(playerInfo[i])) {
				System.out.println("player " + i + "번 버튼이 눌렸습니다!!");
				controler.recieveStateAction(3, i);
				mapPrint.playerDataImageChange();
				mapPrint.turnChanged();
				data.resetChangedData();
				find = true;
				System.out.println("Action finished");
			}
		}
		
		if(e.getSource().equals(startState)) {
			System.out.println("startState가 눌렸습니다!!");
			controler.recieveStateAction(2, 0);
			mapPrint.playerDataImageChange();
			mapPrint.turnChanged();
			data.resetChangedData();
		}
		
		else if(e.getSource().equals(endStone)) {
			System.out.println("endStone 버튼이 눌렸습니다!!");
			controler.recieveStateAction(4, 0);
			if(data.getFinishable()) {
				endMove.showPositionFrame();
			}
		}
		
		else if(e.getSource().equals(throwYutRandom)) {
			System.out.println("throwYutRandom 버튼이 눌렸습니다!!");
			controler.recieveThrowAction();
			mapPrint.yutImageChange();
			data.resetChangedData();
			mapPrint.turnChanged();
		}
		
		else if(e.getSource().equals(throwYutSelect)) {
			System.out.println("throwYutSelect 버튼이 눌렸습니다!!");
			getPos.showPositionFrame();
		}
		find = false;
	}
}