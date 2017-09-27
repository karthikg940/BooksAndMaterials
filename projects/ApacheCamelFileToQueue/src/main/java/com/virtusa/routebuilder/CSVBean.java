package com.virtusa.routebuilder;

public class CSVBean {
	public static String map(String custom)
	{
		String id=custom.substring(0,9);
		String customId=custom.substring(10,19);
		String date=custom.substring(20,29);
		String item=custom.substring(30);
		StringBuilder sb = new StringBuilder();
		sb.append(id.trim());
		sb.append(",").append(customId.trim());
		sb.append(",").append(date.trim());
		sb.append(",").append(item.trim());
		return sb.toString();
	}

}
