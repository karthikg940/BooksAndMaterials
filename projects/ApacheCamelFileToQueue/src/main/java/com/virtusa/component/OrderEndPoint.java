package com.virtusa.component;

import javax.jws.WebService;


@WebService
public interface OrderEndPoint {

	public String order(String partName, int amount, String customerName);
}
