package edu.unca.csci202;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Binary Tree data structure
 *
 * @param <T>
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T> {	
	// instance variables
	protected BinaryTreeNode<T> root;
	protected int modCount; // 
	
	// Constructors
	public LinkedBinaryTree() {
		this.root = null;
	}
	public LinkedBinaryTree(T data) {
		this.root =  new BinaryTreeNode<T>(data);
	}
	public LinkedBinaryTree(T data, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
		this.root = new BinaryTreeNode<T>(data);
		if (left!=null) {
			this.root.setLeft( left.getRootNode()  );
		}
		if (right!=null) {
			this.root.setRight( right.getRootNode() );
		}
	}
	
	/**
	 * do a right rotation around subtree with root node
	 * typically this would be a protected helper method
	 * @return the node that will be this's parent's new child
	 */
	public BinaryTreeNode<T> rightRotation(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> replacement = node.left;
		//System.out.println("replacement = "+replacement.data);
		BinaryTreeNode<T> replacementOldRight = replacement.right;
		//System.out.println("replacementOldRight = "+replacementOldRight.data);

		replacement.right=node;
		//System.out.println("replacement.right = "+replacement.right.data);
		node.left=replacementOldRight;
		//System.out.println("this.left = "+node.left.data);
		
		return replacement;
	}
	
	
	protected int height(BinaryTreeNode<T> node) {
		if (node.left==null && node.right==null) {
			return 0;
		}
		int left=0;
		if (node.left!=null) {
			left=height(node.left);
		}
		int right=0;
		if (node.right!=null) {
			right=height(node.right);
		}
		return 1 + Math.max(left,right);
	}
	
	/**
	 * Print the tree
	 */
	public String toString() {
		//return print(root, 0);
		return printPretty();
	}
	
	/**
	 * 
	 */
	public String printPretty() {
		if (root==null) {
			return "";
		}
		String out="";
		int treeHeight=height(root);
		
		//System.out.println("height="+treeHeight);
		// create an array-based binary tree with our nodes
		// missing nodes will be null in the array
		int arraySize=(int)Math.round(Math.pow(2, treeHeight+1))-1;
		Object[] array = new Object[arraySize];
		array[0]=root;
		
		// create an array of positions where each node will be printed
		// fill it in for lowest level, then subsequent levels toward root
		// are at position that is the average of their two children
		int[] positions = new int[arraySize];
		int spacesBetweenLowestLevel=6;
		int leftMostLeaf=(int)Math.round(Math.pow(2, treeHeight))-1;
		int currentPosition=1;//spacesBetweenLowestLevel;
		// fill in positions of leaf level
		for (int i=leftMostLeaf; i<arraySize; i++) {
			positions[i]=currentPosition;
			currentPosition+=spacesBetweenLowestLevel;
		}
		//now fill in subsequent levels
		for (int i=leftMostLeaf-1; i>=0; i--) {
			int leftChild=2*i+1;
			int rightChild=2*(i+1);
			positions[i]=(positions[leftChild]+positions[rightChild])/2;
		}
		
		for (int i=0; i<array.length; i++) {
			if (array[i]!=null) {
				if (((BinaryTreeNode<T>)array[i]).left!=null) {
					int leftChildIndex=2*i+1;
					array[leftChildIndex]=((BinaryTreeNode<T>)array[i]).left;
				}
				if (((BinaryTreeNode<T>)array[i]).right!=null) {
					int rightChildIndex=2*(i+1);
					array[rightChildIndex]=((BinaryTreeNode<T>)array[i]).right;
				}
			}
		}

		int level=0;
		int nodesThisLevel=1;
		int nodeCounter=0;
		currentPosition=0;
		for (int i=0; i<array.length; i++) {
			String data=" ";
			if (array[i]!=null) {
				data=((BinaryTreeNode<T>)array[i]).getData().toString();
			}
			int spaces=positions[i]-currentPosition-1;
			//System.out.print(nSpaces(spaces)+data);
			out+=nSpaces(spaces)+data;
			currentPosition=positions[i];
			nodeCounter++;
			if (nodeCounter>=nodesThisLevel) {
				nodeCounter=0;
				level++;
				nodesThisLevel*=2;
				currentPosition=0;
				//System.out.println();
				out+="\n";
			}
		}
		//System.out.println();
		return out;
	}
	
	private String nSpaces(int n) {
		String out="";
		for (int i=0; i<n; i++) {
			out+=" ";
		}
		return out;
	}
	
	/** 
	 * Print a subtree
	 */
	String print(BinaryTreeNode<T> node, int level) {
		String ret = "";
		if(node != null) {
			for(int i=0;i<level;i++) {
				ret += "\t";
			}
			ret += node.getData();
			ret += "\n";
			// recurse left
			ret += print(node.getLeft(), level+1);
			// recurse right
			ret += print(node.getRight(), level+1);
		}
		return ret;
	}
	
	
	/** return the root node of this subtree
	 * 
	 * @return root node of sub tree
	 */
	public BinaryTreeNode<T> getRootNode(){
		return this.root;
	}
	

	@Override
	public T getRootElement() {
		if(root == null) {
			return null;
		}
		return this.root.getData();
	}

	@Override
	public boolean isEmpty() {
		if(root == null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		return root.countDescendants() + 1;
	}
	@Override
	public boolean contains(T targetElement) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public T find(T targetElement) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterator<T> iteratorInOrder() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	@Override
	public Iterator<T> iteratorPostOrder() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterator<T> iteratorLevelOrder() {
		System.out.println("height="+height(root));
//		LinkedList<T> output = new LinkedList<T>();
//		Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
//		queue.add(root);
//		while (!queue.isEmpty()) {
//			
//		}
		
		return null;
	}

	@Override
	public Iterator<T> iteratorPreOrder() {
		LinkedList<T> list = new LinkedList<T>();
		traversePreOrder( root, list);
		//return list.iterator();
		// alternative version using inner TreeIterator class
		// this would properly handle concurrent modification 
		return new TreeIterator(list.iterator());
	}

	/**
	 * Recursive helper method for iteratorPreOrder
	 * 
	 * @param node the root of the subtree
	 * @param list list that is built in preorder
	 */
	private void traversePreOrder(BinaryTreeNode<T> node, LinkedList<T> list) {
		if(node != null) {
			// visit node
			list.add( node.getData() );
			//recurse left
			traversePreOrder( node.getLeft(), list);
			//recurse right
			traversePreOrder( node.getRight(), list);
		}
	}
	
	/**
	 * Inner class to represent an iterator over the elements of this tree
	 */
	private class TreeIterator implements Iterator<T>
	{
		private int expectedModCount;
		private Iterator<T> iter;

		/**
		 * Sets up this iterator using the specified iterator.
		 *
		 * @param iter the list iterator created by a tree traversal
		 */
		public TreeIterator(Iterator<T> iter)
		{
			this.iter = iter;
			expectedModCount = modCount;
		}

		/**
		 * Returns true if this iterator has at least one more element
		 * to deliver in the iteration.
		 *
		 * @return  true if this iterator has at least one more element to deliver
		 *          in the iteration
		 * @throws  ConcurrentModificationException if the collection has changed
		 *          while the iterator is in use
		 */
		public boolean hasNext() throws ConcurrentModificationException
		{
			if (!(modCount == expectedModCount))
				throw new ConcurrentModificationException();

			return (iter.hasNext());
		}

		/**
		 * Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iterator is empty
		 */
		public T next() throws NoSuchElementException
		{
			//System.out.println("next!");
			if (hasNext())
				return (iter.next());
			else 
				throw new NoSuchElementException();
		}

		/**
		 * The remove operation is not supported.
		 * 
		 * @throws UnsupportedOperationException if the remove operation is called
		 */
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
}
