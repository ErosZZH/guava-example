package com.rick.guava_example.collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RangeSet;
import com.google.common.collect.Table;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeSet;


public class NewCollections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//1. MultiSet
		Multiset<String> mss = HashMultiset.create();
		mss.add("a");
		mss.add("a");
		mss.add("b");
		System.out.println(mss.count("a"));
		System.out.println(mss.size());
		for(String s : mss.elementSet()) {
			System.out.print(s + ",");
		}
		System.out.println();
		
		//2. MultiMap
		Multimap<String, String> mms = ArrayListMultimap.create();
		mms.put("a", "1");
		mms.put("a", "2");
		mms.put("b", "1");
		for(String s : mms.keySet()) {
			System.out.print(s + ",");
		}
		System.out.println();
		//取不存在的键会抛空指针异常
		for(String s : mms.asMap().get("a")) {
			System.out.print(s + ",");
		}
		System.out.println();
		//取不存在的键不会抛异常，返回空集合
		for(String s : mms.get("a")) {
			System.out.print(s + ",");
		}
		System.out.println();
		
		//3. BiMap
		BiMap<Integer, String> idAndName = HashBiMap.create();
		idAndName.put(1, "Rick");
		System.out.println(idAndName.inverse().get("Rick"));
		
		//4. Table
		Table<String, String, Integer> table = HashBasedTable.create();
		table.put("a", "x", 1);
		table.put("a", "y", 2);
		table.put("b", "x", 3);
		table.put("c", "z", 4);
		for(String s : table.rowKeySet()) {
			System.out.print(s + ",");
		}
		System.out.println();
		
		for(String s : table.columnKeySet()) {
			System.out.print(s + ",");
		}
		System.out.println();
		System.out.println(table.column("x").get("a"));
		
		//5. classToInstanceMap
		ClassToInstanceMap<Object> ctim = MutableClassToInstanceMap.create();
		ctim.putInstance(String.class, new String("a"));
		System.out.println(ctim.getInstance(String.class));
		
		//6. RangeSet
		RangeSet<Integer> rs = TreeRangeSet.create();
		rs.add(Range.closed(1, 3));
		rs.add(Range.closed(2, 4));
		System.out.println(rs.asRanges().size());
		for(Range<Integer> s : rs.asRanges()) {
			System.out.print(s.toString() + ",");
		}
		System.out.println();
		
		//7. RangeMap
		RangeMap<Integer, String> rm = TreeRangeMap.create();
		rm.put(Range.closed(1, 3), "a");
		rm.put(Range.closed(2, 4), "b");
		System.out.println(rm.get(1));
		System.out.println(rm.get(2));
	}

}
