/**
 * 
 */
package net.zwb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @author IVER3ON
 * @email grepzwb@qq.com
 * 2016年5月6日
 */

class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
}

public class BinaryTreeLevelOrderTraversal {

	
	 public static List<List<Integer>> levelOrder1(TreeNode root) {
		 List<List<Integer>> resultList = new ArrayList<>();
	     List<Integer> list = new ArrayList<>();
	     //Queue<TreeNode> queue = new LinkedList<TreeNode>();
	     if(root==null) return resultList;
	     List<TreeNode> list1 = new ArrayList<>();
	     list1.add(root);
	     int cur = 0,last = 1;
	     while(cur<list1.size()){
	    	 last = list1.size();
	    	 while(cur<last){
	    		 list.add(list1.get(cur).val);
	    		 if(list1.get(cur).left!=null){
	    			 list1.add(list1.get(cur).left);
	    		 }
	    		 if(list1.get(cur).right!=null){
	    			 list1.add(list1.get(cur).right);
	    		 }
	    		 ++cur;
	    	 }
	    	 resultList.add(list);
	    	 list = new ArrayList<>();
	     }
	     return resultList;
	 }
	
	 public static List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> resultList = new ArrayList<>();  
	        //计算深度
	        int depth = 0;
	        if(root==null) return resultList;
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        while(!queue.isEmpty()){
	        	//每层的结点数目
	        	int nodeNum = queue.size(); 
	        	List<Integer> list = new ArrayList<>();
	        	for(int i=0;i<nodeNum;i++){
	        		TreeNode node = queue.peek();
	        		if(node.left!=null) {
		        		queue.offer(node.left);
		        		//深度
		        		depth++;
		        	}
		        	if(node.right!=null){
		        		queue.offer(node.right);
		        	}
		        	list.add(queue.poll().val);
	        	}
	        	//for循环结束后，每层的元素就已经遍历完 并且存入了list
	        	resultList.add(list);
	        }
	        System.out.println(depth);
	        return resultList;
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		System.out.println(levelOrder(root));
	}

}
