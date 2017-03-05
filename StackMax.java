package assignment2;
/*
 * This program will find the maximum value in the stack
 * And it will not pop the value out of the stack
 */

import java.util.Stack;

public class StackMax {

	Stack<Integer> stack = new Stack();
	Stack<Integer> maxStack = new Stack();
	Stack<Integer> tempStack = new Stack();
	/*
	 * This will add the given item into the stack
	 * 
	 * @param the item to be added
	 */

	public void push(int item) {
		if (stack.isEmpty()) {
			stack.add(item);
			maxStack.push(item);
		} else {
			stack.add(item); // adds the item into the stack
			int max = maxStack.peek();
			while (item < max && !maxStack.isEmpty()) {
				tempStack.push(maxStack.pop());
				if (maxStack.isEmpty()) {
					maxStack.push(item);
				} else {
					max = maxStack.peek();
				}
			}
			maxStack.push(item);
			while (!tempStack.isEmpty()) {
				maxStack.push(tempStack.pop());
			}
		}
	}

	/*
	 * This method will remove the latest item added into the stack
	 */
	public int pop() {
		if (!stack.isEmpty() && !maxStack.isEmpty()) {
			int max = maxStack.peek(); // looks at the first item in the
										// maxStack
			int myItem = stack.pop();
			while (max != myItem && !maxStack.isEmpty()) {
				tempStack.push(maxStack.pop());
				max = maxStack.peek();
			}
			int retValue = maxStack.pop();
			while (!tempStack.isEmpty()) {
				maxStack.push(tempStack.pop());
			}
			return retValue;
		} else {
			return 0;
		}

	}

	/*
	 * this will look at the maximum value in the stack and prints it.
	 */
	public int getMax() {
		return maxStack.peek();
	}

	public int popMax() {
		if (!maxStack.isEmpty() && !!stack.isEmpty()) {
			int max = maxStack.pop();
			int myValue = stack.peek();
			while (myValue != max) {
				tempStack.push(stack.pop());
				myValue = stack.peek();
			}
			int retValue = stack.pop();
			while (!tempStack.isEmpty()) {
				stack.push(tempStack.pop());
			}
			return retValue;
		}else{
			return 0;
		}
	}

	public static void main(String[] args) {
		StackMax max = new StackMax();
		max.push(100);
		max.push(11);
		max.push(13);
		System.out.println(max.popMax());
		System.out.println(max.popMax());
		System.out.println(max.popMax());
		System.out.println(max.popMax());
		System.out.println(max.getMax());
	}

}
