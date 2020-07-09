package com.mycode.interview;

class Node2 {
	int data;
	Node2 next;

	public Node2(int data) {
		this.data = data;
		this.next = null; // optional as by default its null
	}

	public Node2(int data, Node2 next) {
		this.data = data;
		this.next = next; // optional as by default its null
	}
}

class LinkedList {

	Node2 head = null; // root node - head of list
	Node2 tail = null;

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.add(1);
		l1.add(2);
		l1.add(4);
		l1.printLinkedList();
	}

	// ADD NODE at the end of the current list
	public void add(int data) {
		Node2 currNode = new Node2(data);
		if (head == null) {
			head = currNode; // Head and tail are same in starting
			tail = currNode;
		} else {
			tail.next = currNode; // always add element in tail.next
			tail = currNode;
			// or tail = tail.next;
		}
	}

	public void printLinkedList() {
		System.out.println();
		Node2 currNode = head;
		while (currNode != null) {
			System.out.print(" " + currNode.data);
			currNode = currNode.next;
		}
	}

}
