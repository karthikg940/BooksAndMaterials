package com.virtusa.vhub.consumer3;

import java.io.StringWriter;
import java.util.Collections;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.virtusa.vhub.entity.Receive;
import com.virtusa.vhub.entity.ResponseList;

public class CommandSender {

	ActiveMQConnectionFactory connectionFactory;
	QueueConnection queueConnection;
	QueueSession queueSession;
	
	private static final String COMMA_DELIMITER = ",";
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");
	private static final String COMMAND_RESPONSE_CSV_HEADER = "ackType,executorId,statusCode,statusDescription";



	public void initialSender(CommandMessages commandmsg) {
		try {
			connectionFactory = new ActiveMQConnectionFactory("karaf", "karaf",
					"tcp://localhost:61616");
			queueConnection = connectionFactory.createQueueConnection();

			try {
				queueSession = queueConnection.createQueueSession(false,
						Session.AUTO_ACKNOWLEDGE);
				Queue queue = (Queue) commandmsg.getReplyTo();
				QueueSender queueSender = queueSession.createSender(queue);

				Receive response = new Receive();
				ResponseList responseEntity = new ResponseList();
				response.setStatus("received");
				response.setStatusCode("203");
				response.setStatusDescription("initial response-3");
				responseEntity.setResponseList(Collections
						.singletonList(response));
//				StringWriter writer = new StringWriter();
//
//				JAXBContext context = JAXBContext
//						.newInstance(ResponseList.class);
//				context.createMarshaller().marshal(responseEntity, writer);
				
				StringBuilder csvObj=marshalResObjToCsv(responseEntity);

				TextMessage textMessage = queueSession.createTextMessage();
				textMessage.setJMSCorrelationID(commandmsg.getCorelationId());
				textMessage.setText(csvObj.toString());
				queueSender.send(textMessage);
				finalSender(commandmsg);

			} finally {
				queueConnection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void finalSender(CommandMessages commandmsg) {
		System.out.println("in the final sender method");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			System.out.println("before activemq");
			QueueSession queueSession = queueConnection.createQueueSession(
					false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = (Queue) commandmsg.getReplyTo();
			QueueSender queueSender = queueSession.createSender(queue);
			Receive response = new Receive();
			response.setStatus("received");
			response.setStatusCode("203");
			response.setStatusDescription("final response-3");
			ResponseList responseEntity = new ResponseList();
			responseEntity.setResponseList(Collections.singletonList(response));
//			StringWriter writer = new StringWriter();
//			JAXBContext context = JAXBContext.newInstance(ResponseList.class);
//			context.createMarshaller().marshal(responseEntity, writer);
			StringBuilder csv=marshalResObjToCsv(responseEntity);
			TextMessage textMessage = queueSession.createTextMessage();
			textMessage.setJMSCorrelationID(commandmsg.getCorelationId());
			textMessage.setStringProperty("CommandCallbackUrl",
					commandmsg.getCommandCallbackUrl());
			textMessage.setStringProperty("AckType", "FINAL");
			textMessage.setText(csv.toString());
			queueSender.send(textMessage);
			System.out.println("before send method last");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  
	public static StringBuilder marshalResObjToCsv(ResponseList responseEntity)
	{
		StringBuilder receiveObj=new StringBuilder();
//		receiveObj.append(COMMAND_RESPONSE_CSV_HEADER.toString());
//		receiveObj.append(LINE_SEPARATOR);
//		receiveObj.append(
		receiveObj.append(COMMA_DELIMITER);
		Receive receive=responseEntity.getResponseList().get(0);
		receiveObj.append(receive.getStatus());
		receiveObj.append(COMMA_DELIMITER);
		receiveObj.append(receive.getStatusCode());
		receiveObj.append(COMMA_DELIMITER);
		receiveObj.append(receive.getStatusDescription());
		receiveObj.append(LINE_SEPARATOR);   
		return receiveObj;
	}
}
