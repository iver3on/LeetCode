package nowcodehuawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//输入一个字符串，求出该字符串包含的字符集合
public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			char[] c = s.toCharArray();
			// StringBuffer sb = new StringBuffer();
			List<Character> list = new ArrayList<>();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < c.length; i++) {
				if (!list.contains(c[i])) {
					list.add(c[i]);
					sb.append(c[i]);
				}
			}
			System.out.println(sb);
		}

	}

}
