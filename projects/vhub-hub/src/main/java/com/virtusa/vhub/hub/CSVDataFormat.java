package com.virtusa.vhub.hub;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;

import com.virtusa.vhub.entity.Command;
import com.virtusa.vhub.entity.Receive;
import com.virtusa.vhub.entity.ResponseList;

public class CSVDataFormat implements TypeConverters{

	
	@Converter
	public Map<String,String> convertTo(Command command)
	{
		Map<String,String> convert=new LinkedHashMap<String,String>();
		convert.put("command",command.getCommand());
		convert.put("id",Integer.toString(command.getId()));
		convert.put("type", command.getType());
		return convert;
	}
	
	@Converter
	public ResponseList convertTo(List<Map<String,String>> mapObj)
	{
		Receive receive=new Receive();
		ResponseList list=new ResponseList();
		Map<String,String> Obj=mapObj.get(0);
		receive.setStatus(Obj.get("status"));
		receive.setStatusCode(Obj.get("statusCode"));
		receive.setStatusDescription(Obj.get("statusDescription"));
		ArrayList<Receive> results = new ArrayList<Receive>();
		results.add(receive);
	    list.setResponseList(results);
		return list;		
	}
}
