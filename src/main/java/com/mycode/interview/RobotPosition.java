package com.mycode.interview;


//https://www.geeksforgeeks.org/check-if-a-given-sequence-of-moves-for-a-robot-is-circular-or-not/
//Asked in chewy
//assuming starting position is 00
//		  N
//		  |
//		  |
//W -------------- E
//		  |
//		  |
//		  S 
public class RobotPosition {

	public static void main(String[] args) {
		String path = "GLGLGLG";
		String cm; //current move
		String cd = "N"; //current direction
		int x = 0;
		int y = 0;

		for (int i = 0; i < path.length(); i++) {
			cm = path.charAt(i) + "";

			if (cm.equals("L") || cm.equals("R")) {
				cd = getCD(cd, cm);
			} else if (cm.equals("G") && cd.equals("N")) {
				y++;
			} else if (cm.equals("G") && cd.equals("W")) {
				x--;
			} else if (cm.equals("G") && cd.equals("S")) {
				y--;
			} else if (cm.equals("G") && cd.equals("E")) {
				x++;
			}
		}
		System.out.println("x: " + x);
		System.out.println("y: " + y);
	}

	private static String getCD(String cd, String cm) {
		if (cd.equals("N") && cm.equals("L")) {
			return "W";
		} else if (cd.equals("W") && cm.equals("L")) {
			return "S";
		} else if (cd.equals("S") && cm.equals("L")) {
			return "E";
		}
		return "X";// invalid
	}

}
