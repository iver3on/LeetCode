/**
 * leetcode232
 */
package leetcode;

import java.util.Stack;

/**
 * @author Iver3oN Zhang
 * @date 2016年3月16日
 * @email grepzwb@qq.com
 * ImplementQueueusingStacks.java
 * Impossible is nothing
 */
class MyQueue {
	private Stack<Integer> stack;
	public MyQueue(){
		this.stack = new Stack<>();
	}
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> stack1 = new Stack<>();
        while(stack.size()>0){
        	stack1.push(stack.pop());
        }
        stack1.pop();
        while(stack1.size()>0){
        	stack.push(stack1.pop());
        }
    }

    // Get the front element.
    public int peek() {
    	Stack<Integer> stack1 = new Stack<>();
        while(stack.size()>0){
        	stack1.push(stack.pop());
        }
        int front = stack1.peek();
        while(stack1.size()>0){
        	stack.push(stack1.pop());
        }
        return front;
    }

    // Return whether the queue is empty.
    public boolean empty() {
		if(stack.size()==0){
			return true;
		}
		return false;
    }
}
public class ImplementQueueusingStacks {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(3);
		queue.push(4);
		queue.pop();
		print(queue);
	}

	/**
	 * @param queue
	 */
	private static void print(MyQueue queue) {
		// TODO Auto-generated method stub
		while(!queue.empty()){
			System.out.println(queue.peek());
			queue.pop();
		}
	}

}
