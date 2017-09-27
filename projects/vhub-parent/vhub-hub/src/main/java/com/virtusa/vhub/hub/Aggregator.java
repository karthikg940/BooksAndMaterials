package com.virtusa.vhub.hub;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import com.virtusa.vhub.entity.ResponseList;
 
	public class Aggregator implements AggregationStrategy {
		 
		 
		@Override
		public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
			 
			if (oldExchange == null) {
				return newExchange;
			}
			ResponseList responseOld=oldExchange.getIn().getBody(ResponseList.class);
			ResponseList responseNew=newExchange.getIn().getBody(ResponseList.class);
			responseOld.getResponseList().add(responseNew.getResponseList().get(0));
			return oldExchange;	 
		}       
	
}
