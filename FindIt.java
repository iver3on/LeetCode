package nowcodehuawei;

import java.util.Scanner;

/*
 * ��һ���ַ����еĴ�д��ĸ�ҳ���ԭ�пո���������ԭ�и�ʽ��������ԭ�ַ���������������д��ĸ���������������ϵĿո���һ�������

����������AUStralia;

���������AUS

����������He Is a DoG

���������H I  DG
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
