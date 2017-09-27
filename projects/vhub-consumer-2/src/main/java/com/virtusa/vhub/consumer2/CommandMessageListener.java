package com.virtusa.vhub.consumer2;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.messaging.support.MessageBuilder;

import com.virtusa.vhub.consumer2.CommandMessages;

public class CommandMessageListener implements MessageListener {


	@Override
	public void onMessage(Message message) {
		try {
			
			CommandMessages commandmsg = new CommandMessages();
			commandmsg.setCorelationId(message.getJMSCorrelationID());
			commandmsg.setCommand(null);
			commandmsg.setResponse("receive");
			commandmsg.setCorelationId(message.getJMSCorrelationID());
			commandmsg.setCommandCallbackUrl(message.getStringProperty("CommandCallbackUrl"));
			commandmsg.setReplyTo(message.getJMSReplyTo());
			CommandSender sender = new CommandSender();
			sender.initialSender(commandmsg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
