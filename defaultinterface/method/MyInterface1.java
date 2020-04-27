package defaultinterface.method;

public interface MyInterface1 {
	public static int num = 100;

	public default void display() {
		System.out.println("display method of MyInterface");
	}
}
