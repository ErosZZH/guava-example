package com.rick.guava_example.functional;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

public class FunctionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] s = {"a","A","BC"};
		Multiset<Integer> lengths = HashMultiset.create(FluentIterable
				.from(Lists.newArrayList(s)).filter(new Predicate<String>() {
					public boolean apply(String string) {
						return CharMatcher.JAVA_UPPER_CASE.matchesAllOf(string);
					}
				}).transform(new Function<String, Integer>() {
					public Integer apply(String string) {
						return string.length();
					}
				}));
		for(int i: lengths.elementSet()) {
			System.out.print(i + ",");
		}

	}

}
