package staticinterface.method;

public interface Interface1 {
	default void print(String str) {
		if (!isNull(str))
			System.out.println("Interface1 Print::" + str);
	}

	static boolean isNull(String str) {
		System.out.println("Interface Null Check");

		return str == null ? true : "".equals(str) ? true : false;
	}
}
