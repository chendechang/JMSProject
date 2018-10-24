package com.activemq;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {

	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	
	private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	ActiveMQConnectionFactory connectionFactory;
	
	Connection connection;
	
	Session session;
	
	AtomicInteger count = new AtomicInteger(0);
	
	public void init(){
		
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
		
		try {
			connection = connectionFactory.createConnection();
			
			//��������
			connection.start();
			//�����Ự
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String disname){
		
		try {
			//����һ����Ϣ����
			Queue queue = session.createQueue(disname);
			//����������
			MessageProducer messageProducer = session.createProducer(queue);
			//������Ϣ
//			for (int i = 0; i < 10; i++) {
//				messageProducer.send(session.createTextMessage("��ã�activeMQ:"+i));
//			}
			
			while(true){
					
				Thread.sleep(4000);
				
				int num = count.getAndIncrement();
				
				TextMessage msg = session.createTextMessage(Thread.currentThread().getName()+"producer:������������������,count:"+count);
				
				System.out.println(Thread.currentThread().getName()+"producer:������������������,count:"+count);
				
				//������Ϣ
				messageProducer.send(msg);
				
				//�ύ����
				session.commit();	
			}
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
