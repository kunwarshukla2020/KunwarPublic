package com.mycode.trees;

import java.util.LinkedList;

class Node {
	int value;
	Node left;
	Node right;

	Node(int value) {
		this.value = value;
		left = null;
		right = null;
	}
}

class BinaryTree {
	Node root = null;

	/*BinaryTree() {
		root = null;
	}

	BinaryTree(int key) {
		root = new Node(key);
	}*/

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		System.out.print("InOrder:");
		bt.traverseInOrder(bt.root);
		System.out.print("\nPreOrder:");
		bt.traversePreOrder(bt.root);
		System.out.print("\nPostOrder:");
		bt.traversePostOrder(bt.root);
		System.out.print("\nBFS:");
		bt.traverseLevelOrder();
		System.out.print("\nBFS1:");
		bt.traverseLevelOrder1();
	}

    /*		6 
	      /   \ 
	     4      8 
	   /  \    /  \ 
	  3    5  7    9    
	
	OUTPUT-
	InOrder(Left, Root, Right): 3 4 5 6 7 8 9 
	PreOrder(Root, Left, Right): 6 4 3 5 8 7 9
	PostOrder(Left, Right, Root): 3 5 4 7 9 8 6
	BFS: 6 4 8 3 5 7 9
	BFS1:6 4 8 3 5 7 9 */
	 
	// Inserting Elements
	public void add(int value) {
		root = addRecursive(root, value);
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

	// The in-order traversal consists of first visiting the left sub-tree, then the root node, and finally the right
	// sub-tree: 3 4 5 6 7 8 9
	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.value);
			traverseInOrder(node.right);
		}
	}

	// Pre-order traversal visits first the root node, then the left subtree, and finally the right subtree: 6 4 3 5 8 7 9
	public void traversePreOrder(Node node) {
		if (node != null) {
			System.out.print(" " + node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}

	// Post-order traversal visits the left subtree, the right subtree, and the root node at the end: 3 5 4 7 9 8 6
	public void traversePostOrder(Node node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print(" " + node.value);
		}
	}

	// Breadth-First Search - 6 4 8 3 5 7 9
	public void traverseLevelOrder() {
		if (root == null) {
			return;
		}

		LinkedList<Node> nodes = new LinkedList<>();
		nodes.add(root);

		while (!nodes.isEmpty()) {

			Node node = nodes.remove();

			System.out.print(" " + node.value);

			if (node.left != null) {
				nodes.add(node.left);
			}

			if (node.right != null) {
				nodes.add(node.right);
			}
		}
	}

	//Same output as above- Breadth-First Search - 6 4 8 3 5 7 9
	void traverseLevelOrder1() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	
	/* * Compute the "height" of a tree -- the number of nodes along the longest path from the root node down to the farthest
	 * leaf node.*/
	 
	int height(Node root) {
		if (root == null)
			return 0;
		else {
			 //compute height of each subtree 
			int lheight = height(root.left);
			int rheight = height(root.right);

			// use the larger one 
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	// Print nodes at the given level 
	void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.value + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	// Finding an Element
	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}

	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		if (value == current.value) {
			return true;
		}
		return value < current.value ? containsNodeRecursive(current.left, value) : containsNodeRecursive(current.right, value);
	}

	
	/* * // Deleting an Element private Node deleteRecursive(Node current, int value) { if (current == null) { return null; }
	 * if (value == current.value) { // Node to delete found // ... code to delete the node will go here } if (value <
	 * current.value) { current.left = deleteRecursive(current.left, value); return current; } current.right =
	 * deleteRecursive(current.right, value); return current; }*/
	 
}
