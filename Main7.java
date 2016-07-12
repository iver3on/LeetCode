package nowcodehuawei;

import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int m = sc.nextInt();
			int n = sc.nextInt();
			int sum = 0;
			int temp = 0;
			int x = 0;
			for(int i=0;i<n;i++){	
				temp = 10*sum;
				sum = m+temp;	
				x = x+sum;
			}
			System.out.println(x);
			System.out.println(5+55+555+5555+55555);
		}
	}

}
