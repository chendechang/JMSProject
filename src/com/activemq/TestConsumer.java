package com.activemq;

public class TestConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Consumer consumer = new Consumer();
		
		consumer.init();
		
		TestConsumer testConsumer = new TestConsumer();
		
		new Thread(testConsumer.new ConsumerMq(consumer)).start();

	}
	
	public class ConsumerMq implements Runnable{
		
		Consumer consumer;
		
		public ConsumerMq(Consumer consumer){
			this.consumer = consumer;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			try {
				consumer.getMessage("cdc-MQ");
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
