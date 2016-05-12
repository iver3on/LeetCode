/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   	↘
                     c1 → c2 → c3
                   	↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Credits:
 */
package net.zwb;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com 2016年5月11日
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class IntersectionofTwoLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node4.next = node3;
		node3.next = node5;
		node5.next = node6;
		System.out.println(getIntersectionNode1(node1, node4).val);
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode next1 = headA;
		ListNode next2 = headB;
		int lengthA = 0, lengthB = 0;
		while (next1 != null) {
			next1 = next1.next;
			lengthA++;
		}

		while (next2 != null) {
			next2 = next2.next;
			lengthB++;
		}
		if (lengthA > lengthB) {
			for (int i = 0; i < lengthA - lengthB; i++) {
				headA = headA.next;
			}
		} else {
			for (int i = 0; i < lengthB - lengthA; i++) {
				headB = headB.next;
			}
		}
		while(headA!=null&&headB!=headA){
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}
	
	public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		ListNode p1 = headA;
		ListNode p2 = headB;
		while(p1!=p2){
			if(p1==null){
				p1 = headB;//调换
			}else{
				p1 = p1.next;
			}
			if(p2==null){
				p2 = headA;//调换
			}else{
				p2 =p2.next;
			}
		}
		return p1;
	}
}
