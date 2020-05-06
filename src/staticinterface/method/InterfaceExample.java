package staticinterface.method;

public class InterfaceExample {
	public void demo() {
		System.out.println("This is the implementation of the demo method");
	}

	public static void main(String args[]) {
		InterfaceExample obj = new InterfaceExample();
		obj.demo();
		MyInterface.display();
	}
}
