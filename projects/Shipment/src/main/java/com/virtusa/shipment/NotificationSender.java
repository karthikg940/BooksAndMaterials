package com.virtusa.shipment;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class NotificationSender {

	@Autowired
	JmsTemplate jmsTemp;

	public void sender(String status) {
		MessageCreator messageCreator = new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(status);
			}
		};
		jmsTemp.send("LLY.TRAINING.EMAIL.IN", messageCreator);
	}
	
//	public Message receiver()
//	{
//		Message message= jmsTemp.receive("LLY.TRAINING.EMAIL.IN");
//		System.out.println(message+"this is message");
//        return message;
//    }
}
