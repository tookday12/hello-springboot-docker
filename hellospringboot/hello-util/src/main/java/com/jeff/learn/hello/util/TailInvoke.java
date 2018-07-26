package com.jeff.learn.hello.util;

public class TailInvoke {

	public static <T> TailRecursion<T> call(final TailRecursion<T> nextFrame){
		return nextFrame;
	}
	
	public static <T> TailRecursion<T> done(T value){
		return new TailRecursion<T>() {

			@Override
			public TailRecursion<T> apply() {
				 throw new Error("recersion end!!!");
			}
			
			 @Override
			  public boolean isFinished() {
				 return true;
			  }
			 
			  @Override
			  public T getResult() {
			  return value;
			  }
			
			
		};
	}
}
