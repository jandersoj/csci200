package string_linked_stack;

public class StringLinkedNode {
	private String element;
	private StringLinkedNode next; // next pointer
	
	StringLinkedNode(String elem) {
		element = elem;
	}
	
	String getElement() {
		return this.element;
	}
	StringLinkedNode getNext() {
		return this.next;
	}
	void setNext(StringLinkedNode n) {
		this.next = n;
	}
	void setElement(String e) {
		this.element = e;
	}
}
