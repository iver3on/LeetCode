/**
 * 
 */
package leetcode94;

/**
 * @author Iver3on
 * @date 2016年9月4日
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class SwapNodesinPairs {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		System.out.println(swapPairs(n1));
	}
	public static ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode current = dummy;
		while(current.next!=null&&current.next.next!=null){
			ListNode first = current.next;
			ListNode second = current.next.next;
			//1-> =2.next  =3
			first.next = second.next;
			current.next = second;
			current.next.next = first;
			current = current.next.next;
		}
		return dummy.next;
	}
}
