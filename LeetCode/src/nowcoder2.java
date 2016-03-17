import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class nowcoder2 {
/*明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤100），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
 * 按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。
 * 
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		//Random rn=new Random();
		int[] array = new int[num];
		List<Integer> list = new ArrayList<>();
		for(int i = 0;i<num;i++){
			int x = sc.nextInt();
			array[i] = x;
		}
		Arrays.sort(array);
		for(int i=0;i<array.length;i++) {
			if(!list.contains(array[i])){
				list.add(array[i]);
			}
		}
		for(int x:list){
			System.out.println(x);
		}
	}
}
