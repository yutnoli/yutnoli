package Control;

import Model.GameData;

public class DeleteMove extends StateExpressionChange{
	GameData data = GameData.getInstance();
	
	public void deletUsedMove(int state, int num) {
		int seqStateOld, seqStateNew;
		int diff;
		seqStateOld = convertOr2Seq(data.getChoseStateST(), data.getChoseStateNU());
		seqStateNew = convertOr2Seq(state, num);
		if(seqStateOld < 22) {
			if(seqStateNew == 22) {
				seqStateNew = 5;
			}
			else if(seqStateNew == 35) {
				seqStateNew = 10;
			}
			else if(seqStateNew == 28) {
				seqStateNew = 15;
			}
			else if(seqStateNew == 41) {
				seqStateNew = 20;
			}
			else if(seqStateNew == 42) {
				seqStateNew = 21;
			}
		}
		else if(seqStateOld > 21 && seqStateOld < 35) {
			if(seqStateNew == 38) {
				seqStateNew = 25;
			}
			else if(seqStateNew > 15 && seqStateNew < 20) {
				seqStateNew += 13;
			}
			else if(seqStateNew == 41) {
				seqStateNew = 33;
			}
			else if(seqStateNew == 42) {
				seqStateNew = 34;
			}
		}
		diff = seqStateNew - seqStateOld;
		if(diff == 1) {
			data.removePlayerMove(data.getTurn(), 0);
		}
		else if(diff == 2) {
			data.removePlayerMove(data.getTurn(), 1);
		}
		else if(diff == 3) {
			data.removePlayerMove(data.getTurn(), 2);
		}
		else if(diff == 4) {
			data.removePlayerMove(data.getTurn(), 3);
		}
		else if(diff == 5) {
			data.removePlayerMove(data.getTurn(), 4);
		}
		else
			System.out.println("Delete back Do: " + data.removePlayerMove(data.getTurn(), -1));
	}
	
	public boolean deleteSelectedMove(int move) {
		if(data.findPlayerMove(data.getTurn(), move)) {
			data.removePlayerMove(data.getTurn(), move);
			return true;
		}
		else
			return false;
	}
}
