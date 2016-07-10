package nowcodehuawei;

import java.util.Scanner;

/*
 * 有一个数组a[N]顺序存放0-N，要求没隔两个数删掉一个数，到末尾时循环至开头继续进行，
 * 求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),
 * 如此循环直到最后一个数被删除。 
 */
public class Main2 {

	static class Node {
		int val;
		Node next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			int i = 1;
			Node head = new Node();
			head.val = 0;
			head.next = null;
			Node p = head;
			while (i < m) {
				Node node = new Node();
				node.val = i;
				node.next = null;
				head.next = node;
				head = head.next;
				i++;
			}
			head.next = p;
			while (p != p.next) {
				p.next.next = p.next.next.next;
				p = p.next.next;
			}
			System.out.println(p.val);
		}
	}
}
