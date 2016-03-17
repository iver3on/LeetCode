import java.util.ArrayList;

public class nowcoder1 {

	public static void main(String[] args) {
		int[][] matrix = {{1,2}};
		ArrayList<Integer> list = printMatrix(matrix);
		for(int x:list){
			System.out.print(x+" ");
		}
		//System.out.println(matrix[0].length);
	}

	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		int number =  matrix[0].length*matrix.length;
		ArrayList<Integer> list = new ArrayList<>();
		//二维数组行数 列数
		int left = 0, right = matrix[0].length -1, up = 0, down = matrix.length-1;
		int i = 0, j = 0;
		while (true) {
			// 开始朝右
			while (j != right + 1) {
				list.add(matrix[i][j]);
				j++;
			}
			if (list.size()==number) {
				break;
			}
			// 循环完成后j为4
			// 恢复j为3，开始朝下.up为0
			j--;
			up++;
			i = up;
			while (i != down + 1) {
				list.add(matrix[i][j]);
				i++;
			}
			if (list.size()==number) {
				break;
			}
			// 恢复i为3,开始朝左
			i--;
			right--;
			j = right;
			while (j != left - 1) {
				list.add(matrix[i][j]);
				j--;
			}
			if (list.size()==number) {
				break;
			}
			// 恢复j为0，开始朝上
			j++;
			down--;
			i = down;
			while (i != up - 1) {
				list.add(matrix[i][j]);
				i--;
			}
			if (list.size()==number) {
				break;
			}
			i++;
			left++;
			j = left;
		}
		return list;
	}

}
