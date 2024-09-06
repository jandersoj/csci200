  package edu.unca.csci202;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

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
	 * Print the tree
	 */
	public String toString() {
		return print(root, 0);
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
		
	public boolean contains(T target) {

		if(traverseFind(root, target) != null) {
			T foundData = traverseFind(root, target).getData();		
			if(foundData == target) {
				return true;
			}
		}
		
		return false;
	}

	public T find(T targetElement) throws ElementNotFoundException {
		// implement this method
		// returns a reference to the specified element if found
		// throws the thing if it isn't found`
		
		if(traverseFind(root, targetElement) != null) {
			T foundData = traverseFind(root, targetElement).getData();		
			if(foundData == targetElement) {
				return foundData;
			}
		}
		
		throw new ElementNotFoundException("tree! :(");
	}
	
	/**Traverses a tree to locate a target element
	 * 
	 * @param node the "base" node from which the traversal starts
	 * @param target the element being searched for
	 * @return the node containing the target if found, otherwise null
	 */
	private BinaryTreeNode<T> traverseFind(BinaryTreeNode<T> node, T target){
		if(node != null) {
			if(node.getData() == target){//visit node itself
				return node;	
			} else {
				BinaryTreeNode<T> foundNode = traverseFind(node.getLeft(), target);
	            if(foundNode != null)
	            	return foundNode;
	            foundNode = traverseFind(node.getRight(), target);
	            if(foundNode != null)
	            	return foundNode;
			}
		}
		return null; 
	}
	
	/**Returns an iterator over a tree
	 * 
	 * @return an iterator over a tree
	 */
	public Iterator<T> iterator() {
		return iteratorInOrder();
	}

	/**Returns an iterator representing an inorder traversal over a tree
	 * 
	 * @return an iterator representing the traversal
	 */
	public Iterator<T> iteratorInOrder() {
		LinkedList<T> list = new LinkedList<T>();
		traverseInOrder(root, list);
		return list.iterator();
	}                                                                                                                          
	
	/**Recursive helper method for iteratorInOrder
	 * 
	 * @param node the root of the tree/subtree
	 * @param list the list that was built in iteratorInOrder
	 */
	private void traverseInOrder(BinaryTreeNode<T> node, LinkedList<T> list) {
		if(node != null) {
			traverseInOrder(node.getLeft(), list); //visit left node
			list.add(node.getData()); //visit node itself
			traverseInOrder(node.getRight(), list); //visit right node
		}
	}

	/**Returns an iterator representing a postOrder traversal over a tree
	 * 
	 * @return an iterator representing the traversal
	 */
	public Iterator<T> iteratorPostOrder() {
		// implement this method
		// see above but post order
		LinkedList<T> list = new LinkedList<T>();
		traversePostOrder(root, list);
		return list.iterator();
	}

	/**Recursive helper method for iteratorPostOrder
	 * 
	 * @param node the root of the tree/subtree
	 * @param list the list that was built in iteratorPostOrder
	 */
	private void traversePostOrder(BinaryTreeNode<T> node, LinkedList<T> list) {
		if(node != null) {
			traversePostOrder(node.getLeft(), list); //recurse left
			traversePostOrder(node.getRight(), list); //recurse right
			list.add(node.getData()); //visit node itself		
		}
	}
		
	@Override
	public Iterator<T> iteratorLevelOrder() {
		//implement this method
		// see above but levelorder
		LinkedList<T> list = new LinkedList<T>();
		traverseLevelOrder(root, list);
		return list.iterator();
	}
	
	/**
	 * Recursive helper method for iteratorPreOrder
	 * 
	 * @param node the root of the subtree
	 * @param list list that is built in preorder
	 */
	private void traverseLevelOrder(BinaryTreeNode<T> node, LinkedList<T> list) {
		if(node != null) {
			Deque<BinaryTreeNode<T>> q = new ArrayDeque<>();
			q.addLast(node);
			
			while(q.size() > 0) {
				BinaryTreeNode<T> current = q.removeFirst();
				list.addLast(current.getData());
				if(current.left != null) 
						q.addLast(current.left);	
				if(current.right != null) 
						q.addLast(current.right);	
			}
		}
	}
	
	
	public Iterator<T> iteratorPreOrder() {
		LinkedList<T> list = new LinkedList<T>();
		traversePreOrder(root, list);
		return list.iterator();
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


}
