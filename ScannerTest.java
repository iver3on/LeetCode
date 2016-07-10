package nowcodehuawei;

import java.util.Scanner;
import java.util.regex.Pattern;
//构造方法(常用的三个)  
//Scanner(File source)  
//Scanner(InputStream source)  
//Scanner(String source)  

//对比两种方式的比较  
//Scanner sc=new Scanner(System.in);   
//BufferedReader br=new BufferedReader(new InputStreamReader(System.in))   

//方法  
//useDelimiter(Pattern pattern)改变token的分割方式,默认的是空格,传Pattern对象  
//useDelimiter(String pattern)改变token的分割方式,默认的是空格,传String  

//hasNext();查看是否有token的分割段  
//hasNextInt();查看是否有int类型的token的分割段  
//nextInt();返回下一个int的数值  
//nextLine();返回一行  

//hasNext(Pattern pattern);返回下一个pattern类型的token  

//结果：  
//1.1  
//5.3  
//7.5
public class ScannerTest {
	public static void main(String[] args) {
		String str = "1.1 22.2 s 4 5.3 6 7.5 8 9";
		Scanner scanner = new Scanner(str);
		// scanner.useDelimiter("\\.");
		while (scanner.hasNext()) {
			if (scanner.hasNext(Pattern.compile("\\d\\.\\d"))) {
				System.out.println(scanner.next());
			} else {
				scanner.next();// 要调用一下next()相关的方法才会到下一个token
			}
		}
	}

}
