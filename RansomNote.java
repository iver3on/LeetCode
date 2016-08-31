/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Iver3on
 * @date 2016年8月31日
 */
public class RansomNote {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canConstruct("aa","ab"));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		char[] ransom = ransomNote.toCharArray();
		List<Character> l = stringToList(magazine);
		for(int i=0;i<ransom.length;i++){
			if(l.contains(ransom[i])){
				System.out.println(ransom[i]);
				//l.remove((Object)(ransom[i]));
				l.remove(ransom[i]);
			}else{
				return false;
			}
		}
		return true;
	}
	public static List<Character> stringToList(String s){
		List<Character> l = new ArrayList<>();
		char[] ransom = s.toCharArray();
		for(int i = 0;i<ransom.length;i++){
			l.add(ransom[i]);
		}
		return l;
	} 
}
