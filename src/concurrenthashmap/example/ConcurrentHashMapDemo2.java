package concurrenthashmap.example;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo2 {
	public static void main(String[] args) 
    { 
        ConcurrentHashMap m=new ConcurrentHashMap(); 
        m.put(100,"Hello"); 
        m.put(101,"Geeks"); 
        m.put(102,"Geeks"); 
        m.put(null,"World"); 
        System.out.println(m); 
    } 
}
