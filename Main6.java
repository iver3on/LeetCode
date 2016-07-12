package nowcodehuawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 输入一组大于0小于1000的整数，且均不相同，逗号隔开，输出其中能被这些整数中其他元素整除的那些元素。

输入输出格式要求

输入要求同上述描述，输出要求整数顺序按照输入时的顺序输出。

样例

输入：2,4,6,8,10,12,3,9 
输出：4,6,8,10,12,9
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
