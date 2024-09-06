package edu.unca.csci202;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		//test BinaryTreeNode class
//		BinaryTreeNode<String> leaf1 = new BinaryTreeNode<String>("leaf1");
//		BinaryTreeNode<String> leaf2 = new BinaryTreeNode<String>("leaf2");
//		BinaryTreeNode<String> internal1 = new BinaryTreeNode<String>("internal1",leaf1,leaf2);
//
//		BinaryTreeNode<String> leaf3 = new BinaryTreeNode<String>("leaf3");
//		BinaryTreeNode<String> internal2 = new BinaryTreeNode<String>("internal2",leaf3,null);
//				
//		BinaryTreeNode<String> root = new BinaryTreeNode<String>("root",internal1,internal2);
//
//		System.out.println("access leaf2..."+root.getLeft().getRight().getData());
//		
//		System.out.println("root.numChildren()="+root.numChildren());

		
		//test LinkedBinaryTree class
		// Make the leaves
		LinkedBinaryTree<String> D = new LinkedBinaryTree<String>("D");
		LinkedBinaryTree<String> E = new LinkedBinaryTree<String>("E");
		LinkedBinaryTree<String> C = new LinkedBinaryTree<String>("C");

		// make sub-tree
		LinkedBinaryTree<String> B = new LinkedBinaryTree<String>("B", D, E);

		// make the root tree
		LinkedBinaryTree<String> A = new LinkedBinaryTree<String>("A", B, C);
		
		System.out.println(A);
		
		System.out.print("PreOrder: ");
		Iterator<String> itr = A.iteratorPreOrder();
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();

	}

}
