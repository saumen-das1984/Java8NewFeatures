package diamondproblem.example;

public class DiamondProblem implements Interface1, Interface2 {
	public void foo() {
		Interface1.super.foo();
	}

	public static void main(String[] args) {
		new DiamondProblem().foo();
	}
}
