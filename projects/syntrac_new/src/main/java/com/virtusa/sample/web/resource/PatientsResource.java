package com.virtusa.sample.web.resource;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.sample.repository.PatientRepository;
import com.virtusa.sample.web.controller.dto.PatientsDtoVanila;
import com.virtusa.sample.web.domain.Patients;
import com.virtusa.sample.web.transformer.PatientsTransformer;

@RestController
@RequestMapping("/api/patients/java")
public class PatientsResource {

	@Autowired
	PatientsTransformer patientsTransformer;
	
	@Autowired
	PatientRepository patientRepository;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<PatientsDtoVanila>> get(@PathParam("id") Long id){
//		Patient patient = patientRepository.findOne(id);
		return ResponseEntity.ok(patientsTransformer.transform(Arrays.asList(new Patients())));
	}
}
