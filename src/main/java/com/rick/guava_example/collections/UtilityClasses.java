package com.rick.guava_example.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.primitives.Ints;

public class UtilityClasses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//1. Collection
		String[] ss = {"a","b","c"};
		List<String> sList1 = Lists.newArrayList(ss);
		List<String> sList = Lists.newArrayList(sList1);
		for(String s : sList) {
			System.out.print(s + ",");
		}
		System.out.println();
		
		//2.Iterables
		Iterable<Integer> iter = Iterables.concat(Ints.asList(1,2), Lists.newArrayList(3,4));
		System.out.println(Iterables.getLast(iter));
		Integer[] it = Iterables.toArray(iter, Integer.class);
		for(int s : it) {
			System.out.print(s + ",");
		}
		System.out.println();
		
		//3. Lists
		List<Integer> itList = Lists.reverse(Arrays.asList(it));
		for(int s : itList) {
			System.out.print(s + ",");
		}
		System.out.println();
		
		//4. Sets
		Set<String> set1 = ImmutableSet.of("a","b","c");
		Set<String> set2 = ImmutableSet.of("x","c","y");
		SetView<String> sv = Sets.intersection(set1, set2);
		Set<String> resSet = sv.immutableCopy();
		for(String s : resSet) {
			System.out.print(s + ",");
		}
		System.out.println();
		
		//5. Maps
		Map<String, String> map = Maps.newHashMap();
		
	}

}
