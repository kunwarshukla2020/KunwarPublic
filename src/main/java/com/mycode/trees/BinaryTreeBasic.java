package com.mycode.trees;

class Node1 {
	int value;
	Node1 left;
	Node1 right;

	Node1(int value) {
		this.value = value;
		left = null;
		right = null;
	}
}

class BinaryTreeBasic {
	Node1 root;

	BinaryTreeBasic() {
		root = null;
	}

	BinaryTreeBasic(int key) {
		root = new Node1(key);
	}

	public static void main(String[] args) {
		BinaryTreeBasic bt = new BinaryTreeBasic();
		
		bt.root = new Node1(1); //create root
		/*    1 
	        /   \ 
	      null  null  */
		
		bt.root.left = new Node1(2);
		bt.root.right = new Node1(3);
		/* 2 and 3 become left and right children of 1 
		        1 
		      /   \ 
		     2      3 
		   /    \    /  \ 
		 null null null null  */

		bt.root.left.left = new Node1(4);
		/* 4 becomes left child of 2 
			        1 
			    /       \ 
			   2          3 
			 /   \       /  \ 
			4    null  null  null 
		  /   \ 
		null null   */

	}
}
