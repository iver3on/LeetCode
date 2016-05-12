/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices
 * i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
package net.zwb;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com 2016年5月12日 滑动窗口 窗口长度最大是i-j+1
 */
public class ContainsDuplicateII {

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length <= 0 || k <= 0) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
				System.out.println(nums[i]);
				return true;
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}

	// Given an array of integers, find out whether there are two distinct
	// indices i and j in the array such
	// that the difference between nums[i] and nums[j] is
	// at most t and the difference between i and j is at most k.
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length <= 0 || k <= 0) {
			return false;
		}
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			if (set.floor(val) != null && (set.floor(val) + t) >= val)
				return true;
			if (set.ceiling(val) != null && (set.ceiling(val) - t) <= val)
				return true;
			set.add(val);
			if (i >= k)
				set.remove(nums[i - k]);
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 5, 3,2,4,7 };
		System.out.println(containsNearbyDuplicate(nums, 1));
		System.out.println(containsNearbyAlmostDuplicate(nums, 2, 2));
	}

}
