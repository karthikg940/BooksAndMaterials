package com.virtusa.morepoints;

import java.util.Collection;

public class Pair<K,V> {

	private K key;
	private V value;
	
	public Pair(K key,V value){
		this.key=key;
		this.value=value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	
}


class Util{
	public static <K,V> void m1(Pair<K,V> pair){
		
	}
}

class Z{
	public T Z<T> m1(Collection<T> c){
		return null;
	}
}

class Y<T> extends Z{
	public Z m1(Collection c){
		return null;
	}
}