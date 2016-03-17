import java.util.ArrayList;


public class helloTreeNode1 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(9);
		TreeNode node8 = new TreeNode(3);
		TreeNode node9 = new TreeNode(5);
		node1.left  = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node5.left = node8;
		node5.right = node9;
		System.out.println(lowestCommonAncestor(node1,node8,node9).val);

	}
	
	/*上面的方法虽然是O(n)，但是操作依然繁琐了一点，并且需要额外的空间来存储路径。其实可以只遍历一次，利用递归的巧妙之处。
	 * 学好二叉树，其实就是学好递归。从root开始遍历，如果n1和n2中的任一个和root匹配，那么root就是LCA。 
	 * 如果都不匹配，则分别递归左、右子树，如果有一个 key（n1或n2）出现在左子树，并且另一个key(n1或n2)出现在右子树，
	 * 则root就是LCA.  如果两个key都出现在左子树，则说明LCA在左子树中，否则在右子树。
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		if(root==null){
			return root;
		}
		//从root开始遍历，如果n1和n2中的任一个和root匹配，那么root就是LCA。 
		if(root.val==p.val||root.val==q.val){
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		//// 如果都返回非空指针 Non-NULL, 则说明两个节点分别出现了在两个子树中，则当前节点肯定为LCA
		if (left!=null&&right!=null) {
			return root;
		}else{
			// // 如果一个为空，在说明LCA在另一个子树
			if(left!=null){
				return left;
			}else
				return right;
		}
	}
	

	//第二种方法 比较好理解  没有使用递归   但是在找路径的时候使用了递归。所以还是比较好理解的
	public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p,
			TreeNode q) {
		ArrayList<TreeNode> path1 = new ArrayList<>();
		ArrayList<TreeNode> path2 = new ArrayList<>();
		boolean find1 = findpath(root, p, path1);
		boolean find2 = findpath(root, q, path2);
		if (find1 && find2) {
			TreeNode ans = null;
			for (int i = 0; i < Math.min(path1.size(),path2.size()); i++) {
				if (path1.get(i).val!= path2.get(i).val) {
					break;
				} else {
					ans = path1.get(i);
				}
			}
			return ans;
		}
		return root;
	}

	//寻找两个node的路径节点
	/*
	 *  _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
	 */
	public static boolean findpath(TreeNode root, TreeNode nood,
			ArrayList<TreeNode> path) {
		if (root == null)return false;
		path.add(root);
		if (root.val == nood.val)return true;
		// 左子树或右子树 是否找到,找到的话当前节点就在路径中
		boolean find = (findpath(root.left, nood, path) || findpath(root.right,
				nood, path));
		if (find)
			return true;
		// 该节点下未找到就弹出
		path.remove(path.size() - 1);
		return false;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
