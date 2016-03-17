import java.util.HashSet;
import java.util.Set;


public class leetcode217 {

	public static void main(String[] args) {
		
	} 
	public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        if(set.size()<nums.length){
            return true;
        }
        return false;
    }

}
