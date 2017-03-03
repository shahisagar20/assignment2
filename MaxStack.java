package assignment2;

import java.util.Stack;

public class MaxStack {

	Stack<Integer> stack = new Stack();
	Stack<Integer> tempStack = new Stack();

	public void push(int item) {
		if (stack.isEmpty()) {
			stack.add(item);
			tempStack.push(item);
		} else {
			int max = tempStack.peek();
			tempStack.add(Math.max(max, item));
			stack.add(item);
		}
	}

	public int pop() {
		if (!stack.isEmpty()) {
			 tempStack.pop();
			 return stack.pop();
		}else{
		return 0;
		}
	}

	public int getMax() {
		return tempStack.peek();
	}

	public static void main(String[] args) {
		MaxStack max = new MaxStack();
		max.push(5);
		max.push(6);
		max.push(7);
		max.push(8);
		max.push(9);
		max.push(100);
		max.push(11);
		max.push(13);
		
		System.out.println(max.pop());
		System.out.println(max.getMax());
	}

}
