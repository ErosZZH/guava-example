package com.rick.guava_example.reflection;


public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TransactionProxy tp = new TransactionProxy();
		Insert i = tp.bind(new InsertImpl());
		i.doSomething();
	}

}
