package com.mycode.practice;

import java.util.ArrayList;
import java.util.LinkedList;

class Node{
	int value;
	Node right, left;
	
	Node(int i){
		value = i;
	}
}

/*		6 
      /   \ 
     4      8 
   /  \    /  \ 
  3    5  7    9    
*/
public class MyTest {
	Node root =null;
	
	public static void main(String[] args) {
		MyTest bt = new MyTest();
		bt.root = bt.addRecursive(bt.root, 6);
		bt.addRecursive(bt.root,4);
		bt.addRecursive(bt.root,8);
		bt.addRecursive(bt.root,3);
		bt.addRecursive(bt.root,5);
		bt.addRecursive(bt.root,7);
		bt.addRecursive(bt.root,9);
		bt.bft(bt.root);
	}

	private void bft(Node currNode) {
		LinkedList<Node> ls = new LinkedList(); 
		ls.add(currNode);
		
		while(!ls.isEmpty()) {
			Node t = ls.remove();
			if(t!=null) {
				System.out.println(" "+t.value);
				ls.add(t.left);
				ls.add(t.right);
			}
			
		}
	}

	
	
	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}


}

