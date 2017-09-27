package com.virtusa.spring.exceptions;

import java.sql.SQLException;

public class UserException extends Exception {

	public UserException(SQLException e) {
		super(e);
	}

}
