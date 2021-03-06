package Control;

public class StateExpressionChange {
	int[] ret = new int[2];
	
	public int convertOr2Seq(int state, int num) {
		if(state == 0) {
			if(num >=0 && num<4) {
				return num + 1;
			}
			else if(num>3 && num<8) {
				return num + 2;
			}
			else if (num > 7 && num <12) {
				return num + 3;
			}
			else if (num > 11 && num < 16) {
				return num + 4;
			}
			else if (num > 15 && num < 18) {
				return num + 7;
			}
			else if (num > 17 && num < 20) {
				return num + 8;
			}
			else if (num > 19 && num < 22) {
				return num + 16;
			}
			else if (num > 21 && num < 24) {
				return num + 17;
			}
		}
		else if(state == 1) {
			if(num == 0)
				return 22;
			else if(num == 1) 
				return 35;
			else if (num == 2)
				return 28;
			else if (num == 3) {
				return 38;
			}
		}
		else if(state == 2) {
			return 41;
		}
		else if(state == 3) {
			return 0;
		}
		else if(state == 4) {
			return 42;
		}
		return 42;
	}
	
	public int[] convertSeq2Or(int num) {//Be careful when state number is '0'. This function does not return correct team value.
		if(num == 0) {
			ret[0] = 3;
			ret[1] = 0;
			return ret;
		}
		else if(num > 0 && num < 5) {
			ret[0] = 0;
			ret[1] = num - 1;
			return ret;
		}
		else if(num > 5 && num < 10) {
			ret[0] = 0;
			ret[1] = num -2;
			return ret;
		}
		else if(num > 10 && num < 15) {
			ret[0] = 0;
			ret[1] = num -3;
			return ret;
		}
		else if(num > 15 && num < 20) {
			ret[0] = 0;
			ret[1] = num -4;
			return ret;
		}
		else if(num > 28 && num < 33) {
			ret[0] = 0;
			ret[1] = num -17;
			return ret;
		}
		else if(num > 22 && num < 25) {
			ret[0] = 0;
			ret[1] = num -7;
			return ret;
		}
		else if(num > 25 && num < 28) {
			ret[0] = 0;
			ret[1] = num -8;
			return ret;
		}
		else if(num > 35 && num < 38) {
			ret[0] = 0;
			ret[1] = num -16;
			return ret;
		}
		else if(num > 38 && num < 41) {
			ret[0] = 0;
			ret[1] = num -17;
			return ret;
		}
		else if(num == 5 || num == 22) {
			ret[0] = 1;
			ret[1] = 0;
			return ret;
		}
		else if(num == 10 || num == 35) {
			ret[0] = 1;
			ret[1] = 1;
			return ret;
		}
		else if(num == 15 || num == 28) {
			ret[0] = 1;
			ret[1] = 2;
			return ret;
		}
		else if(num == 25 || num == 38) {
			ret[0] = 1;
			ret[1] = 3;
			return ret;
		}
		else if(num == 33 || num == 41) {
			ret[0] = 2;
			ret[1] = 0;
			return ret;
		}
		else if(num == 21 || num == 34 || num == 42) {
			ret[0] = 4;
			ret[1] = 0;
			return ret;
		}
		ret[0] = 4;
		ret[1] = 0;
		return ret;
	}
}
