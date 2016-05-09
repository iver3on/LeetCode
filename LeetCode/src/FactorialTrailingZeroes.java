/**
 * 
 */
package net.zwb;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com 2016��5��6��
 */
public class FactorialTrailingZeroes {

	public static int trailingZeroes(int n) {
		int count = 0;
		int base = 5;
		while (n >= base) {
			int numOfFive = n / base;
			count = count + numOfFive;
			base = base * 5;
			// �����ں��ж��5���ӵ���
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
