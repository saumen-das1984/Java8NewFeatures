package exmsupplier.lambdaexp;

import java.util.function.Supplier;

public class SupplierLambda1 {
	public static void main(String[] args) {
	    Supplier<String> i  = ()-> "java2s.com";
	    
	    System.out.println(i.get());
	  }
}
