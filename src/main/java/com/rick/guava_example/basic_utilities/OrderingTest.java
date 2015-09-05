package com.rick.guava_example.basic_utilities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

public class OrderingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//1.natural()
		Integer[] i = {9,8,7,6,5,4,3,2,1};
		List<Integer> iList = Arrays.asList(i);
		Collections.sort(iList, Ordering.natural());
		for(int j: iList) {
			System.out.print(j + ",");
		}
		System.out.println();
		
		List<Integer> iList1 = Arrays.asList(i);
		Collections.sort(iList1);
		for(int j: iList1) {
			System.out.print(j + ",");
		}
		System.out.println();
		
		//2.usingToString()
		User user1 = new User();
		user1.setFirstName("b");
		user1.setLastName("b");
		user1.setZipCode(1);
		
		User user2 = new User();
		user2.setFirstName("a");
		user2.setLastName("b");
		user2.setZipCode(1);
		User[] s = {user1, user2};
		List<User> ss = Arrays.asList(s);
		Collections.sort(ss, Ordering.usingToString());
		for(User j: ss) {
			System.out.print(j.getFirstName() + ",");
		}
		System.out.println();
		
		//3.customized comparator
		String[] s1 = {"10", "12", "9", "1", "2"}; // always happened in month comparator
		List<String> sList1 = Arrays.asList(s1);
		List<String> sList2 = Arrays.asList(s1);
		Ordering<String> dateComparator = new Ordering<String>() {
			@Override
			public int compare(String left, String right) {
				return Ints.compare(Integer.valueOf(left), Integer.valueOf(right));
			}
		};
		Collections.sort(sList1);
		for(String ss1: sList1) {
			System.out.print(ss1 + ",");
		}
		System.out.println();
		Collections.sort(sList2, dateComparator);
		for(String ss2: sList2) {
			System.out.print(ss2 + ",");
		}
		System.out.println();
		
		//4.Chain
		String[] s41 = {"10", "12", "9", null, "1", "2"};
		List<String> sList41 = Arrays.asList(s41);
		Ordering<String> chainComparator = Ordering.natural().reverse().nullsFirst()
				.onResultOf(new Function<String, String>() {
					@Override
					public String apply(String input) {
						return input;
					}
		});
		Collections.sort(sList41, chainComparator);
		for(String ss2: sList41) {
			System.out.print(ss2 + ",");
		}
		System.out.println();
		
		//5. Application
		Integer[] i5 = {2,3,6,8,4,1};
		List<Integer> iList5 = Arrays.asList(i5);
		List<Integer> iList51 = Ordering.natural().greatestOf(iList5, 3);
		for(int ss2: iList51) {
			System.out.print(ss2 + ",");
		}
		System.out.println();
	}

}
