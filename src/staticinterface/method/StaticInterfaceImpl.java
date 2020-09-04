package staticinterface.method;

public class StaticInterfaceImpl implements Interface1{
	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}
	
	public static void main(String args[]){
		StaticInterfaceImpl obj = new StaticInterfaceImpl();
		obj.print("xyz");
//		Interface1.print("");
		obj.isNull("abc");
	}
}
