package string_array_stack;

/**
 * A stack of String objects
 * implemented using an array
 * 
 * @author Kevin Sanft
 *
 */
public class StringArrayStack {
	private String[] data;
	private int capacity;
	private final int DEFAULT_CAPACITY=4;
	private int size;
	
	/**
	 * set the capacity to the default value
	 */
	public StringArrayStack() {
		capacity=DEFAULT_CAPACITY;
		data = new String[capacity];
		size = 0;
	}
	
	/**
	 * insert an element at the top of the stack
	 * (expand capacity if necessary)
	 * 
	 * @param str the String to insert into the stack
	 */
	public void push(String str) {
		if (size==capacity) {
			capacity*=2;
			String[] temp = new String[capacity];
			for (int i=0; i<data.length; i++) {
				temp[i]=data[i];
			}
			data = temp;
		}
		data[size] = str;
		size++;
	}
	
	public String pop() {
		if (size==0) {
			throw new ArrayIndexOutOfBoundsException("Stack is empty");
		}
		size--;
		return data[size];
	}
	
	public String peek() {
		if (size==0) {
			throw new ArrayIndexOutOfBoundsException("Stack is empty");
		}
		return data[size-1];
	}
	
	public String toString() {
		if (size==0) {
			return "[Empty Stack]";
		}
		String out = "";
		for (int i=0; i<size; i++) {
			out += data[i]+" ";
		}
		return out;
	}
}
