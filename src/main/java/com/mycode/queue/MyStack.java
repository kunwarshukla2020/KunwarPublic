package com.mycode.queue;

/**
 * LIFO data structure -  Array implementation
 */
public class MyStack {
	int a[] = new int[5];
	int top = -1;

	public static void main(String[] args) {
		MyStack s = new MyStack();
		s.push(2);
		System.out.println(s.peek()); // this method just return the top element without removing it.
		System.out.println(s.pop());
	}

	private int pop() {
		if (top == -1) {
			System.out.println("Stack Underflow");
			return 0;
		}
		return a[top--];
	}

	private void push(int i) {
		if (top == a.length) {
			System.out.println("Stack Overflow");
		}
		a[++top] = i;
	}

	/**
	 * This method just return the top element without removing it.
	 */
	int peek() {
		if (top == -1) {
			System.out.println("Stack Underflow");
			return 0;
		}
		return a[top];
	}
}
