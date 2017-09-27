package com.virtusa.firstapp.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<Link> create(@RequestBody User user)
			throws URISyntaxException {

		int id = userService.save(user);
		System.out.println(id);

		Link link = linkTo(UserController.class).slash(id).withSelfRel();

		System.out.println(link + "this is link");

		// linkTo(null).slash(id).withRel("delete");

		return ResponseEntity.created(new URI("/api/user/" + id)).body(link);

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> all() {
		List<User> list = userService.all();
		return list;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User get(@PathVariable("id") int id) {
		// patientTransformer.transformOne(patientService.get(id))
		User user = userService.get(id);
		/*Link self = linkTo(UserController.class).slash(id).withSelfRel();
		Link patch = linkTo(UserController.class).slash(id).withRel("patch");*/
		// user.add(self, patch);
		return user;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public User update(@PathVariable("id") int id, @RequestBody User user) {

		System.out.println("in controller");
		User user1 = userService.update(id, user);
		// ResponseEntity.ok().build();
		return user1;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		  userService.delete(id);
		  

	}

}
