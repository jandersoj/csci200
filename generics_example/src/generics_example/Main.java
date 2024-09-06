package generics_example;

public class Main {

	public static void main(String[] args) {
		Box<String> stringBox = new Box<String>("Hi");
		Box<String> stringBox2 = new Box("Kevin");//deduces type
		Box<Integer> integerBox = new Box<Integer>(7);//autoboxed int to Integer
		
		System.out.println(stringBox2.getThing());
		System.out.println(integerBox.getThing());
	}

}
