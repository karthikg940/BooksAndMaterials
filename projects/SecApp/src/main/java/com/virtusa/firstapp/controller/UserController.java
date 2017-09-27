package com.virtusa.firstapp.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.firstapp.bean.User;
import com.virtusa.firstapp.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	/*
	 * @Autowired PatientTransformer patientTransformer
	 */

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Link> create(@Valid @RequestBody User user)
			throws URISyntaxException {

		int id = userService.save(user);

		Link link = linkTo(UserController.class).slash(id).withSelfRel();

		// linkTo(null).slash(id).withRel("delete");

		return ResponseEntity.created(new URI("/api/user/" + id)).body(link);
	}

	/*
	 * @RequestMapping(method=RequestMethod.GET) String all() {
	 * patientTransformer.transform(UserService.all()) }
	 * 
	 * @RequestMapping(value='/{id}',method=RequestMethod.GET) def
	 * get(@PathVariable("id") Long id) {
	 * patientTransformer.transformOne(patientService.get(id)) }
	 * 
	 * @RequestMapping(value='/{id}',method=RequestMethod.PUT) def
	 * update(@PathVariable("id") Long id,@Valid @RequestBody PatientDto
	 * patientDto) { patientService.update(id,patientDto)
	 * ResponseEntity.ok().build() }
	 * 
	 * @RequestMapping(value='/{id}',method=RequestMethod.DELETE) def
	 * delete(@PathVariable("id") Long id) { patientService.delete(id)
	 * ResponseEntity.noContent().build() }
	 */

}
