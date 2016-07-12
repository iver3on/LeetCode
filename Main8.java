package nowcodehuawei;

import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// while (sc.hasNext()) {
		// String s1 = sc.nextLine();
		// String s2 = sc.nextLine();
		String s1 = "ABCD";
		String s2 = "D?BEAB?DCD";
		int l1 = s1.length();
		int l2 = s2.length();
		int i = 0, j = 0;
		while (i < l1 && j < l2) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else if (s2.charAt(j) == '?') {
				i++;
				j++;
			} else {
				if (i != 0) {
					i = 0;
				}
				j++;
			}
		}
		if (i == 0) {
			System.out.println("NO");
		} else if (i == s1.length()) {
			System.out.println(j - s1.length() );
		}
	}
}
