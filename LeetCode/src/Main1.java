import java.util.Scanner;

/*һ������������װ��n(1 �� n �� 65535)յ��ƣ���ͷ��β���1��2��3����n-1��n��ÿյ�����һ�����߿��ؿ��ơ�
 * ��ʼ�����ȫ�����š�
��n��ѧ���ӳ��ȴ�������һ��ѧ���Ѻ��뷲��1�ı����ĵ�ƵĿ�����һ�£����ŵڶ���ѧ���Ѻ��뷲��2�ı����ĵ�ƵĿ�����һ�£�
���ŵ�����ѧ���Ѻ��뷲��3�ı����ĵ�ƵĿ�����һ�£���˼�����ȥ������n��ѧ���Ѻ��뷲��n�ı����ĵ�ƵĿ�����һ�¡�
n��ѧ�����˹涨����󣬳��������м�յ���š�
ע���������ѧ����һ�¡�
 */
public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int light = sc.nextInt();
		System.out.println(getNumber(light));
	}

	private static int getNumber(int light) {
		int count = 0;
		for(int i=1;i<=light;i++){
			int count1 = 0;
			for(int j=1;j<=i;j++){	
				if(i%j==0){
					count1++;
				}	
			}
			if(count1%2!=0){
				count++;
			}	
		}
		return count;	
	}
}
