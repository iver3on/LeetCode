/**
 * 阿里巴巴面试题 要求O(N)时间复杂度。。可以以空间换时间
 * 比如a b b a c d找出不重复的第一个字符，时间复杂度O(n) 
 */
package net.zwb;

import java.util.HashMap;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com
 * 2016年5月12日
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
//	　最直观的想法是从头开始扫描这个字符串中的每个字符。当访问到某字符时拿这个字符和后面的每个字符相比较，
//	 如果在后面没有发现重复的字符，则该字符就是只出现一次的字符。如果字符串有n个字符，每个字符可能与后面的O(n)个字符相比较，
//	 因此这种思路的时间复杂度是O(n2)，但是不满足要求。
//	 （1）第一次扫描字符串时，每扫描到一个字符就在哈希表的对应项中把次数加1。（时间效率O(n)）
//
//	　　（2）第二次扫描时，每扫描到一个字符就能从哈希表中得到该字符出现的次数。这样第一个只出现一次的字符就是符合要求的输出。（时间效率O(n)）
//
//	　　这样算起来，总的时间复杂度仍然是O(n)，满足了题目要求，擦一擦汗，感叹：这*装得真有点技术！

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
		//o(n)  第二次遍历 找到为1次的  返回即可总的时间复杂度是ON
		while(i<c.length){
			if(map.get(c[i])==1){
				return c[i];
			}else
				i++;
		}
		return ' ';
	}
	//{1,4,5,7,8,10,10,13,14,14,16}
	
	//找一个值在有序数组中最后一次出现的位置  二分查找变形
	//微软2016实习生面试题：题目不难，主要是要学会和面试官沟通，询问数组是降序还是升序 如果
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
	
	//处理带标签的字符串 adh<ref>shakd</ref>ad  处理完得到adhad
	
	
	/*题目是:取一个数组中最大的k个数，要求时间复杂度不大于o(n),乍一看这道题是不是很简单，可是也有很多坑，
	比如k个最大数要不要求有序这些，要求的话堆排序，不要求的话快排的变形解决,如果你不问清题目，不理解意思，
	不好意思不管你写的怎么样，直接gg.*/
	
}
