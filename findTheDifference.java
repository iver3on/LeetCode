/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Iver3on
 * @date 2016年8月29日
 */
public class findTheDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcd";
		String s1 = "abcde";
		System.out.println(findTheDifference(s, s1));
	}
	public static char findTheDifference(String s, String t) {
		char[] ct = t.toCharArray();
        char[] cs = s.toCharArray();
        Arrays.sort(ct);
        Arrays.sort(cs);
        for(int i=0;i<cs.length;i++){
        	if(cs[i]!=ct[i]){
        		return ct[i];
        	}
        }
        return ct[ct.length-1];
		
	}
	public static char findTheDifference1(String s, String t) {
        char[] ct = t.toCharArray();
        char[] cs = s.toCharArray();
        char c = ' ';
        for(int i=0;i<ct.length;i++){
        	if(!isExit(cs, ct[i])){
        		c =  ct[i];
        		break;
        	}
        }
		return c;
    }

	public static boolean isExit(char[] c,char c1){
		for(char x:c){
			if(x==c1){
				return true;
			}
		}
		return false;
	}	
}
