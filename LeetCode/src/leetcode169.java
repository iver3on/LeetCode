import java.util.Arrays;

/*
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element 
 always exist in the array.
 */
public class leetcode169 {

	public static void main(String[] args) {
		int nums[] = {3,2,3};
		Arrays.sort(nums);
		/*
		 * for(int i=0;i<nums.length;i++){ System.out.println(nums[i]); }
		 */
		System.out.println(majorityElement(nums));

	}

	public static int majorityElement(int[] nums) {
		double length = nums.length;
		int x = (int) Math.floor(length / 2);
		int temp = 0;
		int sum = 0;
		if (nums.length == 1) {
			return nums[0];
		} else {
			a: for (int i = 0; i < nums.length; i++) {
				if (sum > x) {
					temp = nums[i];
					break;
				}else
					sum = 1;
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] == nums[j]) {
						sum++;
					} else {
						if (sum > x) {
							temp = nums[i];
							// sum1 = sum;
							break a;
						}else{
							i = j-1;
							break;
						}
						
					}
				}
			}
		}
		return temp;
	}

}
