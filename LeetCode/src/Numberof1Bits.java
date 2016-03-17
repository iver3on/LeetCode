
public class Numberof1Bits {

	public static void main(String[] args) {
		System.out.println(hammingWeight(2147483647));
		System.out.println(getBin(2147483647));
	}

	// you need to treat n as an unsigned value 2147483648
	// (10000000000000000000000000000000)
	public static int hammingWeight(int n) {
		int num = getBin(n);
		return num;
	}

	// 10000 00000 00000 00000 00000 00000 00
	public static int getBin(int n) {
		int k = n;
		int m;
		int num = 0;
		if (n < 0) {
			n = n - 1;
			while (k != 0) {
				// n表示商 m表示余数
				m = (k % 2);
				k = k / 2;
				if (m == 1) {
					num++;
				}
			}
			return num;
		} else {
			while (k != 0) {
				// n表示商 m表示余数
				m = (int) (k % 2);
				k = k / 2;
				if (m == 1) {
					num++;
				}
			}
			return num;
		}
	}

}
