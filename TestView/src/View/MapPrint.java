package View;

import java.awt.*;

import javax.swing.*;

public class MapPrint extends JFrame {
	JButton[] normalState = new JButton[24];
	JButton[] cornerCenterState =  new JButton[4];
	JButton startState;
	
	public void testImage() {
		this.setTitle("Yutnoli");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container gamePanel = getContentPane();
		gamePanel.setLayout(null);
		
//이미지를 버튼의 크기에 맞게 조절하는 부분
		//normalState Image
		ImageIcon icon = new ImageIcon("./normal_state.png");
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon resizedIconN = new ImageIcon(resizedImage);
		//cornerCenterState Image
		icon = new ImageIcon("./corner_center_state.png");
		img = icon.getImage();
		resizedImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon resizedIconC = new ImageIcon(resizedImage);
		//startState Image
		icon = new ImageIcon("./start_state.png");
		img = icon.getImage();
		resizedImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon resizedIconS = new ImageIcon(resizedImage);
		
//이미지 넣은 버튼 생성
		for(int i = 0; i < 24; i++) {
			//버튼에 이미지 입력
			normalState[i] = new JButton(resizedIconN);
			//버튼 배경 삭제
			normalState[i].setBorderPainted(false);
			normalState[i].setContentAreaFilled(false);
			normalState[i].setFocusPainted(false);
		}
		for(int i = 0; i < 4; i++) {
			//버튼에 이미지 입력
			cornerCenterState[i] = new JButton(resizedIconC);
			//버튼 배경 삭제
			cornerCenterState[i].setBorderPainted(false);
			cornerCenterState[i].setContentAreaFilled(false);
			cornerCenterState[i].setFocusPainted(false);
		}
		//버튼에 이미지 입력
		startState = new JButton(resizedIconS);
		//버튼 배경 삭제
		startState.setBorderPainted(false);
		startState.setContentAreaFilled(false);
		startState.setFocusPainted(false);

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
//panel에 button add		
		for(int i = 0; i < 24; i++) {
			gamePanel.add(normalState[i]);
		}
		for(int i = 0; i < 4; i++) {
			gamePanel.add(cornerCenterState[i]);
		}
		gamePanel.add(startState);
		
		gamePanel.setBackground(Color.white);
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}