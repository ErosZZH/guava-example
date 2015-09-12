package com.rick.guava_example.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class ListenableFutureTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ListeningExecutorService service = MoreExecutors
				.listeningDecorator(Executors.newFixedThreadPool(10));
		ListenableFuture<String> future = service.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(1000 * 3);
//				throw new Exception("Fail!");
				return "OK";
			}
			
		});
		Futures.addCallback(future, new FutureCallback<String>() {

			@Override
			public void onSuccess(String result) {
				System.out.println("result is: " + result);
				System.out.println("onSuccess");
			}

			@Override
			public void onFailure(Throwable t) {
				System.out.println("fail message is: " + t.getMessage());
				System.out.println("onFail");
				
			}
			
		});
	}

}
