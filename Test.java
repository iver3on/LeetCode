package nowcodehuawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// s = where there is a will,there is a way. Where
		while (sc.hasNext()) {
			String s = sc.nextLine();
			if (s.length() >= 200)
				return;
			char[] ca = s.toCharArray();
			for (int i = 0; i < ca.length; i++) {
				if (!(Character.isLetter(ca[i]) || ca[i] == ' ' || Character.isDigit(ca[i]))) {
					ca[i] = ' ';
				} else
					continue;
			}
			String ns = new String(ca);
			String[] sa = ns.split(" ");
			List<String> list = new ArrayList<>();
			for (int i = 0; i < sa.length; i++) {
				if (list.contains(sa[i])) {
					continue;
				} else
					list.add(sa[i]);
			}
			StringBuffer sb = new StringBuffer();
			for (String ss : list) {
				sb.append(ss + " ");
			}
			System.out.println(sb.substring(0, sb.length() - 1));
		}
	}
}
