package com.rick.guava_example.range;

import com.google.common.collect.Range;

public class RangeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//交
		Range<Integer> r1 = Range.closed(1, 3).intersection(Range.open(2, 4));
		System.out.println(r1.toString());
		
		//并
		Range<Integer> r = Range.closed(1, 3).span(Range.open(3, 10));
		System.out.println(r.toString());
	}

}
