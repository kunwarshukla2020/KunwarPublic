package com.mycode.linkedlist;

public class CircularLinkedList {
	class Node {
		int data;
		Node prev;
		Node next;

		// Constructor to create a new node, next and prev is by default initialized as null
		public Node(int data) {
			this.data = data;
		}
	}

	Node head = null; // root node - head of list
	Node tail = null;
	Node head2 = null;
	
	public static void main(String[] args) {
		CircularLinkedList dll = new CircularLinkedList();
		dll.addEnd(1);
		dll.addEnd(2);
		dll.addEnd(3);
		dll.addEnd(4);
		dll.printLinkedList();
		dll.split(); // split into two list. In case of odd first list can have more nodes. Can also be used to check for Palindrome
		dll.printLinkedList();
		dll.printLinkedList2();
	}
	
	/*OUTPUT-
	 1 2 3 4
	 slow:2
	 fast:4
	  1 2
	  3 4*/

	// ADD NODE at the end of the list
	public void addEnd(int data) {
		Node currNode = new Node(data);
		if (head == null) {
			head = currNode; // Head and tail are same in starting
			tail = currNode;

			currNode.next = head; // pointing to the head node
		} else {
			tail.next = currNode; // always add element in tail.next
			tail = currNode;
			tail.next = head; // Since, it is circular linked list tail will point to head.
		}
	}

	// Think why do-while is used instead of while loop
	// In a circular linked list, we stop traversal when we reach the first node again
	public void printLinkedList() {
		Node currNode = head;
		if (head == null) {
			System.out.println("List is empty");
		} else {
			do {
				System.out.print(" " + currNode.data);
				currNode = currNode.next;
			} while (currNode != head);
			System.out.println();
		}
	}
	
	//split into two list. In case of odd first list can have more nodes.
	//     1 2 3 4 5 6-->1..
	//slo  ^ 
	//fas    ^
	public void split() {
		Node slow = head;
		Node fast = head.next;
		
		//even node - fast.next is head. Odd - fast is head
		while (fast != head && fast.next != head) {
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println("slow:" + slow.data);
		System.out.println("fast:" + fast.data);
		head2 = slow.next;
		fast.next = head2;
		slow.next = head;
	}
	
	
	public void printLinkedList2() {
		Node currNode = head2;
		if (head2 == null) {
			System.out.println("List is empty");
		} else {
			do {
				System.out.print(" " + currNode.data);
				currNode = currNode.next;
			} while (currNode != head2);
			System.out.println();
		}
	}

}
