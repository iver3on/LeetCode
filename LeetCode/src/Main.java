import java.util.Arrays;
import java.util.Scanner;

/*
 * 10个学生考完期末考试评卷完成后，A老师需要划出及格线，要求如下：
(1) 及格线是10的倍数；
(2) 保证至少有60%的学生及格；
(3) 如果所有的学生都高于60分，则及格线为60分：

输入10个整数，取值0~100
输出:	
输出及格线，10的倍数
 * 
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] score = new int[10];
		for(int i=0;i<10;i++){
			score[i] = Integer.parseInt(s.split(" ")[i]);
		}
		System.out.println(getAverage(score));
	}
	
	public static int getAverage(int[] a){
		Arrays.sort(a);
		if(a[0]>=60) return 60;
		else return (a[4]/10)*10;
	}
}
