package nowcodehuawei;

import java.util.Scanner;

/*
 * ��һ������a[N]˳����0-N��Ҫ��û��������ɾ��һ��������ĩβʱѭ������ͷ�������У�
 * �����һ����ɾ��������ԭʼ�±�λ�á���8����(N=7)Ϊ��:��0��1��2��3��4��5��6��7����0->1->2(ɾ��)->3->4->5(ɾ��)->6->7->0(ɾ��),
 * ���ѭ��ֱ�����һ������ɾ���� 
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
