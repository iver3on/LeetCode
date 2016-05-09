/**
 * 
 */
package net.zwb;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com
 * 2016��5��6��
 */
public class NumberofDigitOne {

	//�������
	//ÿ10 ������1����λ��1  ÿ100���� ��1��ʮλ��1 ��10����λ��1  1000������1����λ��1 ��	
//	�����λ��1Ϊ����:   �����λ����0, 1, �� >=2 �������: 
//case 1: n=3141092, a= 31410, b=92. �����λ��1�ĸ���Ӧ��Ϊ 3141 *100 ��.
//case 2: n=3141192, a= 31411, b=92. �����λ��1�ĸ���Ӧ��Ϊ 3141 *100 + (92+1) ��. 
//case 3: n=3141592, a= 31415, b=92. �����λ��1�ĸ���Ӧ��Ϊ (3141+1) *100 ��. 
//����������������� һ����ʽ����:
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
