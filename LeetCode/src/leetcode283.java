import java.util.Stack;

public class leetcode283 {

	
	/*
	 * Given an array nums, write a function to move all 0's to the end of it while maintaining 
	 * the relative order of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], 
after calling your function, nums should be [1, 3, 12, 0, 0].
	 */
	public static void main(String[] args) {
		//12 5 4 7 0 0
		int[] nums = { 12, 0, 5, 4, 0, 7 };
		moveZeroes(nums);
		for (int x : nums) {
			System.out.print(x + " ");
		}
	}

	public static void moveZeroes(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		for(int x:nums){
			if(x!=0){
				stack.push(x);
			}
		}
		while(stack.size()<nums.length){
			stack.push(0);
		}
		
		for(int i = nums.length-1;i>=0;i--){
			nums[i] = stack.pop();
		}
	}
}
