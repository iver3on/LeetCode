
/*Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:
	A-Z 65-90
	a-z 97-122
    A -> 1   65-64 asci码
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
Credits:
*/
public class leetcode171 {
    public static void main(String[] args) {
            System.out.print(titleToNumber1("AB"));
    }
    
    
    public static  int titleToNumber1(String s) {
        int len = s.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum=sum*26 + (s.charAt(i) - 'A'+1);
        }
        return sum;
    }
    public static int titleToNumber(String s){
        char[] schar = s.toCharArray();
        int length = s.length();
        double sum = 0;
        double y = 26;
        for(int i =schar.length-1;i>=0;i--){
            double x = length-1-i;
            sum = sum + getVal(schar[i])*Math.pow(y,x);
        }
        return (int)sum;
    }

    public static int getVal(char c){
        int val = c - 'A' +1;
        return val;
    }
}