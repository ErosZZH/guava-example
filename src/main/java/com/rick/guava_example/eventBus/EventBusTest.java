package com.rick.guava_example.eventBus;


import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//publisher
		EventBus eb = new EventBus("multi");
		EventBusTest test = new EventBusTest();
		MultiListener ml = test.new MultiListener();
		eb.register(ml);
		eb.post(new Integer(100));
		eb.post(new Integer(200));
		eb.post(new Long(300));
		eb.post(new Long(400));
		System.out.println(ml.getLastInt());
		System.out.println(ml.getLastLong());
	}
	
	class MultiListener {
		private Integer lastInt;
		private Long lastLong;
		
		@Subscribe
		public void listenInteger(Integer i) {
			lastInt = i;
			System.out.println("Integer: " + lastInt);
		}
		
		@Subscribe
		public void listenLong(Long l) {
			lastLong = l;
			System.out.println("Long: " + lastLong);
		}

		public Integer getLastInt() {
			return lastInt;
		}

		public Long getLastLong() {
			return lastLong;
		}
		
	}

}
