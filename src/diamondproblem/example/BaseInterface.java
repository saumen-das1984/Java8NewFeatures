package diamondproblem.example;

public interface BaseInterface {
	default public void foo() {
		System.out.println("BaseInterface's foo");
	}
}
