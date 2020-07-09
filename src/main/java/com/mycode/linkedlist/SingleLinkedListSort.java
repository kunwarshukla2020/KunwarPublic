package com.mycode.linkedlist;

import java.util.ArrayList;
import java.util.Collections;

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

//merge two sorted linklist
//https://www.youtube.com/watch?v=j_UNYW6Ap0k
class SingleLinkedListSort {

	Node2 head = null; // root node - head of list
	Node2 tail = null;

	public static void main(String[] args) {
		SingleLinkedListSort l1 = new SingleLinkedListSort();
		l1.add(1);
		l1.add(2);
		l1.add(4);
		l1.printLinkedList();
		SingleLinkedListSort l2 = new SingleLinkedListSort();
		l2.add(1);
		l2.add(3);
		l2.add(4);
		
		SingleLinkedListSort l3 = mergeTwoLists(l1, l2);
		l3.printLinkedList();
	}

	// 10
	public static SingleLinkedListSort mergeTwoLists(SingleLinkedListSort l1, SingleLinkedListSort l2) {

		ArrayList<Integer> a1 = new ArrayList();
		ArrayList<Integer> a2 = new ArrayList();
		Node2 currNode1 = l1.head;
		Node2 currNode2 = l2.head;
		while (currNode1 != null) {
			a1.add(currNode1.data);
			currNode1 = currNode1.next;
		}
		System.out.println(a1);
		while (currNode2 != null) {
			a2.add(currNode2.data);
			currNode2 = currNode2.next;
		}
		System.out.println(a2);
		a1.addAll(a2);
		Collections.sort(a1);
		Collections.reverse(a1);
		System.out.println(a1);

		SingleLinkedListSort l3 = new SingleLinkedListSort();
		
		Node2 newNode = null;
		for (int i : a1) {
			newNode = new Node2(i, newNode);
		}
		l3.head = newNode;
		return l3;
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
