import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class leetcode104 {
	static List<TreeNode> nodeList1 = new LinkedList<TreeNode>();
	static List<TreeNode> nodeList2 = new LinkedList<TreeNode>();

	public static void main(String[] args) {
		// 将数组的序列存储到二叉树List中，第0个元素 即为二叉树根节点
		createBinTree(nodeList1);
		createBinTree2(nodeList2);
		TreeNode root = nodeList1.get(0);
		TreeNode root2 = nodeList2.get(0);
		System.out.println("此二叉树的深度是：" + maxDepth(root));
		System.out.println("此二叉树前序遍历：");
		preOrder(root);
		System.out.println();
		System.out.println("非递归前序遍历：");
		preOrder1(root);
		System.out.println();
		System.out.println("此二叉树中序遍历：");
		inOrder(root);
		System.out.println();
		System.out.println("非递归中序遍历：");
		inOrder(root);
		System.out.println();
		System.out.println("此二叉树中序遍历：");
		inOrder(root);
		System.out.println();
		System.out.println("非递归前序遍历：");

		System.out.println(isSameTree(root, root2));
		System.out.println();
	}

	// 寻找最近公共祖先 leetcode题目
	// 对于一棵有根树，就会有父亲结点，祖先结点，当然最近公共祖先就是这两个点所有的祖先结点中深度最大的一个结点。
	/*
	 * 下面是一个简单的复杂度为 O(n) 的算法，解决LCA问题 1) 找到从根到n1的路径，并存储在一个向量或数组中。
	 * 2)找到从根到n2的路径，并存储在一个向量或数组中。 3) 遍历这两条路径，直到遇到一个不同的节点，则前面的那个即为最低公共祖先.
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		ArrayList<TreeNode> path1 = new ArrayList<>();
		ArrayList<TreeNode> path2 = new ArrayList<>();
		boolean find1 = findpath(root, p, path1);
		boolean find2 = findpath(root, q, path2);
		if(find1&&find2){
			TreeNode ans = null;
			for(int i =0;i<path1.size();i++){
				if(path1.get(i).val!=path2.get(i).val){
					break;
				}else{
					ans = path1.get(i);
				}	
			}
			return ans;	
		}
		return null;
	}

	public static boolean findpath(TreeNode root,TreeNode nood,ArrayList<TreeNode> path){
		  if(root==null) return false;
		  path.add(root);
		  if(root.val ==nood.val) return true;
	      //左子树或右子树 是否找到,找到的话当前节点就在路径中
		  boolean find =  ( findpath(root.left,nood,path) || findpath(root.right,nood,path) );
		  if(find) return true;
		  //该节点下未找到就弹出
		  path.remove(path.size()-1);
		  return false;
}

	// 判斷兩個二叉樹是否相同 LeetCode上的题目
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p != null && q != null) {
			if (p.val == q.val && isSameTree(p.left, q.left)
					&& isSameTree(p.right, q.right)) {
				return true;
			}
		} else if (p == null && q == null) {
			return true;
		} else if (p == null && q != null) {
			return false;
		}
		return false;
	}

	// 翻转二叉树 leetcode上的题目
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	// 中序遍历
	public static Stack<TreeNode> postOrder2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		if (root != null) {
			postOrder2(root.left);
			stack.add(root);
			postOrder2(root.right);
		}
		return stack;
	}

	// 计算深度 leetcode上的题目
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int i = maxDepth(root.left);
			int j = maxDepth(root.right);
			return (i < j) ? (j + 1) : (i + 1);
		}

	}

	// 访问节点
	public static void visit(TreeNode root) {
		root.isVisted = true;
		System.out.print(root.val + "-->");
	}

	// 前序遍历
	public static void preOrder(TreeNode root) {
		if (root != null) {
			visit(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	// 中序遍历
	public static void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			visit(root);
			inOrder(root.right);
		}
	}

	// 后序遍历
	public static void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			visit(root);
		}
	}

	// 前序遍历的非递归实现
	public static void preOrder1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				visit(node);
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			node = node.right;
		}
	}

	// 中序遍历的非递归实现
	public static void inOrder1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (stack.size() > 0) {
				node = stack.pop();
				visit(node);
				node = node.right;
			}
		}
	}

	// 后序遍历的非递归实现
	public static void postOrder1(TreeNode p) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = p;
		while (p != null) {
			// 左子树入栈
			for (; p.left != null; p = p.left) {
				stack.push(p);
			}
			// 当前结点无右子树或右子树已经输出
			while (p != null && (p.right == null || p.right == node)) {
				visit(p);
				// 纪录上一个已输出结点
				node = p;
				if (stack.empty())
					return;
				p = stack.pop();
			}
			// 处理右子树
			stack.push(p);
			p = p.right;
		}
	}

	// 初始化二叉树
	public static void createBinTree(List<TreeNode> nodeList) {
		int[] array = { 6, 2, 8, 0, 4, 7, 9, 0, 0, 3, 5 };
		// 将一个数组的值依次转换为Node节点
		for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
			nodeList.add(new TreeNode(array[nodeIndex]));
		}
		// 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
		for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
			// 左孩子
			nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
			// 右孩子
			nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
		}
		// 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
		int lastParentIndex = array.length / 2 - 1;
		// 左孩子
		nodeList.get(lastParentIndex).left = nodeList
				.get(lastParentIndex * 2 + 1);
		// 右孩子,如果数组的长度为奇数才建立右孩子
		if (array.length % 2 == 1) {
			nodeList.get(lastParentIndex).right = nodeList
					.get(lastParentIndex * 2 + 2);
		}
	}

	// 初始化二叉树
	public static void createBinTree2(List<TreeNode> nodeList) {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		// 将一个数组的值依次转换为Node节点
		for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
			nodeList.add(new TreeNode(array[nodeIndex]));
		}
		// 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
		for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
			// 左孩子
			nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
			// 右孩子
			nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
		}
		// 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
		int lastParentIndex = array.length / 2 - 1;
		// 左孩子
		nodeList.get(lastParentIndex).left = nodeList
				.get(lastParentIndex * 2 + 1);
		// 右孩子,如果数组的长度为奇数才建立右孩子
		if (array.length % 2 == 1) {
			nodeList.get(lastParentIndex).right = nodeList
					.get(lastParentIndex * 2 + 2);
		}
	}

	// 二叉树类
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		boolean isVisted = false;

		TreeNode(int x) {
			val = x;
		}

		public TreeNode() {
		}

		public TreeNode(TreeNode left, TreeNode right, int val) {
			this.left = left;
			this.right = right;
			this.val = val;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

	}

}
