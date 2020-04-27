package exmconsumer.lambdaexp;

import java.util.function.Consumer;

public class ConsumerAccept {
	public static void main(String[] args) {
		Consumer<String> c = (x) -> System.out.println(x.toLowerCase());
		c.accept("Google.com");
	}
}
