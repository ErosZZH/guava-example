package com.rick.guava_example.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

public class ImmutableCollection {

	public static void main(String[] args) {
		ImmutableSet<String> set = ImmutableSet.of("b", "c", "a");
		ImmutableList<String> list = ImmutableList.copyOf(set);
		ImmutableList<String> list1 = set.asList();
		ImmutableSortedSet<String> sortedList = ImmutableSortedSet.copyOf(set);
		for(String s : list) {
			System.out.print(s + ",");
		}
		System.out.println();
		for(String s : list1) {
			System.out.print(s + ",");
		}
		System.out.println();
		for(String s : sortedList) {
			System.out.print(s + ",");
		}
		System.out.println();
	}
}
