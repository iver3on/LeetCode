package nowcodehuawei;

import java.util.Scanner;
import java.util.regex.Pattern;
//���췽��(���õ�����)  
//Scanner(File source)  
//Scanner(InputStream source)  
//Scanner(String source)  

//�Ա����ַ�ʽ�ıȽ�  
//Scanner sc=new Scanner(System.in);   
//BufferedReader br=new BufferedReader(new InputStreamReader(System.in))   

//����  
//useDelimiter(Pattern pattern)�ı�token�ķָʽ,Ĭ�ϵ��ǿո�,��Pattern����  
//useDelimiter(String pattern)�ı�token�ķָʽ,Ĭ�ϵ��ǿո�,��String  

//hasNext();�鿴�Ƿ���token�ķָ��  
//hasNextInt();�鿴�Ƿ���int���͵�token�ķָ��  
//nextInt();������һ��int����ֵ  
//nextLine();����һ��  

//hasNext(Pattern pattern);������һ��pattern���͵�token  

//�����  
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
				scanner.next();// Ҫ����һ��next()��صķ����Żᵽ��һ��token
			}
		}
	}

}
