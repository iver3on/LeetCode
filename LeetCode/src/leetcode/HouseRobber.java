/**
 * 类似斐波那契数列。。需要动态规划。。还是挺蛋疼的。
 */
package leetcode;

/**
 * @author Iver3oN Zhang
 * @date 2016年3月16日
 * @email grepzwb@qq.com
 * HouseRobber.java
 * Impossible is nothing
 */
public class HouseRobber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {5,9,5,2,1,5,6};
		// TODO Auto-generated method stub
		System.out.println(rob(nums));
		System.out.println(rob1(nums));
	}
	 public static int rob(int[] nums) {
		 //sum1是没有选择当前的房子的最大价值 sum2是选择当前的房子的最大价值
		 int sum1 = 0;int sum2 = 0;
		 for(int i =0;i<nums.length;i++){
			 int temp = sum1;
			 sum1 = Math.max(sum1, sum2);
			 sum2 = temp + nums[i];
		 }
		 return Math.max(sum1, sum2);
	    }
	 public static int rob1(int[] nums){
		 if(nums.length==0){
			 return 0;
		 }
		 if(nums.length==1){
			 return nums[0];
		 }
		 int[] dp = new int[nums.length];
		 //dp[i]表示到i位置时不相邻数能形成的最大和。
		 dp[0] = nums[0];
		 dp[1] = Math.max(nums[0], nums[1]);
		 
		 for(int i = 2;i<nums.length;i++){
			 dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
		 }
		 return dp[nums.length-1];
	 }
}
