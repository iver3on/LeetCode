package leetcode;

import java.util.ArrayList;
import java.util.List;

public class IsHappy {
	public static boolean isHappy(int n) {
		// 使用了动态规划的思想。。避免重复判断
		List<Integer> list = new ArrayList<>();
		while (n != 1) {
			if (list.contains(n)) {
				return false;
			}
			list.add(n);
			n = toArrayAndSum(n);
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(toArrayAndSum(7));
		System.out.println(isHappy(7));
	}

	public static int toArrayAndSum(int n) {
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		while (n > 0) {
			int x = n % 10;
			list.add(x);
			n = n / 10;
			sum = sum + x * x;
		}
		return sum;
	}
}
