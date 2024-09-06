package edu.unca.csci202;

public class Node<T> {
	
	private Node<T> prev; //prev is higher on the stack
	private Node<T> next; //and next is lower
	private T element;

	public Node(T input) {
		next = null;
		element = input;
	}

	public Node<T> getNext()
	{
		return next;
	}

	public void setNext(Node<T> node)
	{
		next = node;
	}
	
	public Node<T> getPrev()
	{
		return prev;
	}

	public void setPrev(Node<T> node)
	{
		prev = node;
	}
	
	public T getElement()
	{
		return element;
	}
	
	public void setElement(T elem)
	{
		element = elem;
	}

}
