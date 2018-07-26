package com.jeff.learn.hello.util;

import java.util.Optional;

public class HashNoe {
	
	private int value;
	
	private String value1;
	
	

	public HashNoe(int value, String value1) {
		super();
		this.value = value;
		this.value1 = value1;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof HashNoe) {
			return (((HashNoe)obj).getValue1()+((HashNoe)obj).getValue())
					.equals(this.getValue1()+this.getValue());
		}
		return super.equals(obj);
	}
	
	
	
}
