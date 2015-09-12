package com.rick.guava_example.string;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//1. Joiner
		String[] s = {"a","b"};
		String res = Joiner.on(',').join(s);
		System.out.println(res);
		
		//2. Splitter
		Iterable<String> iter = Splitter.on(',').trimResults().omitEmptyStrings()
				.split("hi,there,,     good,");
		for(String s1: iter) {
			System.out.println(s1);
		}
	}

}
