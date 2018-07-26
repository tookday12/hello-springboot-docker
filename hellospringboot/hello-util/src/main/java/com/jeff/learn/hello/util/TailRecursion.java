package com.jeff.learn.hello.util;

import java.util.function.Function;
import java.util.stream.Stream;

@FunctionalInterface
public interface TailRecursion<T> {

	TailRecursion<T> apply();
	
	default boolean isFinished() {
		return false;
	}
	
	default T getResult() {
		throw new Error("TailRecursion not yet end");
	}
	
	default T invoke() {
		return Stream.iterate(this,TailRecursion::apply).filter(e -> e.isFinished()).findFirst().get().getResult();
	}
}
