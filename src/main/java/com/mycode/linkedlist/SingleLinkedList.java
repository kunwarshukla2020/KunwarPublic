package com.mycode.linkedlist;

class SingleLinkedList {
	// Declaring inside so this class does not collide with others
	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null; // optional as by default its null
		}
	}
	
	Node head = null; // root node - head of list
	Node tail = null;

	public static void main(String[] args) {
		SingleLinkedList listImpl = new SingleLinkedList();
		listImpl.add(10); // Add node
		listImpl.add(20);
		listImpl.add(30);
		listImpl.add(40);
		listImpl.printLinkedList();
		listImpl.addNodeAtStart(0);
		listImpl.addNodeAtCertainIndex(50, 5);
		listImpl.printLinkedList();
		listImpl.remove();
		listImpl.printLinkedList();
		listImpl.removeNodeAtCertainIndex(2);
		listImpl.printLinkedList();
	}

	// ADD NODE at the end of the current list
	public void add(int data) {
		Node currNode = new Node(data);
		if (head == null) {
			head = currNode; //Head and tail are same in starting
			tail = currNode;
		} else {
			tail.next = currNode; //always add element in tail.next
			tail = currNode;
			// or tail = tail.next;
		}
		 /*Another way to think
		 else {
			// Else traverse till the last node and insert the new_node there
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = currNode;
		}*/
	}

	// Output -
	// 10 20 30 40
	// 0 10 20 30 40 50
	// 0 10 20 30 40
	// 0 10 	30 40

	// Traversal- Prints the current list
	public void printLinkedList() {
		System.out.println();
		Node currNode = head;
		while (currNode != null) {
			System.out.print(" " + currNode.data);
			currNode = currNode.next;
		}
	}

	// Adds node at the start of the current list
	public void addNodeAtStart(int data) {
		Node currNode = new Node(data);
		if (head == null) {
			head = currNode;
			tail = currNode;
		} else {
			currNode.next = head;
			head = currNode;
		}
	}

	// ADD NODE - Adds node at the certain index.
	public void addNodeAtCertainIndex1(int data, int index) {
		Node currNode = head;
		int count = 0;
		while (currNode != null && ++count != index) {
			currNode = currNode.next;
		}
		Node newNode = new Node(data);
		newNode.next = currNode.next;
		currNode.next = newNode;
	}
	//same as above - by kunwar
	public void addNodeAtCertainIndex(int data, int index) {
		Node newNode = new Node(data);
		Node currNode = head;
		int c = 0;
		while (currNode != null) {
			if(index == 0) { //special condition for 0 index
				newNode.next = head;
				head=newNode;
				break;
			}
			if ((c + 1) == index) {
				newNode.next = currNode.next;
				currNode.next = newNode;
				break;
			}
			currNode = currNode.next;
			c++;
		}
	}

	// REMOVE NODE - Removes the last node in the given list and updates tail node
	public void remove() {
		Node currNode = head;
		while (currNode.next != null && currNode.next.next != null) {
			currNode = currNode.next;
		}
		currNode.next = null;
		tail = currNode;
	}

	// Removes the first node in the given list and updates head node
	// The first node would become zombie and should be garbage collected after the
	// below operation
	public void removeNodeAtStart() {
		head = head.next;
	}

	// 0 10 20 30 40
	// 0 10 	30 40
	// Removes the node at the given index in the given list and updates head node
	public void removeNodeAtCertainIndex1(int index) {
		Node currNode = head;
		int count = -1;
		while (currNode != null && ++count != index) {
			currNode = currNode.next;
		}
		currNode.data = currNode.next.data;
		currNode.next = currNode.next.next;
	}
	
	//same output as above-by kunwar
	// Actually, not deleting but Copying next node to current node
	private void removeNodeAtCertainIndex(int i) {
		Node currNode = head;
		int c = 0;
		while (currNode != null) {
			if (c == i) {
				currNode.data = currNode.next.data; //imp
				currNode.next = currNode.next.next;
				break;
			} else {
				currNode = currNode.next;
				c++;
			}
		}
	}

	// Checks if a node with the given value exist in the list, returns true or
	// false. Alternatively you can return the index too. check below
	public boolean search(int target) {
		Node currNode = head;
		while (currNode != null) {
			if (currNode.data == target) {
				return true;
			}
			currNode = currNode.next;
		}
		return false;
	}

	// Checks if a node with the given value exist in the list, returns the index of
	// the given value in the list.
	public int searchAndReturnIndex(int target) {
		Node currNode = head;
		int count = 0;
		while (currNode != null) {
			count++;
			if (currNode.data == target) {
				return count;
			}
			currNode = currNode.next;
		}
		return -1;
	}

}
