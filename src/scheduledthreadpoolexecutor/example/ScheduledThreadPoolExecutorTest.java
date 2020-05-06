package scheduledthreadpoolexecutor.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {
	public static void main(String... args) throws InterruptedException, ExecutionException {
		int corePoolSize = 2;
		// creates ScheduledThreadPoolExecutor object with number of thread 2
		ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(corePoolSize);
		// starts runnable thread
		stpe.execute(new ScheduledThreadPoolExecutorTest().new RunnableThread());
		// starts callable thread that will start after 20 seconds
		ScheduledFuture<Integer> sf = stpe.schedule(new ScheduledThreadPoolExecutorTest().new CallableThread(), 20,TimeUnit.SECONDS);
		// gets value returned by callable thread
		int res = sf.get();
		System.out.println("value returned by Callable Thread." + res);
		// returns active thread
		int activeCnt = stpe.getActiveCount();
		System.out.println("activeCnt:" + activeCnt);
		// stops all the threads in ScheduledThreadPoolExecutor
		stpe.shutdownNow();
		System.out.println(stpe.isShutdown());
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

	// callable thread that will return value
	class CallableThread implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			int cnt = 0;
			for (; cnt < 5; cnt++) {
				System.out.println("call:" + cnt);
			}
			return cnt;
		}
	}
}