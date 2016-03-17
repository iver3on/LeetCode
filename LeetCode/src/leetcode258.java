import java.util.ArrayList;
import java.util.List;

public class leetcode258 {

	//jis
	public static void main(String[] args) {
		int n = 124;
		while (n >= 10) {
			n = getList(n);
		}
		System.out.println(n);

	}

	public static int getList(int n) {
		List<Integer> list = new ArrayList<>();
		int sum = 0;
			while (n != 0) {
				list.add(n % 10);
				n = n / 10;
			}
		for (int x : list) {
			sum = sum + x;
		}
		return sum;
	}
}
