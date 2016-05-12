package net.zwb;

public class test11 {
	public static boolean exist(char[][] board, String word) {
		int row = board.length;
		char[] w = word.toCharArray();
		if (row < 1) {
			return false;
		}
		int col = board[0].length;
		boolean[][] flag = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				flag[i][j] = true;
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == word.charAt(0)) {
					flag[i][j] = false;
					if (wheExists(board, i, j, word.substring(1), flag)) {
						return true;
					}
					flag[i][j] = true;
				}
			}
		}
		return false;
	}

	public static boolean wheExists(char[][] board, int i, int j, String w,
			boolean[][] flag) {
		if (0 == w.length()) {
			return true;
		}
		// 分别代表board中元素上 下 左 右移动
		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int k = 0; k < direction.length; k++) {
			int ii = i + direction[k][0];
			int jj = j + direction[k][1];
			if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[i].length
					&& board[ii][jj] == w.charAt(0) && flag[ii][jj]) {
				flag[ii][jj] = false;
				if (w.length() == 1
						|| wheExists(board, ii, jj, w.substring(1), flag)) {
					return true;
				}
				flag[ii][jj] = true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] a = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		String b = "ABCESCED";

		long x = System.currentTimeMillis();
		System.out.println(exist(a, b));
		long y = System.currentTimeMillis();
		System.out.println(y - x);
		System.out.println(b.substring(1));
	}
}
