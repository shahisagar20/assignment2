package assignment2;
/*Sagar Shahi
 * Assignment2Q#2
 * 
 * This program will find the maximum value in the stack
 * And it will not pop the value out of the stack if you just want to see the max value in the stack
 * If you want to pop the maximum value in the stack, it will pop the maximum value
 * and restore the stack as it should have been in after max-value is removed from the stack.
 * I used 3 stacks
 * One stack to behave as a regular stack, another stack to keep track of the maximum value, and 
 * another re-usable temporary stack.
 */

import java.util.Stack;

public class StackMax {

	private Stack<Integer> stack = new Stack(); // initialize the three stacks
	private Stack<Integer> maxStack = new Stack();
	private Stack<Integer> tempStack = new Stack();
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
			int max = maxStack.peek();// stores the value in maxStack
			while (item < max && !maxStack.isEmpty()) {// runs a loop to sort
														// the stack and
				tempStack.push(maxStack.pop());// puts the value with largest
												// values from top to smallest
												// bottom
				if (maxStack.isEmpty()) {// checks if there no move items left
											// in the stack for comparison
					maxStack.push(item);// then puts the smallest value in the
										// stack
				} else {
					max = maxStack.peek();
				}
			}
			maxStack.push(item);// restores the maxStack
			while (!tempStack.isEmpty()) {
				maxStack.push(tempStack.pop());
			}
		}
	}

	/*
	 * This method will remove the latest item added into the stack
	 * @return Returns the latest value added to the stack.
	 */
	public int pop() {
		if (!stack.isEmpty()) {
			int max = maxStack.peek(); // looks at the first item in the
										// maxStack
			int myItem = stack.pop();//pops the first item from the stack
			while (max != myItem && !maxStack.isEmpty()) { //
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
		if (!maxStack.isEmpty()) {
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
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		StackMax max = new StackMax();
		max.push(5);
		max.push(6);
		max.push(7);
		max.push(8);
		max.push(9);
		max.push(100);
		max.push(11);
		max.push(13);

		int x = 8;
		while (x > 0) {
			System.out.println("rerPop: " + max.pop());
			System.out.println("maxPop: " + max.popMax());
			x--;
		}
	}

}
