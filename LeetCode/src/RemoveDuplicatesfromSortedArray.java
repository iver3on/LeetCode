/**
 * 26Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.
 */
package net.zwb;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com 2016��5��5��
 */
public class RemoveDuplicatesfromSortedArray {

	public int removeDuplicates(int[] nums) {
		int i = 1; // iterator thru array
		int j = 0; // current index
		for (; i < nums.length; i++) {
			if (nums[i] != nums[j]) { // new number
				j++; // move current index
				nums[j] = nums[i]; // fill current index with new number
			}
		}
		return j + 1;
	}

	public int removeDuplicates1(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int i = 0;
		int j = 1;
		int k = nums.length;
		while (j < k) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];//����Ԫ��copy��nums[i]��i��ʱ�Ѿ�+1
			}
			j++;//�����ظ���Ԫ��
		}
		return j+1;
	}

	public void print(int[] a) {
		for (int x : a) {
			System.out.print(x + " ");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 1, 1};
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
		System.out.println(r.removeDuplicates(array));
		r.print(array);
	}

}
