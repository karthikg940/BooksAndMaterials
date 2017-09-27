package com.virtusa.firstapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.firstapp.bean.User;
import com.virtusa.firstapp.dao.UserDao;

@Service
public class UserService {
	/*@Autowired
	AddressService addressService
*/
	@Autowired
    UserDao userdao;

	 
	public int save(User user){
		System.out.println("entered into service");
		int id=userdao.save(user);
				return id;
	}
	
	/*@Transactional
	def update(id,dto) {
		def patient = patientRepository.findOne(id)
		
		copyProperties(patient,dto)
		copyProperties(patient.address,dto)
		patient.dob = DateTimeFormat.forPattern("MM/dd/yyyy").parseDateTime(dto.dob)
	}
	
	void copyProperties(dest,src) {
		src.properties.each{prop, val ->
			if(prop in ["metaClass","class"]) return
			if(prop!='dob' && dest.hasProperty(prop)) dest[prop] = val
		}
	}
	
	
	def all() {
		patientRepository.findAllWithAddress()
	}
	
	def get(id) {
		patientRepository.findOneWithAddress(id)
	}
	
	@Transactional
	def delete(id) {
		patientRepository.delete(id)
	}*/
}