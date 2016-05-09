/**
 * 
 */
package net.zwb;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com 2016年5月6日
 */
public class FactorialTrailingZeroes {

	public static int trailingZeroes(int n) {
		int count = 0;
		int base = 5;
		while (n >= base) {
			int numOfFive = n / base;
			count = count + numOfFive;
			base = base * 5;
			// 不存在含有多个5因子的数
			if (base % 5 != 0)
				break;
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(trailingZeroes(50));
	}

}
