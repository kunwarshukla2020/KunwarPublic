package com.mycode.linkedlist;

public class SortedDoubleLinkedList {
	
	//can declare Node class outside
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
	
	public static void main(String[] args) {
		SortedDoubleLinkedList dll = new SortedDoubleLinkedList();

		dll.addEnd(1);
		dll.addEnd(5);
		dll.addEnd(9);
		dll.printlist();
		dll.printlist(dll.head);
		dll.sortedInsert(7);
		dll.printlist(dll.head);
	}

	// Insert the data in the linked list in a sorted way i.e. order of the list doesn't change.
	private void sortedInsert(int i) {
		Node newNode = new Node(i);
		Node currNode = head;
		while (currNode != null) {
			if (currNode.data >= i) {
				break;
			}
			currNode = currNode.next;
		}
		currNode.prev.next = newNode;
		newNode.prev = currNode.prev;

		currNode.prev = newNode;
		newNode.next = currNode;
	}

	// ADD NODE at the end of the list
	public void addEnd(int data) {
		Node currNode = new Node(data);
		if (head == null) {
			head = currNode; // Head and tail are same in starting
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
