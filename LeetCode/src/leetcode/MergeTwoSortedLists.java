/**
 * 
 */
package leetcode;

/**
 * @author Iver3oN Zhang
 * @date 2016年3月16日
 * @email grepzwb@qq.com MergeTwoSortedLists.java Impossible is nothing
 */
public class MergeTwoSortedLists {

	// Definition for singly-linked list

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		ListNode node = mergeTwoLists(node1, node3);
		print(node);
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null&&l2!=null){
			return l2;
		}
		if(l1!=null&&l2==null){
			return l1;
		}
		ListNode firstNode = new ListNode(0);
		ListNode node = firstNode;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				node.next= l1;
				l1 = l1.next;
				//node = node.next;
			} else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}
		// node.next = (l1 != null) ? l1 : l2;// Append the remaining elements in the longer list
		 if(l1!=null){
			 	node.next = l1;
		 }else
		 node.next =l2;
		 
	     return firstNode.next;
		/*// 剩余的放进新数组中
		while (l1 != null) {
			node.next = l1;
			l1 = l1.next;
			node = node.next;
		}
		while (l2 != null) {
			node.next = l2;
			l2= l2.next;
			node = node.next;
		}
		while (node != null) {
			firstNode.next = node;
			firstNode = firstNode.next;
			node = node.next;
		}
		return firstNode;*/
	}
}
