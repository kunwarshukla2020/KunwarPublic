package com.mycode.interview;

import java.util.LinkedHashMap;
import java.util.Map;

//Amazon - create duplicate list- Good question
//https://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/
class Node {
	String data;
	Node next;
	Node random;

	public Node(String data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node(Node rand) {
		this.random = rand;
	}

	public Node(String data, Node next, Node random) {
		this.data = data;
		this.next = next;
		this.random = random;
	}

	public Node(String data) {
		this.data = data;
		this.next = null;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}
}

//A1->B1->C1->D1->null
//A1->C1
//C1->B1
//B1->D1
//D1->null

//A2->B2->C2->D2->null
//A2->C2
//C2->B2
//B2->D2
//D2->null

class LinkedList {

	Node head = null;
	Node tail = null;

	public static void main(String[] args) {

		Node d1 = new Node("D1", null);
		Node c1 = new Node("C1", d1);
		Node b1 = new Node("B1", c1);
		Node a1 = new Node("A1", b1);

		a1.random = c1;
		c1.random = b1;
		b1.random = d1;
		d1.random = b1;

		LinkedList l1 = new LinkedList();
		l1.printLinkedList(a1);
		Node cloneHead = l1.createDuplicate(a1);
		l1.printLinkedList(cloneHead);

		Node copy = l1.cloneLinkedList(a1);
		l1.printLinkedList(copy);
	}

	// check why will this not work?
	private Node cloneLinkedList(Node head) {
		Node currNode = head;
		Node cloneHead = null;
		Node previousNode = null;

		// first creating duplicate list
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

		currNode = head;
		Node cloneCurr = cloneHead;
		while (currNode != null) {
			Node newNode = new Node(currNode.random); // this is creating new node, what we want is existing one that we craeted above
			cloneCurr.random = newNode;
			cloneCurr = cloneCurr.next;
			currNode = currNode.next;
		}

		return cloneHead;
	}

	private Node createDuplicate(Node head) {

		Node origCurr = head;
		Node cloneCurr = null;
		Map<Node, Node> map = new LinkedHashMap<Node, Node>();// Can use HashMap also

		// Step 1# Iterating org list and creating map with org obj and clone obj with just data
		while (origCurr != null) {
			cloneCurr = new Node(origCurr.data); // next, random is null at this time
			map.put(origCurr, cloneCurr);
			origCurr = origCurr.next;
		}

//		System.out.println();
//		for (Node s : map.keySet()) {
//			System.out.println(s.data);
//		}

		// Step 2# Iterating again and setting clone next, random here from map.
		origCurr = head;
		while (origCurr != null) {
			cloneCurr = map.get(origCurr);
			cloneCurr.next = map.get(origCurr.next); // note, here map.get is giving reference of new obj
			cloneCurr.random = map.get(origCurr.random);

			origCurr = origCurr.next;
		}

		Node cloneHead = map.get(head);
//		// Think why cant we do like this-
//		while (origCurr != null) {
//
//			System.out.print(" " + origCurr.data);
//			cloneCurr = new Node();
//			cloneCurr.data = origCurr.data;
//			cloneCurr.next = origCurr.next; // clone will have same next as org but what we want is diff obj
//			cloneCurr.random = origCurr.random;
//
//			cloneCurr.next = createCopy(origCurr.next);
//			cloneCurr.random = createCopy(origCurr.random);
//			
//			origCurr = origCurr.next;
//			System.out.print(" " + cloneCurr.data);
//		}

		return cloneHead;
	}

	public void printLinkedList(Node head) {
		System.out.println();
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode.data + " " + currNode.random.data + "-->");
			// System.out.print(currNode.data+" ");
			// System.out.print(currNode.random.data+" ");
			currNode = currNode.next;
		}
	}

}
