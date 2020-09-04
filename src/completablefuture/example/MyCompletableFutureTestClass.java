package completablefuture.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MyCompletableFutureTestClass {

public static void main(String[] args) {
	System.out.println("I'll run in a separate thread10 than the main thread.");
	CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
	    // Simulate a long-running Job   
	    try {
	        TimeUnit.SECONDS.sleep(10);
	    } catch (InterruptedException e) {
	        throw new IllegalStateException(e);
	    }
	    System.out.println("I'll run in a separate thread than the main thread.");
	});
}
	
	
	
}
