/**
 * 
 */
package net.zwb;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com
 * 2016��5��5��
 */
public class PascalTriangle {

	 public List<List<Integer>> generate(int numRows) {
		 List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		 List<Integer> list = new ArrayList<Integer>();
		 for(int i =0;i<numRows;i++){
			 list.add(0, 1);
			 //1 1 1 
			 //add(0,1)������0���Ԫ��  ����Ԫ������
			 for(int j = 1;j<list.size()-1;j++){
				 list.set(j,list.get(j)+list.get(j+1));
			 }
			resultList.add(new ArrayList<Integer>(list));
			//���ַ�ʽ�Ļ� ÿ��list�ı䣬resultList�е�����Ҳ��֮�ı䡣�൱�ڰ���һ������
			 // resultList.add(list);
		 }
		 return resultList;
	 }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangle p = new PascalTriangle();
		List<List<Integer>> x = p.generate(5);
		System.out.println(x.toString());
		 List<Integer> list = new ArrayList<>();
		 int y = 6;
		 list.add(y);
		 y = 9;
		 System.out.println(list.toString());
		/* list.add(0, 1);
		 list.add(0,2);
		 list.add(0,99);
		 System.out.println(list.toString());*/
		
	}

}
