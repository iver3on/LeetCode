import java.util.Arrays;
import java.util.Scanner;

/*
 * 10��ѧ��������ĩ����������ɺ�A��ʦ��Ҫ���������ߣ�Ҫ�����£�
(1) ��������10�ı�����
(2) ��֤������60%��ѧ������
(3) ������е�ѧ��������60�֣��򼰸���Ϊ60�֣�

����10��������ȡֵ0~100
���:	
��������ߣ�10�ı���
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
