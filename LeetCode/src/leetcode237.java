import java.util.ArrayList;
import java.util.List;

public class leetcode237 {
	/*
	 * Write a function to delete a node (except the tail) in a singly linked
	 * list, given only access to that node. Supposed the linked list is 1 -> 2
	 * -> 3 -> 4 and you are given the third node with value 3, the linked list
	 * should become 1 -> 2 -> 4 after calling your function.
	 */

	// 根節點
	static ListNode listNode1 = new ListNode(1);

	public static void main(String[] args) {

		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		ListNode listNode7 = new ListNode(7);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		listNode6.next = listNode7;
		listNode7.next = null;
		// deleteNode1(listNode2);
		oddEvenList(listNode1);
		// print(listNode1);

	}

	/*
	 * Given a singly linked list, group all odd nodes together followed by the
	 * even nodes. Please note here we are talking about the node number and not
	 * the value in the nodes. You should try to do it in place. The program
	 * should run in O(1) space complexity and O(nodes) time complexity.
	 */

	public static ListNode oddEvenList(ListNode head) {
		ListNode node = head;
		List<ListNode> list = new ArrayList<>();
		List<ListNode> list2 = new ArrayList<>();
		list.add(node);
		boolean tag = false;
		if (node == null) {
			return node;
		}
		while (node.next != null) {
			list2.add(node.next);
			if (node.next.next != null) {
				list.add(node.next.next);
			} else {
				tag = true;
				break;
			}
			node = node.next.next;
		}
		/*
		 * for(ListNode node1:list){ System.out.print(node1.val); }
		 * System.out.println("----------"); for(ListNode node1:list2){
		 * System.out.print(node1.val); }
		 */
		head = list.get(0);
		ListNode hh = head;
		for (int i = 1; i < list.size(); i++) {
			hh.next = list.get(i);
			hh = list.get(i);
		}
		ListNode mm = list.get(list.size() - 1);
		for (int j = 0; j < list2.size(); j++) {
			mm.next = list2.get(j);
			mm = list2.get(j);
		}
		if (list2.size() > 0) {
			list2.get(list2.size() - 1).next = null;
		}
		return head;
		// print(head);

		// return node;
	}

	// 在刪除的時候可以得到根節點
	public static void deleteNode1(ListNode node) {
		ListNode n = listNode1;
		ListNode n1 = null;
		while (n != null) {
			if (n == node) {
				n1.next = node.next;
			}
			n1 = n;
			n = n.next;
		}
	}

	// 只能使用被刪除的那個節點
	public static void deleteNode(ListNode node) {
		ListNode n1 = null;
		n1 = node.next;
		if (n1 != null) {
			node.val = n1.val;
			node.next = n1.next;
		}
	}

	// 類
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// 打印列表
	public static void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
}
