package com.virtusa.shipment.notificationreceiver;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class AsyncNotificationReceiver {

	@JmsListener(destination = "LLY.TRAINING.EMAIL.IN")
	public void receive(Message msg) {
		try {
			System.out.println(msg.getJMSMessageID());
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
