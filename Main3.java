package nowcodehuawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 字符串变换最小费用

描述：给出2个字串A，B，将A字串转化为B字串。转换一共有两种方式 
删除连续的n个字符，一次操作费用为2，增加连续的m个字符（增加的字符是什么由你决定），一次操作费用为m+2，求把A变为B最小费用。 
时间限制：无限制 
运行限制：无限制 
输入：第一行输入一个正整数T（1<=T<=10），表示有T组测试数据。 
对于每组测试数据，两行字符串A，B（字符串长度不要超过2000，字符仅包含小写字母） 
输出： 对于每组测试数据，输出一行一个整数，表示最小费用。 
样例输入： 
2 
dsafsadfadf 
fdfd 
aaaaaaaa 
bbbbbbbb 
样例输出： 
7 
12

提示：‘dsafsadfadf ’变成‘fdfd’最少的代价的一种方法是： 
1、‘dsafsadfadf’->’f’ 删除连续的10个，代价2 
2、‘f’->‘fdfd’增加连续的3个（‘dfd’），代价为3+2=5 
总共的最小代价为2+5=7，其他方法都不小于7

‘aaaaaaaa’变成‘bbbbbbbb’ 
将前面字符串全部删除，代价为2，增加3个连续的b，代价为10，则总代价为12
 * 
 * 
 */
public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			sc.nextLine();
			List<String[]> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String[] s = new String[2];
				s[0] = sc.nextLine();
				s[1] = sc.nextLine();
				list.add(s);
			}
			for (String[] s : list) {
				getValue(s);
			}
		}

	}

	private static void getValue(String[] s) {
		String s1 = s[0];
		String s2 = s[1];

		char[] sa = s1.toCharArray();
		char[] sb = s2.toCharArray();
		int length1 = sa.length;
		int length2 = sa.length;
		if (length1 > length2) {

		}

		if (sa[sa.length - 1] == sb[0]) {
			int value = 0;
			value = 2;
			value = value + sb.length - 1 + 2;
			System.out.println(value);
		} else {
			int value1 = 0;
			value1 = 2;
			value1 = value1 + sb.length + 2;
			System.out.println(value1);
		}

	}
}
