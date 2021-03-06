package com.virtusa.vhub.partner1.resource.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.virtusa.vhub.partner1.resource.interfac.FinalResponseHandlerResource;

public class FinalResponseHandlerResourceImpl implements
		FinalResponseHandlerResource {

	private static final Logger log = LoggerFactory
			.getLogger(FinalResponseHandlerResourceImpl.class);

	@Override
	public void processFinalResponse(String commandResponse) {
		log.info("Final response received is: {}", commandResponse);
		System.out.println(commandResponse);
	}

}
