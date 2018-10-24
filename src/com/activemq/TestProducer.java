package com.activemq;

public class TestProducer {

	public static void main(String[] args){
		Producer producer = new Producer();
		
		producer.init();
		
		TestProducer testProducer = new TestProducer();
		
		new Thread(testProducer.new ProducerMq(producer)).start();
		
	}
	
	private class ProducerMq implements Runnable{
		
		Producer producer;
		
		public ProducerMq(Producer producer){
			this.producer = producer;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			//long startTime = System.currentTimeMillis();
			while(true){
				//long endTime = System.currentTimeMillis();
				try {
					producer.sendMessage("cdc-MQ");
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
//			while(true){
//				try {
//					System.out.println(System.currentTimeMillis());
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
		
	}
}
