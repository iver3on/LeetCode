/**
 * 
 */
package net.zwb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com 2016Äê5ÔÂ10ÈÕ
 */
public class ValidSudoku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * char[][] board = { { '.', '2', '.', '.', '5', '.', '.', '1', '.' }, {
		 * '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.',
		 * '.', '4', '.', '.', '3' }, { '8', '.', '.', '.', '.', '.', '.', '2',
		 * '.' }, { '.', '.', '2', '.', '7', '.', '.', '.', '.' }, { '.', '1',
		 * '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2',
		 * '.', '.', '.' }, { '.', '2', '.', '9', '.', '.', '.', '.', '.' }, {
		 * '.', '.', '4', '.', '.', '.', '.', '.', '.' } };
		 */

		char[][] board = { { '.', '.', '.', '9', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '3', '.', '.', '.', '.', '.', '1' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '1', '.', '.', '.', '.', '.', '3', '.', '.' },
				{ '.', '.', '.', '.', '2', '.', '6', '.', '.' },
				{ '.', '9', '.', '.', '.', '.', '.', '7', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '8', '.', '.', '8', '.', '.', '.', '.', '.' } };

		System.out.println(isValidSudoku(board));
	}

	public static boolean isValidSudoku(char[][] board) {
		boolean[][] col = new boolean[9][9];
		boolean[][] row = new boolean[9][9];
		boolean[][] cube = new boolean[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				int index = board[i][j] - '1';
				int cubeId = (i / 3) * 3 + j / 3;
				if (col[j][index]) {
					return false;
				} else {
					col[j][index] = true;
				}

				if (row[i][index]) {
					return false;
				} else {
					row[i][index] = true;
				}

				if (cube[cubeId][index]) {
					return false;
				} else {
					cube[cubeId][index] = true;
				}
			}
		}
		return true;
	}
	
	public static boolean isValidSudoku3(char[][] board) {
		Set<Character>[] setXX = new HashSet[9];
		Set<Character>[] setYY = new HashSet[9];
		Set<Character>[] setXY = new HashSet[9];
		for (int i = 0; i < 9; i++) {
			setXX[i] = new HashSet<>();
			setYY[i] = new HashSet<>();
			setXY[i] = new HashSet<>();
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if(!setXX[i].add(board[i][j])){
					return false;
				}
				if(!setYY[j].add(board[i][j])){
					return false;
				}
				if(!setXY[(j / 3)* 3 + i / 3].add(board[i][j])){
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isValidSudoku2(char[][] board) {
		Set<Character>[] setXX = new HashSet[9];
		Set<Character>[] setYY = new HashSet[9];
		Set<Character>[] setXY = new HashSet[9];
		for (int i = 0; i < 9; i++) {
			setXX[i] = new HashSet<>();
			setYY[i] = new HashSet<>();
			setXY[i] = new HashSet<>();
		}

		boolean visit[][] = new boolean[9][9];
		boolean visit1[][] = new boolean[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				visit[i][j] = false;
				visit1[i][j] = false;
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.' && board[j][i] == '.') {
					continue;
				} else if (board[i][j] == '.') {
					if (!visit[j][i]
							&& (!setYY[i].add(board[j][i]) || !setXY[(j / 3)
									* 3 + i / 3].add(board[j][i]))) {
						System.out.println(visit[j][i]);
						System.out.println(board[j][i] + "," + i + j);
						return false;
					} else
						visit[j][i] = true;
				} else if (board[j][i] == '.') {
					if (!visit1[i][j]
							&& (!setXX[i].add(board[i][j]) || !setXY[(i / 3)
									* 3 + j / 3].add(board[i][j]))) {
						return false;
					} else {
						visit1[i][j] = true;
					}
				} else {
					if (!setXX[i].add(board[i][j])
							|| !setYY[i].add(board[j][i])
							|| !setXY[(i / 3) * 3 + j / 3].add(board[i][j])) {
						return false;
					}
					/*
					 * if (!setXX[i].add(board[i][j]) ||
					 * !setYY[i].add(board[j][i])||!setXY[(i / 3) * 3 + j /
					 * 3].add(board[i][j])) { return false; }
					 */
				}
			}
		}
		return true;
	}

	/*
	 * if (!setXY[(i / 3) * 3 + j / 3].add(board[i][j])) { return false; }
	 */
	public static boolean isValidSudoku1(char[][] board) {
		Map<Integer, Character> mapX = new HashMap<>();
		Map<Integer, Character> mapY = new HashMap<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (mapX.containsValue(board[i][j])
						&& isPart(getKey(mapX, board[i][j]), i)
						&& isPart(getKey(mapY, board[i][j]), j)) {
					return false;
				}
				if (mapY.containsValue(board[i][j])
						&& isPart(getKey(mapY, board[i][j]), j)
						&& isPart(getKey(mapX, board[i][j]), i)) {
					System.out.println(getKey(mapY, board[i][j]) + ".." + i
							+ ".." + j + ".." + board[i][j]);
					return false;
				}
				mapX.put(j, board[i][j]);
				mapY.put(j, board[i][j]);
			}
		}
		return true;
	}

	public static boolean isPart(int i, int j) {
		if (Math.abs(j - i) < 3) {
			if (j >= 3 && i <= 2 || i >= 3 && j <= 2) {
				return false;
			} else if (j >= 6 && i <= 5 || i >= 3 && j <= 2) {
				return false;
			} else
				return true;
		}
		return false;
	}

	public static int getKey(Map<Integer, Character> mapX, Character value) {
		for (Entry<Integer, Character> entry : mapX.entrySet()) {
			if (entry.getValue() == value) {
				return entry.getKey();
			}
		}
		return -1;
	}
}
