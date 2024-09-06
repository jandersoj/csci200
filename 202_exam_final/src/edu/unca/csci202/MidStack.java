package edu.unca.csci202;

public class MidStack<T> implements MidStackADT<T> {

	private int length; //includes top and bottom ofc
	private Node top;
	private Node bottom; //do I want this??? yes
	
	
	public MidStack() {
		top = null;
		bottom = null;
		
		length = 0;
//		bottom = null;
	}
	
	@Override
	public int size() {
		return length;
	}

	@SuppressWarnings("unchecked") //chill out baby (the code) its not that deep 
	@Override
	public void pushTop(T element) {

		Node<T> node = new Node<T>(element);
		
		if(bottom == null) {
			bottom = node;
			System.out.println("set bottom: "+bottom.getElement());
		}	
		
		
		if(top != null) {
			Node<T> temp = top;
			temp.setPrev(node);
		}
	
		top = node;
		node.setNext(top);
		
		length++;
	}

	@Override
	public T popTop() {
		
		if(top == null) {
			return null;
		} //if we're at this point it means there's at least one thing on the stack
		T output = (T)top.getElement(); //idk why it is giving me an error here to make output an object??
		top = top.getNext();

		length--;
		return output;
	}

	@Override
	public void pushMid(T element) { // I KNOW ITS IN THE WRONG MIDDLE
		Node<T> node = new Node<T>(element);
		Node<T> curr = bottom;
		System.out.println("len: "+length);
		
		for(int i = 0; i < Math.ceil(length/2)-1; i++) { //NOT java.util don't worry!
			curr = curr.getPrev();
			System.out.println("curr: "+curr.getElement());
		}	
		
	
		System.out.println("curr: "+curr.getElement());
		
		Node<T> temp = curr.getPrev();
		System.out.println("temp: "+temp.getElement());
		
		temp.setNext(node);
		curr.setPrev(node);
		
		node.setPrev(temp);
		node.setNext(curr);
		
		// TODO Auto-generated method stub

	}

	@Override
	public T popMid() { //AHHHH ALMOST THERE
		Node<T> curr = bottom;
		System.out.println("len: "+length);
		
		for(int i = 0; i < Math.ceil(length/2)-1; i++) { //NOT java.util don't worry!
			curr = curr.getPrev();
			System.out.println("curr: "+curr.getElement());
		}	
		
		Node<T> prev = curr.getNext();
		prev = prev.getNext();
		
		System.out.println("prev: "+prev.getElement());
		
		Node<T> node = curr.getNext();
	
		System.out.println("node: "+node.getElement());
		
		Node<T> temp = curr.getPrev();
		System.out.println("temp: "+temp.getElement());
		return null;
	}

	public String toString() {
		Node<T> curr = bottom;
		String out = "[";
		
		for(int i = 0; i < Math.ceil(length/2); i++) { //NOT java.util don't worry!
			out += curr.getElement() + ", ";
			curr = curr.getPrev();
		}	
		out+= curr.getElement() + "*, ";
		curr = curr.getPrev();
		while(curr.getNext()!= top) {
			out += curr.getElement() + ", ";
			curr = curr.getPrev();
		}
		out += curr.getElement() + "]";
		
		return out;
	}
}
