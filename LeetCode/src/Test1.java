/*
 * M个相同苹果放到N个相同篮子里有多少种放法,允许有篮子不放。
1<=M<=10，1<=N<=10
例如5个苹果三个篮子，3，1，1 和 1,1,3是同一种放法
输入 7 3
输出 8
 * ①当苹果数目或者篮子数目为1时候，就只有一种可能
②当苹果数目小于篮子数目的时候，按照苹果数目来分配
③当苹果数目大于篮子数目的时候，空一个盘子 + 先每个盘子放一个之后再m-n个随便放
③当苹果数目等于篮子数目的时候，每个盘子放一个 + 空一个盘子
 */
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.out.println(solution(4, 3));
		System.out.println(countDay(2013, 12, 31));
	}

	public static int solution(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		if (m < n)
			return solution(m, m);
		if (m > n)
			return solution(m, n - 1) + solution(m - n, n);
		if (m == n)
			return 1 + solution(m, n - 1);
		return 0;
	}

	//计算这一年的第多少天  判断闰年很重要
	public static int countDay(int year, int month, int day) {
		int flag = 0;
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
			flag = 1;
		int cnt = 0;
		for (int i = 1; i < month; i++) {
			switch (i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
				cnt += 31;
				break;
			case 2:
				cnt += 28 + flag;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				cnt += 30;
				break;
			}
		}

		cnt += day;
		return cnt;
	}
}
