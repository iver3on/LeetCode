
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
	public static void main(String[] args) {
		int[][] arr=new int[3][3];
		int a=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				arr[i][j]=a;
				a++;
			}
		}
		reversarr(arr);	
	}
	private static void reversarr(int[][] arr) {
		int[][] newarr=new int[3][3];
		List<int[]> list = new ArrayList<int[]>();	
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				newarr[i][j]=arr[j][i];
			}			
		}
		for(int i=0;i<3;i++){
			list.add(newarr[i]);		
		}
		for(int i =0;i<3;i++){
			for(int j=0;j<3;j++){
				
			System.out.print(list.get(i)[j]);
			}
		}
		System.out.println("----------");
		int[][] newarr1=new int[3][3];
		for(int i=0;i<3;i++){
			for(int j = 0;j<=2;j++){
				newarr1[i][j]=list.get(i)[2-j];	
				System.out.print(list.get(i)[2-j]);
			}			
		}
		System.out.println();
		for(int i=0;i<3;i++){
			for(int j = 0;j<3;j++){
				System.out.print(newarr1[i][j]);				
			}
			System.out.println();
		}
	}
}