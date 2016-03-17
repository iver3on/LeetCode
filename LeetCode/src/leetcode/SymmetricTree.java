/**
 * leetcode101
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Iver3oN Zhang
 * @date 2016年3月17日
 * @email grepzwb@qq.com SymmetricTree.java Impossible is nothing
 */

public class SymmetricTree {

	// Definition for a binary tree node.
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 使用递归方式
	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (isSymmetricRecursive(root.left, root.right)) {
			return true;
		}
		return false;
	}

	/**
	 * @param left
	 * @param right
	 * @return
	 */
	private static boolean isSymmetricRecursive(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return left == right;
		}
		if (left.val != right.val)
			return false;
		return isSymmetricRecursive(left.left, right.right)
				&& isSymmetricRecursive(left.right, right.left);
	}

	private static boolean isSymmetricNonRecursive(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode left, right;
		if (root.left != null) {
			if (root.right == null)
				return false;
			stack.push(root.left);
			stack.push(root.right);
		} else if (root.right != null) {
			return false;
		}

		while (!stack.empty()) {
			if (stack.size() % 2 != 0)
				return false;
			right = stack.pop();
			left = stack.pop();
			if (right.val != left.val)
				return false;

			if (left.left != null) {
				if (right.right == null)
					return false;
				stack.push(left.left);
				stack.push(right.right);
			} else if (right.right != null) {
				return false;
			}
			if (left.right != null) {
				if (right.left == null)
					return false;
				stack.push(left.right);
				stack.push(right.left);
			} else if (right.left != null) {
				return false;
			}
		}
		return true;
	}

	//广度优先 遍历
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> listElement = new ArrayList<>();
		queue.offer(root);	
		if (root==null) {
			return list;
		}
		listElement.add(root.val);		
		list.add(listElement);
		while (!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			int  elementNumber = queue.size();
			for(int i=0;i<elementNumber;i++){
				if (queue.peek().left != null) {
					queue.offer(queue.peek().left);
					temp.add(queue.peek().left.val);
				}
				if (queue.peek().right != null) {
					queue.offer(queue.peek().right);
					temp.add(queue.peek().right.val);
				}
				queue.poll();
			}
			if(temp.size()>0)list.add(0,temp);
		}
		return list;
	}
	
	//深度优先遍历
	public static List<List<Integer>> levelOrderBottomDepth(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> listElement = new ArrayList<>();
		stack.push(root);
		int depth = 0;
		if (root==null) {
			return list;
		}
		listElement.add(root.val);		
		list.add(listElement);
		while(!stack.isEmpty()){
			root = stack.peek();
			stack.pop();
			depth++;
			System.out.println(root.val);
			if(root.right!=null){
				stack.push(root.right);
			}
			//先左 在栈顶
			if(root.left!=null){
				stack.push(root.left);
			}
		}
		return list;
	}
	 public static List<List<Integer>> levelOrderBottom1(TreeNode root) {
         List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
         levelMaker(wrapList, root, 0);
         return wrapList;
     }
	 public static void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
         if(root == null) return;
         if(level >= list.size()) {
             list.add(0, new LinkedList<Integer>());
         }
         levelMaker(list, root.left, level+1);
         levelMaker(list, root.right, level+1);
         list.get(list.size()-level-1).add(root.val);
     }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(3);
		TreeNode node7 = new TreeNode(4);
		node1.left = node2;
		node1.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node7;
		node3.right = node6;
		System.out.println(isSymmetric(node1));
		System.out.println(levelOrderBottom(node1));
		System.out.println(levelOrderBottom1(node1));
	}

}
