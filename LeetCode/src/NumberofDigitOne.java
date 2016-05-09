/**
 * 
 */
package net.zwb;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com
 * 2016年5月6日
 */
public class NumberofDigitOne {

	//谨防溢出
	//每10 个数有1个个位是1  每100个数 有1个十位是1 有10个个位是1  1000个数有1个百位是1 有	
//	以算百位上1为例子:   假设百位上是0, 1, 和 >=2 三种情况: 
//case 1: n=3141092, a= 31410, b=92. 计算百位上1的个数应该为 3141 *100 次.
//case 2: n=3141192, a= 31411, b=92. 计算百位上1的个数应该为 3141 *100 + (92+1) 次. 
//case 3: n=3141592, a= 31415, b=92. 计算百位上1的个数应该为 (3141+1) *100 次. 
//以上三种情况可以用 一个公式概括:
//(a + 8) / 10 * m + (a % 10 == 1) * (b + 1);
	public static int countDigitOne(int n) { 
        int count = 0;
		for(long i=1;i<=n;i = i*10){
			long a = n/i;
			long b = n%i;
			count+=(a+8)/10*i;
			if(a%10==1) count+=b+1;
        }
		return count;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countDigitOne(121));
	}

}
