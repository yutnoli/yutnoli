package View;

import java.awt.*;
import javax.swing.*;

import View.ButtonAction;
import Model.GameData;

public class MapPrint extends JFrame {
	GameData data = GameData.getInstance();
	JButton[] normalState = new JButton[24];
	JButton[] cornerCenterState =  new JButton[4];
	JButton startState;
	JButton[] normalStateStone = new JButton[24];
	JButton[] cornerCenterStateStone =  new JButton[4];
	JButton startStateStone;
	JButton[] playerInfo = new JButton[4];
	JButton endStone;
	JButton throwYutRandom;
	JButton throwYutselect;
	ButtonAction mapClicked;
	ImageIcon[] teamIcon = new ImageIcon[20];
	JButton[] yutPosition = new JButton[4];
	ImageIcon[] yutIcon = new ImageIcon[2];
	ImageIcon resizedIconNOrg;
	ImageIcon resizedIconCOrg;
	ImageIcon resizedIconSOrg;
	ImageIcon[] team1StateIcon = new ImageIcon[4];
	ImageIcon[] team2StateIcon = new ImageIcon[4];
	ImageIcon[] team3StateIcon = new ImageIcon[4];
	ImageIcon[] team4StateIcon = new ImageIcon[4];

	public void initMapPrint(int numOfPlayers, int numOfStones) {
		data.initGameData(numOfPlayers, numOfStones);
	}
	
	public void initImage() {
		this.setTitle("Yutnoli");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container gamePanel = getContentPane();
		gamePanel.setLayout(null);
		
//이미지를 버튼의 크기에 맞게 조절하는 부분
		//normalState Image
		ImageIcon icon = new ImageIcon("./normal_state.png");
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		resizedIconNOrg = new ImageIcon(resizedImage);
		//cornerCenterState Image
		icon = new ImageIcon("./corner_center_state.png");
		img = icon.getImage();
		resizedImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		resizedIconCOrg = new ImageIcon(resizedImage);
		//startState Image
		icon = new ImageIcon("./start_state.png");
		img = icon.getImage();
		resizedImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		resizedIconSOrg = new ImageIcon(resizedImage);
		//team Image
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				icon = new ImageIcon("./team" + (i+1) + "_" + j + ".png");
				img = icon.getImage();
				resizedImage = img.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
				teamIcon[5*i + j] = new ImageIcon(resizedImage);
			}
		}
		//yut image
		icon = new ImageIcon("./yut_round.png");
		img = icon.getImage();
		resizedImage = img.getScaledInstance(20, 70, Image.SCALE_SMOOTH);
		yutIcon[0] = new ImageIcon(resizedImage);
		icon = new ImageIcon("./yut_flat.png");
		img = icon.getImage();
		resizedImage = img.getScaledInstance(20, 70, Image.SCALE_SMOOTH);
		yutIcon[1] = new ImageIcon(resizedImage);
		//throw Image
		icon = new ImageIcon("./throw_random.png");
		img = icon.getImage();
		resizedImage = img.getScaledInstance(140, 70, Image.SCALE_SMOOTH);
		ImageIcon throwRandomIcon = new ImageIcon(resizedImage);
		icon = new ImageIcon("./throw_select.png");
		img = icon.getImage();
		resizedImage = img.getScaledInstance(140, 70, Image.SCALE_SMOOTH);
		ImageIcon throwSelectIcon = new ImageIcon(resizedImage);
		//end state Image
		icon = new ImageIcon("./end_state.png");
		img = icon.getImage();
		resizedImage = img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		ImageIcon endStateIcon = new ImageIcon(resizedImage);
		for(int i = 0; i < 4; i++) {
			icon = new ImageIcon("./team1_on_state_"+(i+1)+".png");
			img = icon.getImage();
			resizedImage = img.getScaledInstance(10, 43, Image.SCALE_SMOOTH);
			team1StateIcon[i] = new ImageIcon(resizedImage);
		}
		for(int i = 0; i < 4; i++) {
			icon = new ImageIcon("./team2_on_state_"+(i+1)+".png");
			img = icon.getImage();
			resizedImage = img.getScaledInstance(10, 43, Image.SCALE_SMOOTH);
			team2StateIcon[i] = new ImageIcon(resizedImage);
		}
		for(int i = 0; i < 4; i++) {
			icon = new ImageIcon("./team3_on_state_"+(i+1)+".png");
			img = icon.getImage();
			resizedImage = img.getScaledInstance(10, 43, Image.SCALE_SMOOTH);
			team3StateIcon[i] = new ImageIcon(resizedImage);
		}
		for(int i = 0; i < 4; i++) {
			icon = new ImageIcon("./team4_on_state_"+(i+1)+".png");
			img = icon.getImage();
			resizedImage = img.getScaledInstance(10, 43, Image.SCALE_SMOOTH);
			team4StateIcon[i] = new ImageIcon(resizedImage);
		}
		
//이미지 넣은 버튼 생성
		for(int i = 0; i < 24; i++) {
			//버튼에 이미지 입력
			normalState[i] = new JButton(resizedIconNOrg);
			//버튼 배경 삭제
			normalState[i].setBorderPainted(false);
			normalState[i].setContentAreaFilled(false);
			normalState[i].setFocusPainted(false);
		}
		for(int i = 0; i < 4; i++) {
			//버튼에 이미지 입력
			cornerCenterState[i] = new JButton(resizedIconCOrg);
			//버튼 배경 삭제
			cornerCenterState[i].setBorderPainted(false);
			cornerCenterState[i].setContentAreaFilled(false);
			cornerCenterState[i].setFocusPainted(false);
		}
		//버튼에 이미지 입력
		startState = new JButton(resizedIconSOrg);
		//버튼 배경 삭제
		startState.setBorderPainted(false);
		startState.setContentAreaFilled(false);
		startState.setFocusPainted(false);
		/////////////////////TODO complete temporary button
		for(int i = 0; i < 4; i++) {
			playerInfo[i] = new JButton(teamIcon[5*i + 4]);
			playerInfo[i].setBorderPainted(false);
			playerInfo[i].setContentAreaFilled(false);
			playerInfo[i].setFocusPainted(false);
		}
		
		endStone = new JButton(endStateIcon);
		endStone.setBorderPainted(false);
		endStone.setContentAreaFilled(false);
		endStone.setFocusPainted(false);
		
		throwYutRandom = new JButton(throwRandomIcon);
		throwYutRandom.setBorderPainted(false);
		throwYutRandom.setContentAreaFilled(false);
		throwYutRandom.setFocusPainted(false);
		
		throwYutselect = new JButton(throwSelectIcon);
		throwYutselect.setBorderPainted(false);
		throwYutselect.setContentAreaFilled(false);
		throwYutselect.setFocusPainted(false);
		
		for(int i = 0; i < 4; i++) {
			yutPosition[i] = new JButton(yutIcon[0]);
			yutPosition[i].setBorderPainted(false);
			yutPosition[i].setContentAreaFilled(false);
			yutPosition[i].setFocusPainted(false);
		}

		for(int i = 0; i < 24; i++) {
			//버튼에 이미지 입력
			normalStateStone[i] = new JButton();
			//버튼 배경 삭제
			normalStateStone[i].setBorderPainted(false);
			normalStateStone[i].setContentAreaFilled(false);
			normalStateStone[i].setFocusPainted(false);
		}
		for(int i = 0; i < 4; i++) {
			//버튼에 이미지 입력
			cornerCenterStateStone[i] = new JButton();
			//버튼 배경 삭제
			cornerCenterStateStone[i].setBorderPainted(false);
			cornerCenterStateStone[i].setContentAreaFilled(false);
			cornerCenterStateStone[i].setFocusPainted(false);
		}
		//버튼에 이미지 입력
		startStateStone = new JButton();
		//버튼 배경 삭제
		startStateStone.setBorderPainted(false);
		startStateStone.setContentAreaFilled(false);
		startStateStone.setFocusPainted(false);
		
		mapClicked =  new ButtonAction(this, normalState, cornerCenterState, startState, playerInfo, endStone, throwYutRandom, throwYutselect);
		for(int i = 0; i < 24; i++) {
			normalState[i].addActionListener(mapClicked);
		}
		for(int i = 0; i < 4; i++) {
			cornerCenterState[i].addActionListener(mapClicked);
		}
		startState.addActionListener(mapClicked);
		/////////////////////TODO complete temporary button
		for(int i = 0; i < 4; i++) {
			playerInfo[i].addActionListener(mapClicked);
		}
		endStone.addActionListener(mapClicked);
		throwYutRandom.addActionListener(mapClicked);
		throwYutselect.addActionListener(mapClicked);
		
		for(int i = 0; i < 4; i++) {
			normalState[i].setBounds(750, 625 - i*100, 50, 50);
			normalState[i+4].setBounds(625 - i*100, 200, 50, 50);
			normalState[i+8].setBounds(200, 325 + i*100, 50, 50);
			normalState[i+12].setBounds(325 + i*100, 750, 50, 50);
		}
		for(int i = 0; i < 2; i++) {
			normalState[i+16].setBounds(640 - i*85, 310 + i*85, 50, 50);
			normalState[19-i].setBounds(310 + i*85, 640 - i*85, 50, 50);
			normalState[i+20].setBounds(310 + i*85, 310 + i*85, 50, 50);
			normalState[i+22].setBounds(640 - i*85, 640 - i*85, 50, 50);
		}
		cornerCenterState[0].setBounds(725, 175, 100, 100);
		cornerCenterState[1].setBounds(175, 175, 100, 100);
		cornerCenterState[2].setBounds(175, 725, 100, 100);
		cornerCenterState[3].setBounds(450, 450, 100, 100);
		startState.setBounds(725, 725, 100, 100);
		/////////////////////TODO complete temporary button
		for(int i = 0; i < 4; i++) {
			playerInfo[i].setBounds(840, 600 - 100*i, 100, 50);
		}
		endStone.setBounds(860, 740, 70, 70);
		throwYutRandom.setBounds(290, 50, 140, 70);
		throwYutselect.setBounds(590, 50, 140, 70);
		for(int i = 0; i < 4; i++) {
			yutPosition[i].setBounds(810 + 22*i, 50, 20, 70);
		}
		
		for(int i = 0; i < 4; i++) {
			normalStateStone[i].setBounds(805, 632 - i*100, 10, 43);
			normalStateStone[i+4].setBounds(680 - i*100, 207, 10, 43);
			normalStateStone[i+8].setBounds(255, 332 + i*100, 10, 43);
			normalStateStone[i+12].setBounds(380 + i*100, 757, 10, 43);
		}
		for(int i = 0; i < 2; i++) {
			normalStateStone[i+16].setBounds(695 - i*85, 317 + i*85, 10, 43);
			normalStateStone[19-i].setBounds(365 + i*85, 647 - i*85, 10, 43);
			normalStateStone[i+20].setBounds(365 + i*85, 317 + i*85, 10, 43);
			normalStateStone[i+22].setBounds(695 - i*85, 647 - i*85, 10, 43);
		}
		cornerCenterStateStone[0].setBounds(826, 207, 10, 43);
		cornerCenterStateStone[1].setBounds(276, 207, 10, 43);
		cornerCenterStateStone[2].setBounds(276, 757, 10, 43);
		cornerCenterStateStone[3].setBounds(551, 482, 10, 43);
		startStateStone.setBounds(826, 757, 10, 43);
		
//panel에 button add		
		for(int i = 0; i < 24; i++) {
			gamePanel.add(normalState[i]);
		}
		for(int i = 0; i < 4; i++) {
			gamePanel.add(cornerCenterState[i]);
		}
		gamePanel.add(startState);
		/////////////////////TODO complete temporary button
		for(int i = 0; i < 4; i++) {
			gamePanel.add(playerInfo[i]);
		}
		gamePanel.add(endStone);
		gamePanel.add(throwYutRandom);
		gamePanel.add(throwYutselect);
		for(int i = 0; i < 4; i++) {
			gamePanel.add(yutPosition[i]);
		}
		for(int i = 0; i < 24; i++) {
			gamePanel.add(normalStateStone[i]);
		}
		for(int i = 0; i < 4; i++) {
			gamePanel.add(cornerCenterStateStone[i]);
		}
		gamePanel.add(startStateStone);
		
		gamePanel.setBackground(Color.white);
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void yutImageChange() {
		int[] yut;
		yut = data.getYutPosition();
		for(int i = 0; i < 4; i++) {
			if(yut[i] == 0) {
				yutPosition[i].setIcon(yutIcon[0]);
			}
			else {
				yutPosition[i].setIcon(yutIcon[1]);
			}
		}
	}
	
	public void playerDataImageChange() {
		boolean[] stateChanged;
		boolean[] teamDataChanged;
		stateChanged = data.getStateChanged();
		teamDataChanged = data.getTeamDataChanged();
		
		for(int i = 0; i < 29; i++) {
			if(stateChanged[i]) {
				if(i == 4 || i == 9 || i == 14 || i == 21) {
					if(data.getNumData(1, i%4) == 0) {
						cornerCenterStateStone[i%4].setIcon(null);
					}
					else {
						if(data.getTeamData(1, i%4) == 0) {
							cornerCenterStateStone[i%4].setIcon(team1StateIcon[data.getNumData(1, i%4)]);
						}
						else if(data.getTeamData(1, i%4) == 1) {
							cornerCenterStateStone[i%4].setIcon(team2StateIcon[data.getNumData(1, i%4)]);
						}
						else if(data.getTeamData(1, i%4) == 2) {
							cornerCenterStateStone[i%4].setIcon(team3StateIcon[data.getNumData(1, i%4)]);
						}
						else if(data.getTeamData(1, i%4) == 3) {
							cornerCenterStateStone[i%4].setIcon(team4StateIcon[data.getNumData(1, i%4)]);
						}
					}
				}
				else if(i == 28) {
					if(data.getNumData(2, 0) == 0) {
						startState.setIcon(null);
					}
					else {
						if(data.getTeamData(2, 0) == 0) {
							startState.setIcon(team1StateIcon[data.getNumData(2, 0)]);
						}
						else if(data.getTeamData(2, 0) == 1) {
							startState.setIcon(team2StateIcon[data.getNumData(2, 0)]);
						}
						else if(data.getTeamData(2, 0) == 2) {
							startState.setIcon(team3StateIcon[data.getNumData(2, 0)]);
						}
						else if(data.getTeamData(2, 0) == 3) {
							startState.setIcon(team4StateIcon[data.getNumData(2, 0)]);
						}
					}
				}
				else if(i >= 0 && i < 4) {
					if(data.getNumData(0, i) == 0) {
						normalState[i].setIcon(null);
					}
					else {
						if(data.getTeamData(0, i) == 0) {
							normalState[i].setIcon(team1StateIcon[data.getNumData(0, i)]);
						}
						else if(data.getTeamData(0, i) == 1) {
							normalState[i].setIcon(team2StateIcon[data.getNumData(0, i)]);
						}
						else if(data.getTeamData(0, i) == 2) {
							normalState[i].setIcon(team3StateIcon[data.getNumData(0, i)]);
						}
						else if(data.getTeamData(0, i) == 3) {
							normalState[i].setIcon(team4StateIcon[data.getNumData(0, i)]);
						}
					}
				}
				else if(i > 4 && i < 9) {
					if(data.getNumData(0, i-1) == 0) {
						normalState[i].setIcon(null);
					}
					else {
						if(data.getTeamData(0, i-1) == 0) {
							normalState[i-1].setIcon(team1StateIcon[data.getNumData(0, i-1)]);
						}
						else if(data.getTeamData(0, i-1) == 1) {
							normalState[i-1].setIcon(team2StateIcon[data.getNumData(0, i-1)]);
						}
						else if(data.getTeamData(0, i-1) == 2) {
							normalState[i-1].setIcon(team3StateIcon[data.getNumData(0, i-1)]);
						}
						else if(data.getTeamData(0, i-1) == 3) {
							normalState[i-1].setIcon(team4StateIcon[data.getNumData(0, i-1)]);
						}
					}
				}
				else if(i > 9 && i < 14) {
					if(data.getNumData(0, i-2) == 0) {
						normalState[i].setIcon(null);
					}
					else {
						if(data.getTeamData(0, i-2) == 0) {
							normalState[i-2].setIcon(team1StateIcon[data.getNumData(0, i-2)]);
						}
						else if(data.getTeamData(0, i-2) == 1) {
							normalState[i-2].setIcon(team2StateIcon[data.getNumData(0, i-2)]);
						}
						else if(data.getTeamData(0, i-2) == 2) {
							normalState[i-2].setIcon(team3StateIcon[data.getNumData(0, i-2)]);
						}
						else if(data.getTeamData(0, i-2) == 3) {
							normalState[i-2].setIcon(team4StateIcon[data.getNumData(0, i-2)]);
						}
					}
				}
				else if(i > 14 && i < 21) {
					if(data.getNumData(0, i-3) == 0) {
						normalState[i].setIcon(null);
					}
					else {
						if(data.getTeamData(0, i-3) == 0) {
							normalState[i-3].setIcon(team1StateIcon[data.getNumData(0, i-3)]);
						}
						else if(data.getTeamData(0, i-3) == 1) {
							normalState[i-3].setIcon(team2StateIcon[data.getNumData(0, i-3)]);
						}
						else if(data.getTeamData(0, i-3) == 2) {
							normalState[i-3].setIcon(team3StateIcon[data.getNumData(0, i-3)]);
						}
						else if(data.getTeamData(0, i-3) == 3) {
							normalState[i-3].setIcon(team4StateIcon[data.getNumData(0, i-3)]);
						}
					}
				}
				else if(i > 21 && i < 28) {
					if(data.getNumData(0, i-4) == 0) {
						normalState[i].setIcon(null);
					}
					else {
						if(data.getTeamData(0, i-4) == 0) {
							normalState[i-4].setIcon(team1StateIcon[data.getNumData(0, i-4)]);
						}
						else if(data.getTeamData(0, i-4) == 1) {
							normalState[i-4].setIcon(team2StateIcon[data.getNumData(0, i-4)]);
						}
						else if(data.getTeamData(0, i-4) == 2) {
							normalState[i-4].setIcon(team3StateIcon[data.getNumData(0, i-4)]);
						}
						else if(data.getTeamData(0, i-4) == 3) {
							normalState[i-4].setIcon(team4StateIcon[data.getNumData(0, i-4)]);
						}
					}
				}
			}
		}
		
		for (int i = 0; i < 4; i++) {
			if(teamDataChanged[i]) {
				playerInfo[i].setIcon(teamIcon[data.getPlayerNum(i) + 5*i]);
			}
		}
	}
}