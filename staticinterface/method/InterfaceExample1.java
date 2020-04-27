package staticinterface.method;

public class InterfaceExample1 {
	public static void display() {
		System.out.println("Static method of the class");
	}

	public static void main(String args[]) {
//		InterfaceExample1 obj = new InterfaceExample1();
		MyInterface1.display();
		InterfaceExample1.display();
	}
}
