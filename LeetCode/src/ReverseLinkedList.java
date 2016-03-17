import java.util.Stack;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
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
		ListNode node = reverseList(listNode1);
		print(node);
	}

	public static ListNode reverseList(ListNode head) {
		// 遍历单链表入栈
		if (head != null) {
			Stack<ListNode> stack = new Stack<>();
			ListNode node = head;
			ListNode tempNode;
			stack.push(node);
			while (node != null) {
				if (node.next == null) {
					break;
				}
				stack.push(node.next);
				node = node.next;
			}
			// 栈中的数据重新组成单链表
			tempNode = stack.pop();
			ListNode node1 = tempNode;
			ListNode headNew = tempNode;
			while (node1.val != head.val) {
				node1 = stack.peek();
				tempNode.next = stack.pop();
				tempNode = node1;
			}
			node1.next = null;
			return headNew;
		} else
			return null;
	}

	// 打印列表
	public static void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
