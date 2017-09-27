package com.virtusa.vhub.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseList {

	private List<Receive> responseList;

	public List<Receive> getResponseList() {
		return responseList;
	}

	public void setResponseList(List<Receive> responseList) {
		this.responseList = responseList;
	}

	@Override
	public String toString() {
		return "ResponseList [responseList=" + responseList + "]";
	}

}
