package defaultinterface.method;

public class InterfaceExample1 implements MyInterface1 {
	public void display() {
		System.out.println("display method of class");
	}

	public static void main(String args[]) {
		InterfaceExample obj = new InterfaceExample();
		obj.display();
	}
}
