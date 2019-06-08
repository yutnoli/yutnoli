package View;

import java.awt.*;
import javax.swing.*;
import View.MapPrint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class PlayerAction implements ActionListener{
	JButton[] getPlayerButton;
	JFrame initFrame;
	int numOfPlayer;
	InitGameStone initStone;
	
	
	public PlayerAction(JButton[] getPlayerButton, JFrame initFrame) {
		this.getPlayerButton =  getPlayerButton;
		this.initFrame = initFrame;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(getPlayerButton[0])) {
				numOfPlayer = 2;
				System.out.println("player number: 2");
				initFrame.dispose();
				initStone = new InitGameStone(numOfPlayer);
				initStone.gameInitFrame();
		}
		else if(e.getSource().equals(getPlayerButton[1])) {
			numOfPlayer = 3;
			System.out.println("player number: 3");
			initFrame.dispose();
			initStone = new InitGameStone(numOfPlayer);
			initStone.gameInitFrame();
		}
		else if(e.getSource().equals(getPlayerButton[2])) {
			numOfPlayer = 4;
			System.out.println("player number: 4");
			initFrame.dispose();
			initStone = new InitGameStone(numOfPlayer);
			initStone.gameInitFrame();
		}
		else {
			initFrame.dispose();
			initStone = new InitGameStone(4);
			initStone.gameInitFrame();
		}
	}
}
		
class InitGamePlayer extends JFrame{
	JButton[] getPlayerButton = new JButton[3];
	
	void gameInitFrame() {
		this.setTitle("Yutnoli");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container gamePanel = getContentPane();
		gamePanel.setLayout(null);
			
		for(int i = 0; i < 3; i++) {
			getPlayerButton[i] = new JButton((i+2)+"Players");
		}
		
		PlayerAction action = new PlayerAction(getPlayerButton, this);
		
		for(int i = 0; i < 3; i++) {
			getPlayerButton[i].addActionListener(action);
			getPlayerButton[i].setBounds(70 + 170*i, 100, 100, 50);
			gamePanel.add(getPlayerButton[i]);
		}
		gamePanel.setBackground(Color.white);
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

class StoneAction implements ActionListener{
	JButton[] getStoneButton;
	JFrame initFrame;
	int numOfPlayer;
	int numOfStone;
	
	public StoneAction(JButton[] getStoneButton, JFrame initFrame, int numOfPlayer) {
		this.getStoneButton =  getStoneButton;
		this.initFrame = initFrame;
		this.numOfPlayer = numOfPlayer;
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
		initFrame.dispose();
		MapPrint mainMap = new MapPrint();
		mainMap.testImage();
	}
}

class InitGameStone extends JFrame{
	JButton[] getStoneButton = new JButton[4];
	int numOfPlayer;
	
	public InitGameStone(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
	}
	
	void gameInitFrame() {
		this.setTitle("Yutnoli");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container gamePanel = getContentPane();
		gamePanel.setLayout(null);
			
		for(int i = 0; i < 4; i++) {
			getStoneButton[i] = new JButton((i+1)+"Stones");
		}
		
		StoneAction action = new StoneAction(getStoneButton, this, numOfPlayer);
		
		for(int i = 0; i < 4; i++) {
			getStoneButton[i].addActionListener(action);
			getStoneButton[i].setBounds(37 + 137*i, 100, 100, 50);
			gamePanel.add(getStoneButton[i]);
		}
		gamePanel.setBackground(Color.white);
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

public class GameMain{
	
	public static void main(String[] args) {
		InitGamePlayer initGame = new InitGamePlayer();
		initGame.gameInitFrame();
	}
}