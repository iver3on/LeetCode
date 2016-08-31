/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author Iver3on
 * @date 2016年8月29日
 */
public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 3, 2, 3, 4, 5, 5 };
		System.out.println(singleNumber(a));
	}

	public static int singleNumber(int[] nums) {
		if(nums.length==1){
			return nums[0];
		}
		Arrays.sort(nums);
		for(int i=0;i<nums.length-1;i = i+2){
			if(nums[i]==nums[i+1]){
				continue;
			}else{
				return nums[i];
			}
		}
		return nums[nums.length-1];
	}
	/*
	 * int singleNumber(int A[], int n) {
    int result = 0;
    for (int i = 0; i<n; i++)
    {
		result ^=A[i];
    }
	return result;
	*/
}
