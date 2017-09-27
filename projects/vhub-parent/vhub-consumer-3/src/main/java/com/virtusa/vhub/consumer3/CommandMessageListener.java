package com.virtusa.vhub.consumer3;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.messaging.support.MessageBuilder;

import com.virtusa.vhub.consumer3.CommandMessages;

public class CommandMessageListener implements MessageListener {


	@Override
	public void onMessage(Message message) {
		try {
			
			CommandMessages commandmsg = new CommandMessages();
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
