/**
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
 */
package net.zwb;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com
 * 2016年5月6日
 */
public class PascalTriangleII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow(3).toString());
	}
	
	 public static List<Integer> getRow(int rowIndex) {
		 List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		 List<Integer> list = new ArrayList<Integer>();
		 for(int i =0;i<rowIndex+1;i++){
			 list.add(0, 1);
			 //1 1 1 
			 //add(0,1)相索引0添加元素  其余元素右移
			 for(int j = 1;j<list.size()-1;j++){
				 list.set(j,list.get(j)+list.get(j+1));
			 }
			resultList.add(new ArrayList<Integer>(list));
			//这种方式的话 每次list改变，resultList中的数据也随之改变。相当于绑定了一样。。
			 // resultList.add(list);
		 }
		 return resultList.get(rowIndex);
	}
	 
	 public List<List<Integer>> generate(int numRows) {
		 List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		 List<Integer> list = new ArrayList<Integer>();
		 for(int i =0;i<numRows;i++){
			 list.add(0, 1);
			 //1 1 1 
			 //add(0,1)相索引0添加元素  其余元素右移
			 for(int j = 1;j<list.size()-1;j++){
				 list.set(j,list.get(j)+list.get(j+1));
			 }
			resultList.add(new ArrayList<Integer>(list));
			//这种方式的话 每次list改变，resultList中的数据也随之改变。相当于绑定了一样。。
			 // resultList.add(list);
		 }
		 return resultList;
	 }

}
