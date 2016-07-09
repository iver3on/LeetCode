/*
 * M����ͬƻ���ŵ�N����ͬ�������ж����ַŷ�,���������Ӳ��š�
1<=M<=10��1<=N<=10
����5��ƻ���������ӣ�3��1��1 �� 1,1,3��ͬһ�ַŷ�
���� 7 3
��� 8
 * �ٵ�ƻ����Ŀ����������ĿΪ1ʱ�򣬾�ֻ��һ�ֿ���
�ڵ�ƻ����ĿС��������Ŀ��ʱ�򣬰���ƻ����Ŀ������
�۵�ƻ����Ŀ����������Ŀ��ʱ�򣬿�һ������ + ��ÿ�����ӷ�һ��֮����m-n������
�۵�ƻ����Ŀ����������Ŀ��ʱ��ÿ�����ӷ�һ�� + ��һ������
 */
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.out.println(solution(4, 3));
		System.out.println(countDay(2013, 12, 31));
	}

	public static int solution(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		if (m < n)
			return solution(m, m);
		if (m > n)
			return solution(m, n - 1) + solution(m - n, n);
		if (m == n)
			return 1 + solution(m, n - 1);
		return 0;
	}

	//������һ��ĵڶ�����  �ж��������Ҫ
	public static int countDay(int year, int month, int day) {
		int flag = 0;
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
			flag = 1;
		int cnt = 0;
		for (int i = 1; i < month; i++) {
			switch (i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
				cnt += 31;
				break;
			case 2:
				cnt += 28 + flag;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				cnt += 30;
				break;
			}
		}

		cnt += day;
		return cnt;
	}
}
