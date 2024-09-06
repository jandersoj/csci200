package edu.unca.csci202;

import java.util.LinkedList;

public class BinaryTree {	
	private int key;
	private BinaryTree leftChild;
	private BinaryTree rightChild;
	
	public BinaryTree(int key, BinaryTree leftChild, BinaryTree rightChild) {
		this.key=key;
		this.leftChild=leftChild;
		this.rightChild=rightChild;
	}
	
	//a little birdie told me... i don't comment enough 
	
	public int product() {
		//I believe... this will require a traverse to get all the keys.. an iterate...
		//I am so clever wow how DO i do it!
		//this is ironic if you can't tell
		
		int product = 1;
		
		/**now I know I don't need a list here and could probably just do what I did with countInternalNodes
		 * and it might be faster? not sure. But I did not want to mess this one up in transit
		 * 5 minutes later: I tried, it did not work, and i don't have time to make it!
		 * but it's ok because my count is so pretty even though its recursive!
		 */
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		productTraverseInOrder(this, list);
		
		for(int i = 0; i < list.size(); i++) {
			product *= list.get(i);
		}
				
		return product;
	}
	
	private void productTraverseInOrder(BinaryTree node, LinkedList<Integer> list) {
		if(node != null) {
			productTraverseInOrder(node.leftChild, list); //visit left node
			list.add(node.key); //visit node itself, add key to list
			productTraverseInOrder(node.rightChild, list); //visit right node
		}
	}

	//complete this method
	public int countInternalNodes() {
		//hey this one will need it too!
		return countTraverse(this);
	}
	
	private int countTraverse(BinaryTree node) {
		
		if(node != null && !node.isLeaf()){
			int sum = 0;
			
			sum += countTraverse(node.leftChild); //visit left node
			sum += countTraverse(node.rightChild); //visit right node
		
			sum++; //don't forget this one!
		
			return sum; //then it goes all the way back up
		}
		
		return 0;
	}
	
	public boolean isLeaf() {
		if(this.leftChild == null && this.rightChild == null) {
			return true;
		}	
		return false;
	}
		
	public static void main(String[] args) {
		/*
		 * 			builds the following tree:
		 * 						1
		 * 		4							  5
		 * 		        33			    6
		 * 		    18                2   14
		 *        7   8
		 */
		BinaryTree leaf1=new BinaryTree(7,null,null);
		BinaryTree leaf2=new BinaryTree(8,null,null);
		BinaryTree leaf3=new BinaryTree(2,null,null);
		BinaryTree leaf4=new BinaryTree(14,null,null);
		BinaryTree node1=new BinaryTree(18,leaf1,leaf2);
		BinaryTree node2=new BinaryTree(6,leaf3,leaf4);
		BinaryTree node3=new BinaryTree(33,node1,null);
		BinaryTree node4=new BinaryTree(4,null,node3);
		BinaryTree node5=new BinaryTree(5,node2,null);
		BinaryTree root = new BinaryTree(1,node4,node5);
		
		System.out.println("internal nodes = "+root.countInternalNodes());//6
		System.out.println("product = "+root.product()); //111767040
	}
}
