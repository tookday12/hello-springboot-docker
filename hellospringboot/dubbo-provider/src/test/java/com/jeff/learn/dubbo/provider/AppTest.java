package com.jeff.learn.dubbo.provider;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import com.google.common.collect.Sets;

//import com.google.common.collect.Sets;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	protected final Logger logger=LogManager.getLogger(this.getClass());
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
    public void testApp()
    {
        System.out.println(sumArray(Arrays.asList(1,2,3,4,8,9), Arrays.asList(0,1,4),0));
    }
    
    public void testResource()
    {
    	Enumeration<URL> urls;
		try {
			urls = this.getClass().getClassLoader().getResources("META-INF/spring.factories");
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				System.out.println(url.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void testSum()
    {
    	List<Integer> l=new ArrayList<>();
    	IntStream.range(0, 10000).forEach(e -> l.add(e));
        System.out.println(sumArray(Arrays.asList(6,9),Arrays.asList(0,1),0));
    }
    
    public void testLogger()
    {
    	String nullS=null;
    	logger.warn("jjkl1");
    	
    	logger.info("w :{}",() -> nullS.length());
    	logger.warn("jjkl2");
    	
    	logger.info("w :{}",nullS.length());
    	logger.warn("jjkl3");
    }
    
    public void testBaccret()
    {
    	List<Integer> list=Arrays.asList(1,0,6,1,5);
        List<Integer> bankerPoints=getBankerPoint(list);
        List<Integer> playerPoints=getPlayerPoint(list);
        List<Integer> thirdPoints=getThirdPoints(list);
        playerPoints=fillPlayerThirdPoint(bankerPoints, playerPoints, thirdPoints);
        bankerPoints=fillBankerThirdPoint(bankerPoints, playerPoints, thirdPoints);
        System.out.println(bankerPoints);
        System.out.println(playerPoints);
    }
    
    int max(List<Integer> l) {
		if(l.size()==1) {
			return l.get(0);
		}else {
			return Integer.max(l.get(0), max(l.subList(1, l.size())));
		}
	}
    
    int tailSum(List<Integer> l,int sum) {
    	if(l.isEmpty()) {
    		return sum;
    	}else{
    		return tailSum(l.subList(1, l.size()),sum+l.get(0));
    	}
    }
    
    int sum(List<Integer> l) {
    	if(l.isEmpty()) {
    		return 0;
    	}else{
    		return l.get(0)+sum(l.subList(1, l.size()));
    	}
    }
    
    List<Integer> getBankerPoint(List<Integer> l) {
    	return new ArrayList<Integer>(l.subList(0, 2));
    }

    List<Integer> getPlayerPoint(List<Integer> l) {
    	return new ArrayList<Integer>(l.subList(3,5));
    }
    
    List<Integer> getThirdPoints(List<Integer> l) {
    	return Arrays.asList(sumArray(l, Arrays.asList(4,2),0)%10,sumArray(l, Arrays.asList(0,2),0)%10);
    }
    
    List<Integer> fillPlayerThirdPoint(List<Integer> bankerPoints,List<Integer> playerPoints,List<Integer> thirdPoints) {
    	if(sumArray(bankerPoints,Arrays.asList(0,1),0)%10>=8) {
    		return playerPoints;
    	}
    	if(sumArray(playerPoints,Arrays.asList(0,1),0)%10>=6) {
    		return playerPoints;
    	}
    	playerPoints.add(thirdPoints.get(0));
    	return playerPoints;
    }
    
    List<Integer> fillBankerThirdPoint(List<Integer> bankerPoints,List<Integer> playerPoints,List<Integer> thirdPoints) {
    	Map<Integer,Set<Integer>> map=new HashMap<>();
    	map.put(3, Sets.newHashSet(3));
    	map.put(4, Sets.newHashSet(0,1,8,9));
    	map.put(5, Sets.newHashSet(0,1,2,3,8,9));
    	map.put(6, Sets.newHashSet(6,7));
    	if(sumArray(playerPoints,Arrays.asList(0,1),0)%10>=8) {
    		return bankerPoints;
    	}
    	if(sumArray(bankerPoints,Arrays.asList(0,1),0)%10>=7) {
    		return bankerPoints;
    	}
    	boolean getThirdPoint=false;
    	if(sumArray(bankerPoints,Arrays.asList(0,1),0)%10<=2) {
    		getThirdPoint=true;
    	}else {
    		int sum=sumArray(bankerPoints,Arrays.asList(0,1),0)%10;
    		switch(sum){
    		case 3:
    		case 4:
    		case 5:
    			getThirdPoint=!map.get(sum).contains(getPlayerThirdPoint(playerPoints));
    			break;
    		case 6:
    			getThirdPoint=map.get(sum).contains(getPlayerThirdPoint(playerPoints));
    			break;
    		}
    	}
    	
    	if(getThirdPoint) {
    		bankerPoints.add(getBankerThirdPoint(playerPoints,thirdPoints));
    	}
    	
    	return bankerPoints;
    }
	
    int getBankerThirdPoint(List<Integer> playerPoints,List<Integer> thirdPoints) {
    	if(playerPoints.size()==3) {
    		return thirdPoints.get(1);
    	}else {
    		return thirdPoints.get(0);
    	}
    }
    
    int getPlayerThirdPoint(List<Integer> playerPoints) {
    	if(playerPoints.size()==3) {
    		return playerPoints.get(2);
    	}else {
    		return -1;
    	}
    }
    
    int sumArray(List<Integer> src,List<Integer> indexs,int sum) {
    	if(src.isEmpty()) {
    		return sum;
    	}else if(indexs.isEmpty()) {
    		return sum;
    	}else {
    		return sumArray(src,indexs.subList(1,indexs.size()),src.get(indexs.get(0))+sum);
    	}
    }
    
}
