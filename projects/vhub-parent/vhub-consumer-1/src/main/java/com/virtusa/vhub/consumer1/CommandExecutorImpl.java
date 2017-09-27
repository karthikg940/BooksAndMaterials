package com.virtusa.vhub.consumer1;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import com.virtusa.vhub.consumer1.CommandExecutorInterface;


public class CommandExecutorImpl implements CommandExecutorInterface {

	private QueueConnectionFactory connectionFactory;
	private Queue queue;

	public QueueConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(QueueConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public Queue getQueue() {
		return queue;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
	}


	@Override
	public void execute() {
		try {
			 
			QueueConnection conn = connectionFactory.createQueueConnection();
			QueueSession sess = conn.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			QueueReceiver receiver = sess.createReceiver(queue);
			receiver.setMessageListener(new CommandMessageListener());
			conn.start();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
}