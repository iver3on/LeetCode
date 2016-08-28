/**
 * 
 */
package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Iver3on
 * @date 2016年8月28日
 */
public class IntersectionofTwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 ={9,3,7};
		int[] a2 = {6,4,1,0,0,4,4,8,7};
		int[] inter = intersection(a1,a2);
		for(int i=0;i<inter.length;i++){
			System.out.println(inter[i]);
		}
		System.out.println();
	}
	 public static int[] intersection(int[] nums1, int[] nums2) {
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        int l1 = nums1.length;
	        int l2 = nums2.length;
	        int[] r = new int[0];
	        if(l1==0||l2==0||nums1[l1-1]<nums2[0]||nums2[l2-1]<nums1[0]){
	        	return r;
	        }else{
	        	return getInter(nums1,nums2);
	        }
	        
	 }
	/**
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	private static int[] getInter(int[] nums1, int[] nums2) {
		int i = 0,j =0;
		Set<Integer> set = new HashSet<>();
		if(nums1[0]<nums2[0]){
			i = Arrays.binarySearch(nums1,nums2[0]);
			if(i<0){
				i = -i-1;
			}
			while(i<nums1.length&&j<nums2.length){
				if(nums1[i]==nums2[j]){
					set.add(nums1[i]);
					i++;
					j++;
				}else if(nums1[i]<nums2[j]){
					i++;
				}else{
					j++;
				}
			}
			
		}else{
			j = Arrays.binarySearch(nums2,nums1[0]);
			if(j<0){
				j = -j-1;
			}
			while(i<nums1.length&&j<nums2.length){
				if(nums1[i]==nums2[j]){
					set.add(nums1[i]);
					i++;
					j++;
				}else if(nums1[i]<nums2[j]){
					i++;
				}else{
					j++;
				}
			}
		}
		return SetToInt(set);
	}
	  // 将set集合转为整型int数组的方法  
    private static int[] SetToInt(Set<Integer> allSet) {  
        // 先将set集合转为Integer型数组  
        Integer[] temp = allSet.toArray(new Integer[] {});//关键语句  
  
        // 再将Integer型数组转为int型数组  
        int[] intArray = new int[temp.length];  
        for (int i = 0; i < temp.length; i++) {  
            intArray[i] = temp[i].intValue();  
        }  
        return intArray;  
    }  
}
