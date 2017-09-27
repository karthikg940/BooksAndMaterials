//package com.virtusa.shipment;
//import javax.jms.Message;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//	public class NotificationReceiver {
//	 @Autowired
//	 static JmsTemplate jmsTemp;
//	 
//		public static void main(String[] args) {
//			new SpringApplication(ApplicationLauncher.class).run(args);
//			//System.out.println(receiver());
//			receiver();
//			}
//	 
//	public static Message receiver()
//	{
//		Message message= jmsTemp.receive("LLY.TRAINING.EMAIL.IN");
//		System.out.println(message+"this is message");
//        return message;
//    }
//	}