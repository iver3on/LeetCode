import java.util.Arrays;



public class leetcode242 {
/*Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
 */
	public static void main(String[] args) {
		System.out.println(isAnagram("", ""));

	}
	public static boolean isAnagram(String s, String t) {
		 char[] schar = s.toCharArray();
         char[] tchar = t.toCharArray();
         Arrays.sort(schar);
         Arrays.sort(tchar);
         String s1 = new String(schar);
         String s2 = new String(tchar);
         if(s1.equals(s2)){
             return true;
         }else
         return false;
	}
	

	public static boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length()){
        	return false;
        }
        if(s.length()==0){
        	return true;
        }
		char[] c = s.toCharArray();
        char[] c1 = t.toCharArray();
		//List<Integer> list = new ArrayList<>();
		for(int i=0;i<c.length;i++){
			for(int j = 0;j<c1.length;j++){
				if(c1[j]==c[i]){
					c1[j]='*';
					break;
				}
			}
		}
		System.out.println(c1);
		boolean result = true;
		for(int i =0;i<c1.length;i++){
			if(c1[i]!='*'){
				result = false;
				break;
			}
		}
		return result;
    }
}
