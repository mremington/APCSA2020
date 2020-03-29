package Unit13;

import java.util.*;
import java.io.*;

public class WordSearch {
	private String[][] m;

//	A P P L E X Y P 
//	X L H J K E E D 
//	E G G L L X X C 
//	G F P D G O G N 
//	M Y N T A H U U 
//	P U Q D G B T S 
//	B T H I G H M S 
//	I L K X L T H I 
	
	//m[0][0] --> array 0 --> element 0 --> A
	//m[1][3] --> array 1 --> element 3 --> J

	public WordSearch(int size, String str) {
		m = new String[size][size];
		int i = 0;
		// r - represents the rows --> each array
		for (int r = 0; r < size; r++) {
			// c - represents the columns --> each element in an array represented by r
			for (int c = 0; c < size; c++) {
				m[r][c] = str.substring(i++, i);
			}
		}
	}

	public boolean isFound(String word) {
		boolean found = false;
		int len = m.length; //how many arrays
		for (int r = 0; !found && r < len; r++) {
			for (int c = 0; !found && c < len; c++) {
				if (word.substring(0, 1).equals(m[r][c])) {
					found = checkRight(word, r, c, len) || checkLeft(word, r, c, len) || checkUp(word, r, c, len)
							|| checkDown(word, r, c, len) || checkDiagUpRight(word, r, c, len)
							|| checkDiagUpLeft(word, r, c, len) || checkDiagDownLeft(word, r, c, len)
							|| checkDiagDownRight(word, r, c, len);
				}
			}
		}
		return found;
	}

	public boolean checkRight(String w, int r, int c, int len) {
		int i = 0;
		while (i < w.length()) {
			if (c + i < 0 || c + i >= len)
				return false;
			if (!w.substring(i, i + 1).equals(m[r][c + i]))
				return false;
			i++;
		}
		return true;
	}

	public boolean checkLeft(String w, int r, int c, int len) {
		int i = 0;
		while (i < w.length()) {
			if (c - i < 0 || c - i >= len)
				return false;
			if (!w.substring(i, i + 1).equals(m[r][c - i]))
				return false;
			i++;
		}
		return true;
	}

	public boolean checkUp(String w, int r, int c, int len) {
		int i = 0;
		while (i < w.length()) {
			if (r - i < 0 || r - i >= len)
				return false;
			if (!w.substring(i, i + 1).equals(m[r - i][c]))
				return false;
			i++;
		}
		return true;
	}

	public boolean checkDown(String w, int r, int c, int len) {
		int i = 0;
		while (i < w.length()) {
			if (r + i < 0 || r + i >= len)
				return false;
			if (!w.substring(i, i + 1).equals(m[r + i][c]))
				return false;
			i++;
		}
		return true;
	}

	public boolean checkDiagUpRight(String w, int r, int c, int len) {
		int i = 0;
		while (i < w.length()) {
			if (r - i < 0 || r - i >= len || c + i < 0 || c + i >= len)
				return false;
			if (!w.substring(i, i + 1).equals(m[r - i][c + i]))
				return false;
			i++;
		}
		return true;
	}

	public boolean checkDiagUpLeft(String w, int r, int c, int len) {
		int i = 0;
		while (i < w.length()) {
			if (r - i < 0 || r - i >= len || c - i < 0 | c - i >= len)
				return false;
			if (!w.substring(i, i + 1).equals(m[r - i][c - i]))
				return false;
			i++;
		}
		return true;
	}

	public boolean checkDiagDownLeft(String w, int r, int c, int len) {
		int i = 0;
		while (i < w.length()) {
			if (r + i < 0 || r + i >= len || c - i < 0 || c - i >= len)
				return false;
			if (!w.substring(i, i + 1).equals(m[r + i][c - i]))
				return false;
			i++;
		}
		return true;
	}

	public boolean checkDiagDownRight(String w, int r, int c, int len) {
		int i = 0;
		while (i < w.length()) {
			if (r + i < 0 || r + i >= len || c + i < 0 || c + i >= len)
				return false;
			if (!w.substring(i, i + 1).equals(m[r + i][c + i]))
				return false;
			i++;
		}
		return true;
	}

	public String toString() {
		String out = "";
		for (String[] row : m) {
			for (String val : row) {
				out += val + " ";
			}
			out += "\n";
		}
		return out;
	}
}