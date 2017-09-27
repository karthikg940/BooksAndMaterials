package com.virtusa.service;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;


public class NewTopicBean implements TypeConverters {

	private Random ran = new Random();

	public Map<String, Object> insert(String payload) {
		
		System.out.println(payload + "this is from queue");
		Map<String, Object> answer = new HashMap<String, Object>();
		answer.put("TopicId", ran.nextInt());
		answer.put("url", payload);
		answer.put("CreateDate", new Date());
		answer.put("ModuleId", ran.nextInt());
		answer.put("TopicName", "Camel");
		return answer;
	}
}
