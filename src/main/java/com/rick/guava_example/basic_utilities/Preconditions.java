package com.rick.guava_example.basic_utilities;

import static com.google.common.base.Preconditions.*;

public class Preconditions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//1.checkArgument
		int i = 5;
		try {
			checkArgument(i > 6, "Argument was %s but expected nonnegative", i);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		//2.checkNotNull
		String s = null;
		try {
			checkNotNull(s, "String s shouldn't be null.");
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		//3.checkState
		try {
			checkState(i > 6, "State shouldn't expected");
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		
		//4.checkElementIndex
		String s1 = "01234567";
		try {
			checkElementIndex(9, s1.length(), "index error...");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		//5.checkPositionIndex
		try {
			checkPositionIndex(9, s1.length(), "index error...");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		//6.checkPositionIndexes
		try {
			checkPositionIndexes(-1, 4, s1.length());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

}
