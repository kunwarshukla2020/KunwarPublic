package com.mycode.linkedlist;

class Node {
	int data;
	Node prev;
	Node next;

	// Constructor to create a new node, next and prev is by default initialized as null
	public Node(int data) {
		this.data = data;
	}
}

public class DoubleLinkedList {
	Node head = null; // root node - head of list
	Node tail = null; 
	
	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList();

		// Insert 6. So linked list becomes 6->NULL
		dll.addEnd(6);

		// Insert 7 at the beginning. So linked list becomes 7->6->NULL
		dll.addFront(7);

		// Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
		dll.addFront(1);

		// Insert 4 at the end. So linked list becomes 1->7->6->4->NULL
		dll.addEnd(4);

		// Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL
		dll.insertAfter(dll.head.next, 8);

		dll.printlist();
		dll.printlist(dll.head);
	}

	// ADD NODE at the end of the list
	public void addEnd(int data) {
		Node currNode = new Node(data);
		if (head == null) {
			head = currNode; // Head and tail are same in starting
			tail = currNode;
		} else {
			// Else traverse till the last node and insert the currNode there
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = currNode; // Insert the currNode at last node
			currNode.prev = last; // Make last node as previous of new node
			tail = currNode;
		}
	}

	// Adds node at the start of the current list
	public void addFront(int data) {
		Node currNode = new Node(data);
		if (head == null) {
			head = currNode;
		} else {
			currNode.next = head;
			currNode.prev = null;
			head.prev = currNode;
			head = currNode;
		}
	}

	/* Given a node as prev_node, insert a new node after the given node */
	public void insertAfter(Node prev_Node, int data) {

		/* 1. check if the given prev_node is NULL */
		if (prev_Node == null) {
			System.out.println("The given previous node cannot be NULL ");
			return;
		}

		/*
		 * 2. allocate node 3. put in the data
		 */
		Node currNode = new Node(data);

		/* 4. Make next of new node as next of prev_node */
		currNode.next = prev_Node.next;

		/* 5. Make the next of prev_node as currNode */
		prev_Node.next = currNode;

		/* 6. Make prev_node as previous of currNode */
		currNode.prev = prev_Node;

		/* 7. Change previous of currNode's next node */
		if (currNode.next != null)
			currNode.next.prev = currNode;
	}

	public void printlist(Node node) {
		Node last = null;
		System.out.print("\nTraversal in forward Direction: ");
		while (node != null) {
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
		System.out.print("\nTraversal in reverse direction: ");
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.prev;
		}
		
		System.out.print("\nTraversal in reverse direction using tail: ");
		Node last1 = tail;
		while (last1 != null) {
			System.out.print(last1.data + " ");
			last1 = last1.prev;
		}
	}

	public void printlist() {
		System.out.print("\nTravel forward only:");
		Node currNode = head;
		while (currNode != null) {
			System.out.print(" " + currNode.data);
			currNode = currNode.next;
		}
	}

}
