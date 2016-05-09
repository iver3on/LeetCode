/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
 */
package net.zwb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com 2016年5月9日
 */
public class PathSum {

	/**
	 * @param args
	 */
	static int depth = 0;
	static List<TreeNode> list = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		/*
		 * TreeNode node3 = new TreeNode(15); TreeNode node4 = new TreeNode(7);
		 * TreeNode node5 = new TreeNode(2); TreeNode node6 = new TreeNode(11);
		 * TreeNode node7 = new TreeNode(34);
		 * 
		 * root.left = node1; root.right = node2; node1.left = node3; node2.left
		 * = node4; node2.right = node5; node4.left = node6; node6.left = node7;
		 */

		root.left = node1;
		node1.left = node2;

		// depthFirstSearch(root);
		// System.out.println(hasPathSum(root, 25));
		System.out.println(minDepth(root) + " " + maxDepth(root));
		System.out.println(isBalanced2(root));
	}

	public static boolean hasPathSum(TreeNode root, int sum) {

		// depth++;
		list.add(root);
		sum -= root.val;
		// 叶子节点
		if (root.left == null && root.right == null) {
			if (sum == 0) {
				for (TreeNode node : list) {
					System.out.println(node.val);
				}
				return true;

			}
		} else {
			if (root.left != null)
				if (hasPathSum(root.left, sum))
					return true;
			if (root.right != null)
				if (hasPathSum(root.right, sum))
					return true;
		}
		// 到达叶子节点 但是不满足sum==0则要加上减去的结点值
		sum += root.val;
		return false;
	}

	public static void depthFirstSearch(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode node;
		while (!stack.empty()) {
			node = stack.peek();
			System.out.print(node.val + " ");
			stack.pop();
			// 先push右子树
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	// 111. Minimum Depth of Binary Tree 递归方式
	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left != null && root.right != null) {
			return 1 + Math.min(minDepth(root.left), minDepth(root.right));
		} else {
			return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
		}
	}

	public static int minDepth2(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null)
			return minDepth(root.right) + 1;
		if (root.right == null)
			return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	// 111. max Depth of Binary Tree
	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	// iteratively, BFS 非递归方式
	public int minDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int depth = 1;
		while (!queue.isEmpty()) {
			int l = queue.size();
			for (int i = 0; i < l; i++) {
				TreeNode n = queue.poll();
				//返回最小深度 不用继续判断。。
				if (n.left == null && n.right == null) {
					return depth;
				}
				if (n.left != null) {
					queue.add(n.left);
				}
				if (n.right != null) {
					queue.add(n.right);
				}
			}
			depth++;
		}
		return depth;
	}

	// 求树的深度
	public static int depth(TreeNode root) {
		if (root.left == null && root.right == null)
			return 1;
		else if (root.left != null && root.right == null)
			return 1 + depth(root.left);
		else if (root.left == null && root.right != null)
			return 1 + depth(root.right);
		else {
			int num1 = 1 + depth(root.left);
			int num2 = 1 + depth(root.right);
			return num1 > num2 ? num1 : num2;
		}
	}

	// 求树深度2
	public static int depth1(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(depth1(root.left), depth1(root.right));
	}

	public static boolean isBalanced2(TreeNode root) {
		if (root == null)
			return true;
		int left = depth1(root.left);
		int right = depth1(root.right);
		return Math.abs(left - right) <= 1 && isBalanced2(root.left)
				&& isBalanced2(root.right);
	}

	// 判断是不是AVL树

	// 基本思路：
	//
	// 平衡二叉树的定义是：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
	//
	// 先计算每个节点左右子树的高度差，一旦有某个节点的左右子树高度差的绝对值大于一则表明这不是一颗平衡树。
	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return yesOrNo(root) && isBalanced(root.left) && isBalanced(root.right);
	}

	/**
	 * @param root
	 * @return
	 */
	private static boolean yesOrNo(TreeNode root) {
		if (root == null)
			return true;
		int left = 0, right = 0;
		if (root.left != null)
			left = depth(root.left);
		if (root.right != null)
			right = depth(root.right);
		if (Math.abs(left - right) <= 1)
			return true;
		else
			return false;
	}

	public static boolean isBalanced1(TreeNode root) {
		if (root == null)
			return true;
		else if (root.left == null && root.right == null)
			return true;
		else {
			int min = minDepth(root);
			int max = maxDepth(root);
			if (Math.abs(max - min) <= 1) {
				return isBalanced(root.left) && isBalanced(root.right);
			}
			return false;
		}
	}

}
