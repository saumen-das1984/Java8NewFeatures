package concurrenthashmap.example;

import java.util.HashMap;

public class HashMapDemo1 {
	public static void main(String[] args) 
    { 
        HashMap m=new HashMap(); 
        m.put(100,"Hello"); 
        m.put(101,"Geeks"); 
        m.put(102,"Geeks"); 
        m.put(null,"World"); 
        m.put(103,null);
        m.put(null,null);
        System.out.println(m); 
    } 
}
