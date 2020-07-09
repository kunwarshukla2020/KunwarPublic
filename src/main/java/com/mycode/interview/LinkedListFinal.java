package com.mycode.interview;

import java.util.ArrayList;
import java.util.Collections;

//Chewy
//Declaring inside so this class does not collide with others
class Node1 {
	final long data;
	final Node1 next;

	public Node1(long data, Node1 n) {
		this.data = data;
		this.next = n; // optional as by default its null
	}

	public Node1(long data) {
		this.data = data;
		this.next = null; // optional as by default its null
	}
}

class LinkedListFinal {

	Node1 head = null; // root Node1 - head of list
	Node1 tail = null;

	// 6 -> insert 6 into existing sorted final linkedlist such that the sort order does not change.
	// 2 5 7
	public static void main(String[] args) {
		Node1 n3 = new Node1(7, null);
		Node1 n2 = new Node1(5, n3);
		Node1 n1 = new Node1(2, n2);

		printLinkedList(n1);
		Node1 n = insert(n1, 6l);
		printLinkedList(n);
	}

	public static Node1 insert(Node1 head, long data) {
		Node1 currNode = head;
		Node1 newNode = new Node1(data);
		ArrayList<Long> al = new ArrayList<>();
		if (head == null) {
			return newNode;
		}

		while (currNode != null) {
			al.add(currNode.data);
			currNode = currNode.next;
		}
		al.add(data);
		//t = (TreeSet<Integer>) t.descendingSet();
		Collections.sort(al);
		Collections.reverse(al);
		System.out.println(al);
		Node1 n = null;
		for(long i : al) {
			n = new Node1(i, n);
		}
		// newListNode.next = currNode.next;
		// currNode.next = newNode;
		return n;
	}

	// Traversal- Prints the current list
	public static void printLinkedList(Node1 head) {
		System.out.println();
		Node1 currNode1 = head;
		while (currNode1 != null) {
			System.out.print(" " + currNode1.data);
			currNode1 = currNode1.next;
		}
	}

}
