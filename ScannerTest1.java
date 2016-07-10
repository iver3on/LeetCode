package nowcodehuawei;

import java.util.Scanner;

public class ScannerTest1 {

	public static void main(String[] args) {
		String str = "1.2 s.4 5 6.7 8 9";
		Scanner scanner = new Scanner(str);
		// token“‘.∑÷∏Ó
		// scanner.useDelimiter("\\.");
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
	}
}
