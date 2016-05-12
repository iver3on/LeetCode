/**
 * 
 */
package net.zwb;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com
 * 2016Äê5ÔÂ11ÈÕ
 */
public class MyStack {
	private Queue<Integer> queue;
	public MyStack(){
		this.queue = new LinkedList<>();	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack stack = new MyStack();
		stack.push(1);
		stack.top();
		System.out.println(stack.empty());
	}

	 // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	Queue<Integer> queue1 = new LinkedList<>();
    	int value = 0;
        while(queue.size()>1){
        	value = queue.poll();
        	queue1.offer(value);
        }
      queue.poll();
      queue = queue1;
    }

    // Get the top element.
    public int top() {
    	Queue<Integer> queue1 = new LinkedList<>(queue);
    	int value = 0;
    	while(!queue1.isEmpty()){
    		value= queue1.poll();
        }
       return value;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
    
    public int size(){
    	return queue.size();
    }
}
