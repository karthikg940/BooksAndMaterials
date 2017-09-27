package com.virtusa.shipment.notificationreceiver;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/shipment-notification")
public class SyncNotificationReceiver {

	@Autowired
	private JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		new SpringApplication(SyncNotificationReceiver.class).run(args);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String receiver() {
		jmsTemplate.setReceiveTimeout(5000);
		TextMessage message = (TextMessage) jmsTemplate
				.receive("LLY.TRAINING.EMAIL.IN");
		System.out.println(message + "this is message");
		try {
			return message.getText();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return null;
	}
}