package nowcodehuawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * �ַ����任��С����

����������2���ִ�A��B����A�ִ�ת��ΪB�ִ���ת��һ�������ַ�ʽ 
ɾ��������n���ַ���һ�β�������Ϊ2������������m���ַ������ӵ��ַ���ʲô�����������һ�β�������Ϊm+2�����A��ΪB��С���á� 
ʱ�����ƣ������� 
�������ƣ������� 
���룺��һ������һ��������T��1<=T<=10������ʾ��T��������ݡ� 
����ÿ��������ݣ������ַ���A��B���ַ������Ȳ�Ҫ����2000���ַ�������Сд��ĸ�� 
����� ����ÿ��������ݣ����һ��һ����������ʾ��С���á� 
�������룺 
2 
dsafsadfadf 
fdfd 
aaaaaaaa 
bbbbbbbb 
��������� 
7 
12

��ʾ����dsafsadfadf ����ɡ�fdfd�����ٵĴ��۵�һ�ַ����ǣ� 
1����dsafsadfadf��->��f�� ɾ��������10��������2 
2����f��->��fdfd������������3������dfd����������Ϊ3+2=5 
�ܹ�����С����Ϊ2+5=7��������������С��7

��aaaaaaaa����ɡ�bbbbbbbb�� 
��ǰ���ַ���ȫ��ɾ��������Ϊ2������3��������b������Ϊ10�����ܴ���Ϊ12
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
