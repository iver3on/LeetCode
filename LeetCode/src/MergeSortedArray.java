/**
 * 
 */
package net.zwb;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com 2016年5月11日
 */
public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,3,5,6};
		int[] nums2 = {2,4,7,9,10};
		merge(nums1,4, nums2, 5);
		for(int x:nums1){
			System.out.println(x);
		}
		
	}

	//归并 算法的思想
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		/*
		 * int i =0,j=0; while(i<nums1.length&&j<nums2.length){
		 * if(nums1[i]<nums2[j]){ nums[i] nums1[i++] = nums2[j++]; } }
		 */
		int k = m + n - 1;
		int i = m - 1;
		int j = n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[k] = nums1[i];
				i--;
				k--;
			} else {
				nums1[k] = nums2[j];
				j--;
				k--;
			}
		}
		while(j>=0)nums1[k--] = nums2[j--];
	}

}
