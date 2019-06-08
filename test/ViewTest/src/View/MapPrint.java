package View;

import java.awt.*;
import javax.swing.*;

import View.ButtonAction;

public class MapPrint extends JFrame {
	JButton[] normalState = new JButton[24];
	JButton[] cornerCenterState =  new JButton[4];
	JButton startState;
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

	public void testImage() {
		this.setTitle("Yutnoli");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container gamePanel = getContentPane();
		gamePanel.setLayout(null);
		
//�̹����� ��ư�� ũ�⿡ �°� �����ϴ� �κ�
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
		
//�̹��� ���� ��ư ����
		for(int i = 0; i < 24; i++) {
			//��ư�� �̹��� �Է�
			normalState[i] = new JButton(resizedIconNOrg);
			//��ư ��� ����
			normalState[i].setBorderPainted(false);
			normalState[i].setContentAreaFilled(false);
			normalState[i].setFocusPainted(false);
		}
		for(int i = 0; i < 4; i++) {
			//��ư�� �̹��� �Է�
			cornerCenterState[i] = new JButton(resizedIconCOrg);
			//��ư ��� ����
			cornerCenterState[i].setBorderPainted(false);
			cornerCenterState[i].setContentAreaFilled(false);
			cornerCenterState[i].setFocusPainted(false);
		}
		//��ư�� �̹��� �Է�
		startState = new JButton(resizedIconSOrg);
		//��ư ��� ����
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

		mapClicked =  new ButtonAction(normalState, cornerCenterState, startState, playerInfo, endStone, throwYutRandom, throwYutselect);
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
		endStone.setBounds(840, 740, 70, 70);
		throwYutRandom.setBounds(290, 50, 140, 70);
		throwYutselect.setBounds(590, 50, 140, 70);
		for(int i = 0; i < 4; i++) {
			yutPosition[i].setBounds(810 + 22*i, 50, 20, 70);
		}
		
//panel�� button add		
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
		
		gamePanel.setBackground(Color.white);
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}