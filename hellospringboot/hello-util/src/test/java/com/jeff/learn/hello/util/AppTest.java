package com.jeff.learn.hello.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testTailRecursion()
    {
    	System.out.println(factorialTailRecursion(0,100000).invoke());
    	factorialTailRecursion1(0,100000);
    }
    
    
    
    
    public void testTailRecursion1()
    {
    	int sum=Stream.iterate(sumArray(100,0),RecursionTemplate::get).filter(e -> e.getValue()!=null)
    	.findFirst().get().getValue();
    	System.out.println(sum);
    }
    
    
    public RecursionTemplate<Integer> sumArray(int max,int sum){
    	switch(max) {
    	case 0:
    		return new RecursionTemplate<Integer>() {
				
				@Override
				public RecursionTemplate<Integer> get() {
					return null;
				}

				@Override
				public Integer getValue() {
					return sum;
				}
			};
    	default:
    		return new RecursionTemplate<Integer>() {
				
				@Override
				public RecursionTemplate<Integer> get() {
					return sumArray(max-1,sum+max);
				}
			};
    	}
    }
    
    
    
    
    public void testHash()
    {
    	Set<HashNoe> set=new HashSet<>();
    	set.addAll(Arrays.asList(new HashNoe(3,"keep"),new HashNoe(3,"keep")));
    	System.out.println(set.size());
    }
    
    static TailRecursion<Integer> factorialTailRecursion(int factorial,int number){
    	switch(number) {
    	case 1:
    		return TailInvoke.done(factorial);
    	default:
    		return TailInvoke.call(() -> factorialTailRecursion(factorial+number,number-1));
    	}
    }
    
    static void factorialTailRecursion1(int factorial,int number) {
    	switch(number) {
    	case 1:
    		 break;
    	default:
    		factorialTailRecursion1(factorial+number,number-1);
    	}
    }
    
   
}
