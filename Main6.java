package nowcodehuawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * ����һ�����0С��1000���������Ҿ�����ͬ�����Ÿ�������������ܱ���Щ����������Ԫ����������ЩԪ�ء�

���������ʽҪ��

����Ҫ��ͬ�������������Ҫ������˳��������ʱ��˳�������

����

���룺2,4,6,8,10,12,3,9 
�����4,6,8,10,12,9
 * 
 * 
 */
public class Main6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int key = 0;
			String in = sc.nextLine();
			String[] ina = in.split(",");
			int[] a = new int[ina.length];
			for(int i=0;i<ina.length;i++){
				a[i] = Integer.parseInt(ina[i]);
			}
			int[] b = a;
			Arrays.sort(a);
			List<Integer> l = new ArrayList<>();
			for(int i=0;i<a.length;i++){
				int j = i-1;
				while(j>=0){
					if(a[i]%a[j]==0){
						l.add(a[i]);
						break;
						//System.out.println(a[i]);
					}else
						j--;
				}
			}
			for(int i=0;i<b.length;i++){		
				if(l.contains(b[i])){
					if(key==l.size()-1){
						System.out.print(b[i]);	
					}else{
						System.out.print(b[i]+",");
						key++;
					}					
				}
			}
		}	
	}

}
