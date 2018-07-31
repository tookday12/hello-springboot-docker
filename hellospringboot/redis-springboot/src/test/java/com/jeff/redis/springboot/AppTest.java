package com.jeff.redis.springboot;

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

    public void swap(int i,int j) {
    	i=0;
    	j=0;
    }
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	new Pojo();
    }
}
