public class RomantoInteger {

	public static void main(String[] args) {
			System.out.println(romanToInt1("MCMLXXVI"));
			//1976 2176
			//"MCDLXXVI" 1476 
			//我的是1676
	}
	/*相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；
小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；
小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9；
在一个数的上面画一条横线，表示这个数增值 1,000 倍，如=5000。
基本数字 Ⅰ、X 、C 中的任何一个、自身连用构成数目、或者放在大数的右边连用构成数目、都不能超过三个；放在大数的左边只能用一个；
不能把基本数字 V 、L 、D 中的任何一个作为小数放在大数的左边采用相减的方法构成数目；放在大数的右边采用相加的方式构成数目、只能使用一个；
V 和 X 左边的小数字只能用 Ⅰ；
L 和 C 左边的小数字只能用X；
D 和 M 左边的小数字只能用 C。
*/
	//XXXIX－39
	public static int getVal(char c) {
		int val = 0;
		switch (c) {
		case 'I':
			val=1;
			break;
		case 'X':
			val=10;
			break;
		case 'C':
			val=100;
			break;
		case 'M':
			val=1000;
			break;
		case 'V':
			val=5;
			break;
		case 'L':
			val=50;
			break;
		case 'D':
			val=500;
			break;
		default:
			break;
		}
		return val;
	}

	public static int romanToInt(String s) {
		int sum = 0;
		for(int i =s.length()-1;i>=0;i--){
			if(i==0){
				sum = sum+getVal(s.charAt(0));
				return sum;
			}
			char c1 = s.charAt(i);
			char c2 = s.charAt(i-1);
			int n1 = getVal(c1);
			int n2 = getVal(c2);
			if(n1<n2){
				sum =sum-n1; 
			}else{
				sum =sum+n1;
			}
			i = i-1;
		}
		return sum;
	}
	
	public static int romanToInt1(String s) {
		int sum = 0;
		for(int i =0;i<s.length();i++){
			if(i==s.length()-1){
				return sum+getVal(s.charAt(i));
			}
			char c1 = s.charAt(i);
			char c2 = s.charAt(i+1);
			int n1 = getVal(c1);
			int n2 = getVal(c2);
			if(n1<n2){
				sum =sum-n1; 
			}else{
				sum =sum+n1;
			}
		}
		return sum;
	}

}