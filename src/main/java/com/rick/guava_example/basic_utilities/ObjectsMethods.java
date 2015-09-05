package com.rick.guava_example.basic_utilities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import junit.framework.Assert;

public class ObjectsMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//1.
		Assert.assertTrue(Objects.equal("a", "a"));
		Assert.assertFalse(Objects.equal(null, ""));
		Assert.assertTrue(Objects.equal(null, null));
		
		//2.
		System.out.println(Objects.hashCode("I'm Rick", " Zhu"));
		System.out.println(Objects.hashCode("I'm Rick Zhu"));
		
		//3.
		System.out.println(MoreObjects.toStringHelper("ObjectsMethods").add("x", 1).toString());
		
		//4.
		User user1 = new User();
		user1.setFirstName("a");
		user1.setLastName("b");
		user1.setZipCode(1);
		
		User user2 = new User();
		user2.setFirstName("a");
		user2.setLastName("b");
		user2.setZipCode(1);
		
		int res = ComparisonChain.start()
		.compare(user1.getFirstName(), user2.getFirstName())
		.compare(user1.getLastName(), user2.getLastName())
		.compare(user1.getZipCode(), user2.getZipCode())
		.result();
		
		//0 a==b, -1 a<b, 1 a>b
		System.out.println(res);
	}
	
	

}

class User {
	private String firstName;
	private String lastName;
	private int zipCode;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
