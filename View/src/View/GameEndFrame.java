package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Control.DeleteMove;

class SelectOption implements ActionListener{
	JButton[] getPositionButton;
	JFrame selectFrame;
	MapPrint mainMap;
	DeleteMove delete = new DeleteMove();
	GetInitData initGame = GetInitData.getInstance();
	
	
	void initSelcetOption(JButton[] getPositionButton, JFrame selectFrame, MapPrint mainMap) {
		this.getPositionButton =  getPositionButton;
		this.selectFrame = selectFrame;
		this.mainMap = mainMap;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(getPositionButton[0])) {
			selectFrame.dispose();
			initGame.getDataStart(1, mainMap);
			System.out.println("selected number: 0");
		}
		else if(e.getSource().equals(getPositionButton[1])) {
			//End Game
			System.exit(0);
			System.out.println("selected number: 1");
		}
	}
}

public class GameEndFrame extends JFrame{
	JButton[] getSelectButton = new JButton[2];
	SelectOption option = new SelectOption();
	int selected;
	Container gamePanel;
	JLabel winnerMsg1, winnerMsg2;
	
	void initPositionFrame(MapPrint mainMap) {
		this.setTitle("WINNER!!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel = getContentPane();
		gamePanel.setLayout(null);
		
		getSelectButton[0] = new JButton("Restart");
		getSelectButton[1] = new JButton("GameEnd");
		
		option.initSelcetOption(getSelectButton, this, mainMap);
		
		for(int i = 0; i < 2; i++) {
			getSelectButton[i].addActionListener(option);
			getSelectButton[i].setBounds(250 + 280*i, 270, 100, 50);
			gamePanel.add(getSelectButton[i]);
		}
		
		gamePanel.setBackground(Color.white);
		this.setSize(900, 400);
		this.setLocationRelativeTo(null);
	}
	
	public void showPositionFrame(int winner) {
		String winPlayer;
		if(winner == 0)
			winPlayer = "   Red";
		else if(winner == 1)
			winPlayer = "  Blue";
		else if(winner == 2)
			winPlayer = " Green";
		else
			winPlayer = "Yellow";
		
		if(winnerMsg1 != null) {
			gamePanel.remove(winnerMsg1);
			gamePanel.remove(winnerMsg2);
		}
		
		Font msgFont=new Font("Times",Font.BOLD,60);
		winnerMsg1= new JLabel("Player " + winPlayer);
		winnerMsg1.setFont(msgFont);
		winnerMsg1.setBounds(250, 50, 500, 100);
		msgFont=new Font("Times",Font.BOLD,40);
		winnerMsg2= new JLabel(" WINNER WINNER CHICKEN DINNER!!");
		winnerMsg2.setFont(msgFont);
		winnerMsg2.setBounds(80, 150, 750, 100);
		
		gamePanel.add(winnerMsg1);
		gamePanel.add(winnerMsg2);
		
		this.setVisible(true);
	}	
}