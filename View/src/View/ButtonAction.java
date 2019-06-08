package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonAction implements ActionListener{
	JButton[] normalState;
	JButton[] cornerCenterState;
	JButton startState;
	
	public ButtonAction(JButton[] normalState, JButton[] cornerCenterState, JButton startState){
		this.normalState = normalState;
		this.cornerCenterState = cornerCenterState;
		this.startState = startState;
	}
	
	public void actionPerformed(ActionEvent e) {
		boolean find = false;
		
		for(int i = 0; !find && i < 24; i++) {
			if(e.getSource().equals(normalState[i])) {
				System.out.println("normalState " + i + "번 버튼이 눌렸습니다!!");
				find = true;
			}
		}
		
		for(int i = 0; !find && i < 4; i++) {
			if(e.getSource().equals(cornerCenterState[i])) {
				System.out.println("cornerCenterState " + i + "번 버튼이 눌렸습니다!!");
				find = true;
			}
		}

		if(e.getSource().equals(startState)) {
			System.out.println("startState가 눌렸습니다!!");
		}
		
		find = false;
	}
}
