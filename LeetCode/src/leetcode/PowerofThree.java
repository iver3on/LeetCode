package leetcode;

//power of two 类似
public class PowerofThree {
	public static boolean isPowerOfThree(int n) {
		double x=0;
		if(n<=0){
			return false;
		}else{
			 x = Math.log10(n)/Math.log10(2);
		}
		System.out.println(x);
		if(x%1==0){
			return true;
		}else
			return false;
    }
	
	public static boolean isPowerOfThree1(int n) {
		return (n>0&&1162261467%n==0);
    }
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(16));
		System.out.println((-1)%9);
		System.out.println(Math.pow(3, 19));
	}
}
