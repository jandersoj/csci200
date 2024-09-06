
public class Main {

	public static void printListIterative(LinearNode head) {
		//iterative version
		LinearNode current=head;
		while (current!=null) {
			System.out.print(current.getElement());
			if (current.getNext()!=null) {
				System.out.print(", ");
			}
			current=current.getNext();
		}
		System.out.println();
	}
	
	public static void printListRecursive(LinearNode head) {
		//System.out.println("printListRecursive not implemented.");
		if (head==null) {
			System.out.println();
		} else if (head.getNext()==null){
			System.out.println(head.getElement());
		} else {
			System.out.print(head.getElement()+", ");
			printListRecursive(head.getNext());
		}
	}
	
	// helper variable to print newline at the end (not thread safe)
	// could do similar with a helper method
	private static int funCalls=0; 
	public static void printListReverseRecursive(LinearNode head) {
		boolean printNewline=false;
		if (funCalls==0) {
			printNewline=true;
		}
		funCalls++;
		//System.out.println("printListRecursive not implemented.");
		if (head==null) {
			System.out.println();
		} else if (head.getNext()==null){
			System.out.print(head.getElement());
		} else {
			printListReverseRecursive(head.getNext());
			System.out.print(", "+head.getElement());
		}
		if (printNewline) {
			System.out.println();
			funCalls=0;//reset
		}
		
	}
	
	public static LinearNode reverseList(LinearNode oldHead) {
		//base cases: empty list or size 1 list
		if (oldHead==null || oldHead.getNext()==null) {
			return oldHead;
		}
		
		LinearNode newHead = reverseList(oldHead.getNext());
		// make element that used to be the 2nd element point to the old head
		oldHead.getNext().setNext(oldHead);
		//oldHead is the last element, so it points to null
		oldHead.setNext(null);
		return newHead;
	}
	
	public static void main(String[] args) {
		// create a linked list
		LinearNode n1 = new LinearNode(1);
		LinearNode n2 = new LinearNode(2);
		LinearNode n3 = new LinearNode(3);
		LinearNode n4 = new LinearNode(4);
		LinearNode n5 = new LinearNode(5);
		LinearNode n6 = new LinearNode(6);
		LinearNode n7 = new LinearNode(7);
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		
		//alias n1 as head
		LinearNode head = n1;
		printListIterative(head);
		printListRecursive(head);
		head = reverseList(head);
		System.out.println("printing reversed list:");
		printListIterative(head);
		printListRecursive(head);
		
		//time permitting: write a recursive method that prints the list in reverse
		// (without actually reversing the list)
		System.out.println("now print in reverse (without reversing):");
		printListReverseRecursive(head);
		System.out.println("done.");
	}

}
