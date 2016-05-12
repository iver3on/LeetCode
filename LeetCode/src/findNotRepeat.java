/**
 * ����Ͱ������� Ҫ��O(N)ʱ�临�Ӷȡ��������Կռ任ʱ��
 * ����a b b a c d�ҳ����ظ��ĵ�һ���ַ���ʱ�临�Ӷ�O(n) 
 */
package net.zwb;

import java.util.HashMap;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com
 * 2016��5��12��
 */
public class findNotRepeat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c = {'a','b','b','a','c','d'};
		int[] nums = {1,2,3,3,3,3,3,5,5};
		System.out.println(getChar(c));
		System.out.println(findIndex(nums, 1));
	}
//	
//	����ֱ�۵��뷨�Ǵ�ͷ��ʼɨ������ַ����е�ÿ���ַ��������ʵ�ĳ�ַ�ʱ������ַ��ͺ����ÿ���ַ���Ƚϣ�
//	 ����ں���û�з����ظ����ַ�������ַ�����ֻ����һ�ε��ַ�������ַ�����n���ַ���ÿ���ַ�����������O(n)���ַ���Ƚϣ�
//	 �������˼·��ʱ�临�Ӷ���O(n2)�����ǲ�����Ҫ��
//	 ��1����һ��ɨ���ַ���ʱ��ÿɨ�赽һ���ַ����ڹ�ϣ��Ķ�Ӧ���аѴ�����1����ʱ��Ч��O(n)��
//
//	������2���ڶ���ɨ��ʱ��ÿɨ�赽һ���ַ����ܴӹ�ϣ���еõ����ַ����ֵĴ�����������һ��ֻ����һ�ε��ַ����Ƿ���Ҫ����������ʱ��Ч��O(n)��
//
//	�����������������ܵ�ʱ�临�Ӷ���Ȼ��O(n)����������ĿҪ�󣬲�һ��������̾����*װ�����е㼼����

	/**
	 * @param c
	 * @return
	 */
	private static char getChar(char[] c) {
		HashMap<Character, Integer> map = new HashMap<>();
		//O(N)
		for(int i=0;i<c.length;i++){
			if(map.containsKey(c[i])){
				map.put(c[i], map.get(c[i])+1);
			}else{
				map.put(c[i], 1);
			}
		}
		int i = 0;
		//o(n)  �ڶ��α��� �ҵ�Ϊ1�ε�  ���ؼ����ܵ�ʱ�临�Ӷ���ON
		while(i<c.length){
			if(map.get(c[i])==1){
				return c[i];
			}else
				i++;
		}
		return ' ';
	}
	//{1,4,5,7,8,10,10,13,14,14,16}
	
	//��һ��ֵ���������������һ�γ��ֵ�λ��  ���ֲ��ұ���
	//΢��2016ʵϰ�������⣺��Ŀ���ѣ���Ҫ��Ҫѧ������Թٹ�ͨ��ѯ�������ǽ��������� ���
	public static int findIndex(int[] nums,int a){
		int start = 0;
		int end = nums.length-1;
		int key= 0;
		while(start<=end){
			int mid = (start+end)/2;
			if(a>nums[mid]){
				start = mid+1;
			}else if(a<nums[mid]){
				end = mid-1;
			}else{
				while(mid<=end&&nums[mid]==a){
					mid++;
				}
				return mid -1 ;
			}
		}	
		return key;
	}
	
	//�������ǩ���ַ��� adh<ref>shakd</ref>ad  ������õ�adhad
	
	
	/*��Ŀ��:ȡһ������������k������Ҫ��ʱ�临�ӶȲ�����o(n),էһ��������ǲ��Ǻܼ򵥣�����Ҳ�кܶ�ӣ�
	����k�������Ҫ��Ҫ��������Щ��Ҫ��Ļ������򣬲�Ҫ��Ļ����ŵı��ν��,����㲻������Ŀ���������˼��
	������˼������д����ô����ֱ��gg.*/
	
}
