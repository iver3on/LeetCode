import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class grid {

	/*
	 * 从上面的从标可以看出一个规律。 左上角的半个表格（以对角线分界）的横坐标和纵坐标从0开始， 每一组增1，直到增至表格的边界（n -
	 * 1），而且是交替的，也就是说，偶数行是列增，行减小，行+列=组的索引。 而右下角的4组数字虽然行、列也是交替增长的，但递减的行或列总是从(n -
	 * 1)开始（对于本例，是从4开始）， 而递增的行或列总是从index - n + 1开始，其中index表示组的索引。这就可以得出一个算法。
	 * 实现代码如下：
	 */

	public static void main(String[] args) {

	}

	/*// 打印蛇形数组
	@Test
	public int[][] getGrid(int n) {
		int[][] array = new int[n][n];
		int row = 0, col = 0, m = 1;
		// 用于控制奇偶组，false表示偶组，true表示奇组
		boolean isRow = false;
		// i表示当前组的索引，从0开始
		for (int i = 0; i < (2 * n - 1); i++) {
			row = i;
			while (row >= ((i < n) ? 0 : i - n + 1)) {
				// 如果处理的是右下角表格中的数字，行或列最大不能超过n-1
				if (row > (n - 1))
					row = n - 1;
				col = i - row;
				if (isRow)
					array[row][col] = m;
				else
					// 将row变成列，将col变成行
					array[col][row] = m;
				m++;
				row--;
			}
			// 切换奇偶组
			isRow = !isRow;
		}
		return array;
	}
*/
	// 实现循环数组
	@Test
	public void Test1() {
		int[][] array = new int[4][4];
		// 分别
		int left = 0, right = 3, up = 0, down = 3;
		int i = 0, j = 0, n = 1;
		while (true) {
			// 开始朝右
			while (j != right + 1) {
				array[i][j] = n;
				j++;
				n++;
			}
			if ((n - 1) == 16) {
				break;
			}
			// 循环完成后j为4
			// 恢复j为3，开始朝下.up为0
			j--;
			up++;
			i = up;
			while (i != down + 1) {
				array[i][j] = n;
				i++;
				n++;

			}
			if ((n - 1) == 16) {
				break;
			}
			// 恢复i为3,开始朝左
			i--;
			right--;
			j = right;
			while (j != left - 1) {
				array[i][j] = n;
				j--;
				n++;
			}
			if ((n - 1) == 16) {
				break;
			}
			// 恢复j为0，开始朝上
			j++;
			down--;
			i = down;
			while (i != up - 1) {
				array[i][j] = n;
				i--;
				n++;
			}
			if ((n - 1) == 16) {
				break;
			}
			i++;
			left++;
			j = left;
		}

		for (int m = 0; m < 4; m++) {
			for (int l = 0; l < 4; l++) {
				System.out.print(array[m][l] + "#");
			}
			System.out.println();
		}

	}

	// Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has
	// only one digit, return it.
	@Test
	public void addDigits() {
		int n = 38;
		while(getList(n)>=10){
			n = getList(n);
		}
		System.out.println(n);
	}

	public int getList(int n) {
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		while (n / 10 !=0) {
			list.add(n % 10);
			n = n / 10;
		}
		for (int x : list) {
			sum = sum + x;
		}
		return sum;
	}
}
