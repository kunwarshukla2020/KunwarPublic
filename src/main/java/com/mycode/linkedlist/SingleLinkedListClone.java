package com.mycode.linkedlist;

//Clone of node
class SingleLinkedListClone {
	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head = null;
	Node tail = null;

	public static void main(String[] args) {
		SingleLinkedListClone listImpl = new SingleLinkedListClone();
		listImpl.add(1);
		listImpl.add(2);
		listImpl.add(3);
		listImpl.add(4);
		listImpl.printLinkedList(listImpl.head);
		Node copy = listImpl.cloneLinkedListIterative(listImpl.head);
		listImpl.printLinkedList(copy);
	}

	// 1 2 3 4
	private Node cloneLinkedListIterative(Node head) {
		Node currNode = head;
		Node cloneHead = null;
		Node previousNode = null;

		while (currNode != null) {
			Node newNode = new Node(currNode.data);
			if (cloneHead == null) {
				cloneHead = newNode;
				previousNode = newNode;
			} else {
				previousNode.next = newNode;
				previousNode = newNode;
			}
			currNode = currNode.next;
		}
		return cloneHead;
	}

	public void add(int data) {
		Node currNode = new Node(data);
		if (head == null) {
			head = currNode; // Head and tail are same in starting
			tail = currNode;
		} else {
			tail.next = currNode; // always add element in tail.next
			tail = currNode;
		}
	}

	public void printLinkedList(Node head) {
		System.out.println();
		Node currNode = head;
		while (currNode != null) {
			System.out.print(" " + currNode.data);
			currNode = currNode.next;
		}
	}

}
