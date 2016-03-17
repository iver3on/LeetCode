package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static int climbStairs(int n) {
		if (map.containsKey(n))
			return map.get(n);
		if (n == 1 || n == 2) {
			return n;
		}
		//DP 动态规划
		int other = climbStairs(n - 1) + climbStairs(n - 2);
		map.put(n, other);
		return other;
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(44));
	}
}
