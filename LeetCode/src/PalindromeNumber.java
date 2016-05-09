/**Determine whether an integer is a palindrome. Do this without extra space.
 * Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
 */
package net.zwb;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com
 * 2016年5月6日
 */
public class PalindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 31213;
		System.out.println(isPalindrome(x));
	}
	
	//不应该使用额外的空间 判断一个整数是不是回文  对称
	 public static boolean isPalindrome(int x) {
		if(x<0||(x!=0&&x%10==0))return false;
		int sum = 0;
		while(x>sum){
			sum = sum*10 + x%10;
			x = x/10;
		} 
		return (x==sum)||(x==sum/10);        
	 }
}
