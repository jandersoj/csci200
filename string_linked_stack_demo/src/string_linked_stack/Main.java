package string_linked_stack;

public class Main {

	public static void main(String[] args) {
		StringLinkedStack stack = new StringLinkedStack();
		stack.push("Hi");
		stack.push("Kevin");
		System.out.println(stack);
		stack.push("Hello");
		System.out.println(stack);
		String element = stack.pop();
		System.out.println("popped: "+element);
		System.out.println(stack);
	}

}
