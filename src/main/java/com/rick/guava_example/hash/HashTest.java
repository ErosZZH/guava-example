package com.rick.guava_example.hash;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class HashTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String password = "password";
		HashFunction hf = Hashing.md5();
		HashCode hc = hf.hashString(password, Charsets.UTF_8);
		HashCode hc1 = hf.newHasher().putString(password, Charsets.UTF_8).hash();
		System.out.println(hc.toString());
		System.out.println(hc1.toString());
		
	}

}
