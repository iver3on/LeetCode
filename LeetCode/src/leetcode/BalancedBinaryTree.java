/**
 * 它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Iver3oN Zhang
 * @date 2016年3月16日
 * @email grepzwb@qq.com BalancedBinaryTree.java Impossible is nothing
 */

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BalancedBinaryTree {

	//计算二叉树深度
	public static int getDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (getDepth(root.left) > getDepth(root.right)) {
			return getDepth(root.left) + 1;
		} else
			return getDepth(root.right) + 1;
	}

	//复杂度为O(N^2)
	//在判断左右子树是否平衡的过程中把深度计算出来，
	//这样在对父结点进行平衡判断时就可以不用再重复计算左右子树的深度了。
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!isBalanced(root.left) || !isBalanced(root.right)) {
			return false;
		}
		int deepRight = getDepth(root.right);
		int deepLeft = getDepth(root.left);
		if (Math.abs(deepLeft - deepRight) > 1) {
			return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(8);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.left = node5;
		System.out.println(getDepth(node1));
		System.out.println(isBalanced(node1));
		
		Set<Integer> set = new HashSet<>();
	}

}
