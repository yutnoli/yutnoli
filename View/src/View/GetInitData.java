package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Model.GameData;

class PlayerAction implements ActionListener{
	JButton[] getPlayerButton;
	JFrame initFrame;
	int numOfPlayer;
	int startOption;
	MapPrint mainMap;
	InitGameStone initStone = new InitGameStone();
	
	
	public PlayerAction(JButton[] getPlayerButton, JFrame initFrame, MapPrint mainMap) {
		this.getPlayerButton =  getPlayerButton;
		this.initFrame = initFrame;
		this.mainMap = mainMap;
	}
	
	public void playerActionInit(int startOption) {
		this.startOption = startOption;
		System.out.println("startOption6: " + startOption);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(getPlayerButton[0])) {
				numOfPlayer = 2;
				System.out.println("player number: 2");
				initFrame.dispose();
				initStone.getStoneInit(numOfPlayer, startOption, mainMap);
				initStone.showFrame();
		}
		else if(e.getSource().equals(getPlayerButton[1])) {
			numOfPlayer = 3;
			System.out.println("player number: 3");
			initFrame.dispose();
			System.out.println("startOption6: " + startOption);
			initStone.getStoneInit(numOfPlayer, startOption, mainMap);
			initStone.showFrame();
		}
		else if(e.getSource().equals(getPlayerButton[2])) {
			numOfPlayer = 4;
			System.out.println("player number: 4");
			initFrame.dispose();
			initStone.getStoneInit(numOfPlayer, startOption, mainMap);
			initStone.showFrame();
		}
		else {
			initFrame.dispose();
			initStone.getStoneInit(numOfPlayer, startOption, mainMap);
			initStone.showFrame();
		}
	}
}
		
class InitGamePlayer extends JFrame{
	JButton[] getPlayerButton = new JButton[3];
	PlayerAction action;
	int startOption;
	
	void getPlayerInit(int startOption, MapPrint mainMap) {
		this.setTitle("Yutnoli");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.startOption = startOption;
		Container gamePanel = getContentPane();
		gamePanel.setLayout(null);
		System.out.println("startOption4: " + startOption);
		
		for(int i = 0; i < 3; i++) {
			getPlayerButton[i] = new JButton((i+2)+"Players");
		}
		
		action = new PlayerAction(getPlayerButton, this, mainMap);
		
		for(int i = 0; i < 3; i++) {
			getPlayerButton[i].addActionListener(action);
			getPlayerButton[i].setBounds(70 + 170*i, 100, 100, 50);
			gamePanel.add(getPlayerButton[i]);
		}
		gamePanel.setBackground(Color.white);
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
	}
	
	void showFrame() {
		System.out.println("startOption5: " + startOption);
		action.playerActionInit(startOption);
		this.setVisible(true);
	}
}

class StoneAction implements ActionListener{
	JButton[] getStoneButton;
	JFrame initFrame;
	GameData data = GameData.getInstance();
	MapPrint mainMap;
	int numOfPlayer = 4;
	int numOfStone = 5;
	int startOption = 0;
	
	public StoneAction(JButton[] getStoneButton, JFrame initFrame, int numOfPlayer, int startOption, MapPrint mainMap) {
		this.getStoneButton =  getStoneButton;
		this.initFrame = initFrame;
		this.numOfPlayer = numOfPlayer;
		this.mainMap = mainMap;
	}
	
	public void stoneActionInit(int startOption) {
		this.startOption = startOption;
		System.out.println("startOption2: " + this.startOption);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(getStoneButton[0])) {
				numOfStone = 1;
				System.out.println("stone number: 1");
		}
		else if(e.getSource().equals(getStoneButton[1])) {
			numOfStone = 2;
			System.out.println("stone number: 2");
		}
		else if(e.getSource().equals(getStoneButton[2])) {
			numOfStone = 3;
			System.out.println("stone number: 3");
		}
		else if(e.getSource().equals(getStoneButton[3])) {
			numOfStone = 4;
			System.out.println("stone number: 4");
		}
		else if(e.getSource().equals(getStoneButton[4])) {
			numOfStone = 5;
			System.out.println("stone number: 5");
		}
		initFrame.dispose();
		data.initGameData(numOfPlayer, numOfStone);
		System.out.println("restart game!!!!!!!!!!!!!!1");
		System.out.println("startOption1: " + startOption);
		if(startOption == 0)
			startGame();
		else
			restartGame();
	}
	
	public void startGame() {
		mainMap.initImage();
	}
	
	public void restartGame() {
		System.out.println("restart game!!!!!!!!!!!!!!2");
		mainMap.initMap();
	}
}

class InitGameStone extends JFrame{
	JButton[] getStoneButton = new JButton[5];
	int numOfPlayer;
	int startOption;
	StoneAction action;
	
	void getStoneInit(int numOfPlayer, int startOption, MapPrint mainMap) {
		this.numOfPlayer = numOfPlayer;
		this.startOption = startOption;
		this.setTitle("Yutnoli");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container gamePanel = getContentPane();
		gamePanel.setLayout(null);
			
		for(int i = 0; i < 5; i++) {
			getStoneButton[i] = new JButton((i+1)+"Stones");
		}
		
		action = new StoneAction(getStoneButton, this, numOfPlayer, startOption, mainMap);
		
		for(int i = 0; i < 5; i++) {
			getStoneButton[i].addActionListener(action);
			getStoneButton[i].setBounds(14 + 114*i, 100, 100, 50);
			gamePanel.add(getStoneButton[i]);
		}
		gamePanel.setBackground(Color.white);
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
	}
	
	void showFrame() {
		action.stoneActionInit(startOption);
		this.setVisible(true);
	}
}

public class GetInitData {
	InitGamePlayer initGame = new InitGamePlayer();
	public static GetInitData myself;
	
	public static GetInitData getInstance() {
		if(myself == null) {
			myself = new GetInitData();
		}
		return myself;
	}
	
	public void getDataStart(int startOption, MapPrint mainMap) {
		System.out.println("startOption3: " + startOption);
		initGame.getPlayerInit(startOption, mainMap);
		initGame.showFrame();
	}
}
