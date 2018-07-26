package com.jeff.learn.hello.util;

@FunctionalInterface
public interface RecursionTemplate<T> {

	RecursionTemplate<T> get();
	
	default T getValue() {
		return null;
	}
}
