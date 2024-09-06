package string_linked_stack;

public class StringLinkedStack {
	private StringLinkedNode top;
	
	public StringLinkedStack() {
		top = null;
	}
	
	public void push(String s) {
		StringLinkedNode n = new StringLinkedNode(s);
		n.setNext(top);
		top = n;
	}
	
	public String pop() {
		StringLinkedNode n = top;
		top = top.getNext();
		return n.getElement();
	}
	
	public String toString() {
		String out="";
		StringLinkedNode current = top;
		if (current==null) {
			out="[empty stack]";
		} else {
			while (current != null) {
				out+=current.getElement()+" ";
				current=current.getNext();
			}
		}
		return out;
	}
}
