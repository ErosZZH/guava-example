package com.rick.guava_example.caches;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//1. define
		LoadingCache<String, String> cache = CacheBuilder.newBuilder()
				.maximumSize(1000)
				.expireAfterAccess(10, TimeUnit.MINUTES)
				.refreshAfterWrite(1, TimeUnit.MILLISECONDS)
				.build(
						new CacheLoader<String, String>() {
							@Override
							public String load(String key) throws Exception {
								return new CacheTest().keyToValue(key);
							}

						}
					);
		cache.invalidate("Hello");
		//2. get
		try {
			System.out.println("Can get key, for Hello: " + cache.get("Hello"));
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		cache.put("Rick", "aaccdd");

		// 2. get again
		try {
			System.out
					.println("Can get new key, for Rick: " + cache.get("Rick"));
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cache.invalidate("Hello");
		cache.put("Hello", "123");
		try {
			System.out
					.println("Can get new key, for Hello: " + cache.get("Hello"));
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
		//Callable
		Cache<String, String> cache1 = CacheBuilder.newBuilder()
				.maximumSize(1000)
				.expireAfterAccess(10, TimeUnit.MILLISECONDS)
				.build();		
		// 1.
		try {
			cache1.get("Hi", new Callable<String>() {
				@Override
				public String call() throws Exception {
					System.out.println("Can't get key, execute callable");
					return new CacheTest().keyToValue("Hi");
				}
			});
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		// 2.
		try {
			System.out
					.println("Can get new key, for Hello: " + cache.get("Hi"));
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String keyToValue(String key) {
		return key + "-value";
	}

}
