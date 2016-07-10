package nowcodehuawei;

import java.util.Scanner;

/*
 * 将一串字符串中的大写字母找出，原有空格保留，并按原有格式输出，如果原字符串中相邻两个大写字母有两个或两个以上的空格按照一个输出。

输入样例：AUStralia;

输出样例：AUS

输入样例：He Is a DoG

输出样例：H I  DG
 */
public class FindIt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] c = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		boolean tag = false;
		boolean tag1 = false;
		for (int i = 0; i < c.length; i++) {
			if (c[i] >= 'A' && c[i] <= 'Z') {
				sb.append(c[i]);
				tag = true;
			} else if (c[i] == ' ' && tag1) {
				sb.append(' ');
				tag1 = true;
			} else {
				continue;
			}

		}
		System.out.println(sb);
	}

}
