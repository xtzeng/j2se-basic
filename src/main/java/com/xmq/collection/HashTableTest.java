package com.xmq.collection;

import java.util.Enumeration;
import java.util.Hashtable;



public class HashTableTest {

	public static void main(String[] args) {
		Hashtable<String, Object> hashtable  = new Hashtable<String, Object>();
		hashtable.put("用户1", new Integer(90));
		hashtable.put("用户2", new Integer(50));
		hashtable.put("用户3", new Integer(60));
		
		Enumeration enumeration = hashtable.elements();
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
	}
}
