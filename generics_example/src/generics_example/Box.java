package generics_example;

public class Box<T> {
	private T thing;
	
	public Box(T thing) {
		this.thing=thing;
	}
	
	public T getThing() {
		return thing;
	}
}
