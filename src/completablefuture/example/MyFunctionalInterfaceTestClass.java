package completablefuture.example;

import java.util.concurrent.CompletableFuture;

public class MyFunctionalInterfaceTestClass implements MyTestFunctionalInterface {

	@Override
	public CompletableFuture<MyFunctionalInterfaceTestClass> display() {
		CompletableFuture<MyFunctionalInterfaceTestClass> completableFuture = new CompletableFuture<MyFunctionalInterfaceTestClass>();
		System.out.println("Response back to client");
		return  completableFuture;
	}

}
