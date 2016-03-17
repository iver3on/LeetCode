package leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class RemoveDuplicatesfromSortedList {
	public static ListNode deleteDuplicates(ListNode head) {
		/*
		 * Set<Integer> set = new HashSet<>(); ListNode node = null;
		 * //set.add(head.val); while(head!=null){ set.add(head.val); head =
		 * head.next; } for(int i = 0;i<set.size();i++){
		 * 
		 * }
		 */
		if (head == null) {
			return head;
		} else {
			ListNode node = head;
			ListNode node1 = node;
			while (head != null) {
				if (head.next!=null&&head.val == head.next.val) {
					head = head.next;
				} else {
					node1.next = head.next;
					node1 = node1.next;
					head = head.next;
				}
			}
			return node;
		}
	}

	public static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		ListNode node1 = new ListNode(1);
		/*
		 * ListNode node2 = new ListNode(2); ListNode node3 = new ListNode(2);
		 * ListNode node4 = new ListNode(3);
		 */
		node.next = node1;
		// node1.next = node2;
		// node2.next = node3;
		// node3.next = node4;
		print(node);
		deleteDuplicates(node);
		print(node);
	}

}
