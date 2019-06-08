package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonAction implements ActionListener{
	JButton[] normalState;
	JButton[] cornerCenterState;
	JButton[] playerInfo;
	JButton startState;
	JButton endStone;
	JButton throwYutRandom;
	JButton throwYutSelect;
	
	public ButtonAction(JButton[] normalState, JButton[] cornerCenterState, JButton startState, JButton[] playerInfo, JButton endStone, JButton throwYutRandom, JButton throwYutSelect){
		this.normalState = normalState;
		this.cornerCenterState = cornerCenterState;
		this.startState = startState;
		this.playerInfo = playerInfo;
		this.endStone = endStone;
		this.throwYutRandom = throwYutRandom;
		this.throwYutSelect = throwYutSelect;
	}
	
	public void actionPerformed(ActionEvent e) {
		boolean find = false;
		
		for(int i = 0; !find && i < 24; i++) {
			if(e.getSource().equals(normalState[i])) {
				System.out.println("normalState " + i + "�� ��ư�� ���Ƚ��ϴ�!!");
				find = true;
			}
		}
		
		for(int i = 0; !find && i < 4; i++) {
			if(e.getSource().equals(cornerCenterState[i])) {
				System.out.println("cornerCenterState " + i + "�� ��ư�� ���Ƚ��ϴ�!!");
				find = true;
			}
		}

		for(int i = 0; !find && i < 4; i++) {
			if(e.getSource().equals(playerInfo[i])) {
				System.out.println("player " + i + "�� ��ư�� ���Ƚ��ϴ�!!");
				find = true;
			}
		}
		
		if(e.getSource().equals(startState)) {
			System.out.println("startState�� ���Ƚ��ϴ�!!");
		}
		
		else if(e.getSource().equals(endStone)) {
			System.out.println("endStone ��ư�� ���Ƚ��ϴ�!!");
		}
		
		else if(e.getSource().equals(throwYutRandom)) {
			System.out.println("throwYutRandom ��ư�� ���Ƚ��ϴ�!!");
		}
		
		else if(e.getSource().equals(throwYutSelect)) {
			System.out.println("throwYutSelect ��ư�� ���Ƚ��ϴ�!!");
		}
		find = false;
	}
}