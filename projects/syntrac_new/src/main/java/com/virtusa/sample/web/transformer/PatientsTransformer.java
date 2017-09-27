/**
 * 
 */
package com.virtusa.sample.web.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import com.virtusa.sample.domain.Patient;
import com.virtusa.sample.web.controller.dto.PatientsDtoVanila;
import com.virtusa.sample.web.domain.Patients;

/**
 * Transformer.
 *
 */
@Component
public class PatientsTransformer {
	static DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
	
	public List<PatientsDtoVanila> transform(List<Patients> patients) {
		List<PatientsDtoVanila> dtoList = patients.stream().map(it -> transformOne(it)).collect(Collectors.toList());
		
		// OR
		
		dtoList = new ArrayList<PatientsDtoVanila>(); 
		for (Patients patient : patients) {
			dtoList.add(transformOne(patient));
		}
				
		return dtoList;
	}
	
//	Streams may not be optimal always: Excerpt from http://blog.codefx.org/java/stream-performance/
	
//	These were the results of comparison between for loop and stream (for 500’000 ordered elements; in milliseconds):
//					MAX				SUM				ARITHMETIC		STRING
//				ARRAY	LIST	ARRAY	LIST	ARRAY	LIST	ARRAY	LIST
//		FOR		0.123	0.700	0.186	0.714	4.405	4.099	49.533	49.943
//		STREAM	0.559	3.272	1.394	3.584	4.100	7.776	52.236	64.989
//	Other examples: https://tedvinke.wordpress.com/2014/06/20/java-8-lambdas-vs-groovy-closures-compactness-grouping-and-summing/
	
	public PatientsDtoVanila transformOne(Patients patient) {
		PatientsDtoVanila dto = new PatientsDtoVanila();
		if (patient.getAddresss()!=null){
			dto.setCity(patient.getAddresss().getCity());
			dto.setLine1(patient.getAddresss().getLine1());
			dto.setLine2(patient.getAddresss().getLine2());
			dto.setPhone1(patient.getAddresss().getPhone1());
			dto.setPhone2(patient.getAddresss().getPhone2());
			dto.setState(patient.getAddresss().getState());
			dto.setZip(patient.getAddresss().getZip());
		}
		
		dto.setDob(patient.getDob());
		dto.setEmail(patient.getEmail());
		dto.setFirstName(patient.getFirstName());
		dto.setLastName(patient.getLastName());
		dto.setGender(patient.getGender());
		return dto;
	}

}
