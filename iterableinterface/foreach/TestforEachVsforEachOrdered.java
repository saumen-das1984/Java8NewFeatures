package iterableinterface.foreach;

public class TestforEachVsforEachOrdered {
	public static void main(String[] args) {

		System.out.println("Using forEach()");
		String str = "Saumen Das";
		str.chars().forEach(n -> System.out.print((char) n));

		/* forEach() method performs an action for each element of this stream. 
		 For parallel stream, this operation does not guarantee to maintain order of the stream.*/
		System.out.println("\n\nUsing parallel() + forEach()");
		str.chars().parallel().forEach(n -> System.out.print((char) n));

		/* forEachOrdered() method performs an action for each element of this stream, 
		 guaranteeing that each element is processed in encounter order for streams that have a defined encounter order. */
		System.out.println("\n\nUsing parallel() + forEachOrdered()");
		str.chars().parallel().forEachOrdered(n -> System.out.print((char) n));
	}
}
