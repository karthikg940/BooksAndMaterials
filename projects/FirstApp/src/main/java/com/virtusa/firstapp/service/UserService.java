package com.virtusa.firstapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.firstapp.bean.User;
import com.virtusa.firstapp.dao.UserDao;
import com.virtusa.firstapp.servicenotification.EmailNotificationService;

@Service
public class UserService {
	/*
	 * @Autowired AddressService addressService
	 */
	@Autowired
	private UserDao userdao;

	@Autowired
	private EmailNotificationService emailNotificationService;

	public int save(User user) {
		System.out.println(user);
		System.out.println("entered into service");
		Integer id = userdao.save(user);
		System.out.println("//////////"+user);
		if (id != null) {
			emailNotificationService.sendEmailNotification(user);
		}
		return id;
	}

	public User get(int id) {
		User user = userdao.get(id);
		return user;

	}

	public List<User> all() {
		List<User> list = userdao.all();
		return list;
	}

	public User update(int id, User user) {
		// TODO Auto-generated method stub
		System.out.println("in service");
		user.setId(id);
		User user1 = userdao.update(user);

		return user1;
	}

	public void delete(int id) {

	    userdao.delete(userdao.get(id));
		 
		 
	}

	/*
	 * @Transactional def update(id,dto) { def patient =
	 * patientRepository.findOne(id)
	 * 
	 * copyProperties(patient,dto) copyProperties(patient.address,dto)
	 * patient.dob =
	 * DateTimeFormat.forPattern("MM/dd/yyyy").parseDateTime(dto.dob) }
	 * 
	 * void copyProperties(dest,src) { src.properties.each{prop, val -> if(prop
	 * in ["metaClass","class"]) return if(prop!='dob' &&
	 * dest.hasProperty(prop)) dest[prop] = val } }
	 * 
	 * 
	 * def all() { patientRepository.findAllWithAddress() }
	 * 
	 * def get(id) { patientRepository.findOneWithAddress(id) }
	 * 
	 * @Transactional def delete(id) { patientRepository.delete(id) }
	 */
}