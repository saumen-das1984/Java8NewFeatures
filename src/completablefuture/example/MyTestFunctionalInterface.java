package completablefuture.example;

import java.util.concurrent.CompletableFuture;

@FunctionalInterface
public interface MyTestFunctionalInterface {
	CompletableFuture<MyFunctionalInterfaceTestClass> display();
}
