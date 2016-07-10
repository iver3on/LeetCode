package nowcodehuawei;

import java.util.Scanner;

/*
 * 1,不止输入一组n m ;
   2,AB之间，可能A>B
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		do {
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			int[] score = new int[N];
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				score[i] = x;
			}
			sc.nextLine();
			String[][] operation = new String[M][3];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < 3; j++) {
					operation[i][j] = sc.next();
				}
			}
			sc.nextLine();
			judge(N, M, score, operation);
		} while (sc.hasNextLine());
		sc.close();
	}

	private static void judge(int n, int m, int[] score, String[][] operation) {
		for (int i = 0; i < m; i++) {
			int j = 0;
			if (operation[i][j].equals("Q")) {
				System.out.println(getMax(score, Integer.parseInt(operation[i][j + 1]) - 1,
						Integer.parseInt(operation[i][j + 2]) - 1));
			} else {
				exchange(score, Integer.parseInt(operation[i][j + 1]) - 1, Integer.parseInt(operation[i][j + 2]));
				// System.out.println("交换" + score[8] + ".." +
				// Integer.parseInt(operation[i][j + 2]));
			}
		}
	}

	public static int getMax(int[] array, int i, int j) {
		if (i > j) {
			int tmp = i;
			i = j;
			j = tmp;
		}
		int max = array[i];
		for (int k = i; k <= j; k++) {
			if (array[k] > max) {
				max = array[k];
			}
		}
		return max;
	}

	public static void exchange(int[] array, int i, int score) {
		array[i] = score;
	}
}
