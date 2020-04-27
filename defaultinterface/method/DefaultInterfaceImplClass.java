package defaultinterface.method;

public class DefaultInterfaceImplClass implements Interface1, Interface2{

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	@Override
	public void log(String str){
		System.out.println("DefaultInterfaceImplClass logging::"+str);
		Interface1.super.log("abc");
	}
	
	public static void main(String args[]) 
    { 
		DefaultInterfaceImplClass d = new DefaultInterfaceImplClass(); 
        d.log("Test Default Interface"); 
    } 

}
