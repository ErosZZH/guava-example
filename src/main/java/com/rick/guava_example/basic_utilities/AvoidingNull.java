package com.rick.guava_example.basic_utilities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Strings;

public class AvoidingNull {

	public static void main(String[] args) {
		
		//1
		Optional<Integer> possible = Optional.of(5);
		//contains a (non-null) instance
		possible.isPresent();
		int i = possible.get();
		System.out.println(i);
		
		//2
		Optional<Integer> possible1 = Optional.absent();
		System.out.println(possible1.isPresent());
		
		//3
		try {
			Optional<Integer> p = Optional.of(null);
		} catch(NullPointerException e) {
			System.out.println("Throws null pointer exception.");
		}
		Optional<Integer> p1 = Optional.fromNullable(null);
		System.out.println(p1.isPresent());
		
		//4 avoiding return null
		Object p2 = Optional.fromNullable(null).or(0);
		System.out.println(p2);
		int j = MoreObjects.firstNonNull(null, 0);
		System.out.println(j);
		
		//5 empty and null
		String s1 = "";
		String s2 = null;
		if(Strings.emptyToNull(s1) == null) {
			System.out.println(true);
		}
		if(Strings.nullToEmpty(s2).equals("")) {
			System.out.println(true);
		}
		if(Strings.isNullOrEmpty(s1) && Strings.isNullOrEmpty(s2)) {
			System.out.println(true);
		}
	}
}
