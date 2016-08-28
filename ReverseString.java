/**
 * 
 */
package leetcode;

/**
 * @author Iver3on
 * @date 2016Äê8ÔÂ28ÈÕ
 */
public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String reverseString(String s) {
        char[] c = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i=c.length-1;i>=0;i--){
        	sb.append(c[i]);
        }
        return sb.toString();
    }
}
