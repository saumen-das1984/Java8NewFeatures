package scheduledthreadpoolexecutor.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import scheduledthreadpoolexecutor.example.ScheduledThreadPoolExecutorTest.RunnableThread;

public class NewSingleThreadExecutorTest {
	public static void main(final String... args) throws InterruptedException, ExecutionException {
		// creates thread pool with one thead
		final ExecutorService exService = Executors.newSingleThreadExecutor();
		// callable thread starts to execute
		final Future<Integer> callFuture = exService.submit(new NewSingleThreadExecutorTest().new CallableThread());
		// gets value of callable thread
		
		// checks for thread termination
		final boolean isTerminated = exService.isTerminated();
		System.out.println(isTerminated);
		// waits for termination for 30 seconds only
		exService.awaitTermination(30, TimeUnit.SECONDS);
		final int callval = callFuture.get();
		System.out.println("Callable:" + callval);
		
		// starts runnable thread
		exService.execute(new NewSingleThreadExecutorTest().new RunnableThread());
				
		exService.shutdownNow();
		System.out.println(exService.isShutdown());
	}
	
	// runnable thread
		class RunnableThread implements Runnable {
			@Override
			public void run() {
				int cnt = 0;
				for (; cnt < 5; cnt++) {
					System.out.println("run:" + cnt);
				}
			}
		}

	// Callable thread
	class CallableThread implements Callable<Integer> {
		@Override
		public Integer call() {
			int cnt = 0;
			for (; cnt < 5; cnt++) {
				System.out.println("call:" + cnt);
			}
			return cnt;
		}
	}
}
