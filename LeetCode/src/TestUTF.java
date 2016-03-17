
public class TestUTF {
	/*首先，java中的一个char是2个字节。java采用unicode，2个字节来表示一个字符，这点与C语言中不同，
	 * C语言中采用ASCII，在大多数系统中，一个char通常占1个字节，但是在0~127整数之间的字符映射，unicode向下兼容ASCII。
	 * 而Java采用unicode来表示字符，一个中文或英文字符的unicode编码都占2个字节，但如果采用其他编码方式，
	 * 一个字符占用的字节数则各不相同。
	 * 在 GB 2312 编码或 GBK 编码中，一个英文字母字符存储需要1个字节，
	 * 一个汉字字符存储需要2个字节。 在UTF-8编码中，一个英文字母字符存储需要1个字节，
	 * 一个汉字字符储存需要3到4个字节。在UTF-16编码中，一个英文字母字符存储需要2个字节，
	 * 一个汉字字符储存需要3到4个字节（Unicode扩展区的一些汉字存储需要4个字节）。在UTF-32编码中，
	 * 世界上任何字符的存储都需要4个字节。
	 */

	public static void main(String[] args) {
	String s = "你好hello";
	 System.out.println("系统默认编码方式：" + System.getProperty("file.encoding"));  
	 //在UTF-8编码中，一个英文字母字符存储需要1个字节，一个汉字字符储存需要3到4个字节
	System.out.println("字符长度："+s.length());
	System.out.println("字节长度："+s.getBytes().length);
	}

}
