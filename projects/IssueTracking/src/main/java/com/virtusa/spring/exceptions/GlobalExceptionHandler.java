package com.virtusa.spring.exceptions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@ControllerAdvice
public class GlobalExceptionHandler {


	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ModelAndView conflict(HttpServletRequest req,
			DataIntegrityViolationException ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("classtype", ex.getClass().toString());
		//mav.addObject("cause", ex.getCause().toString());
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("Error");
		return mav;

	}
	
	@ExceptionHandler(HibernateException.class)
	public ModelAndView conflictHibernate(HttpServletRequest req,
			HibernateException ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("classtype", ex.getClass().toString());
		mav.addObject("cause", ex.getCause().toString());
		mav.addObject("exception", ex.getClass().getSimpleName());
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("Error");
		return mav;

	}
	

	@ExceptionHandler(NoSuchRequestHandlingMethodException.class)
	public ModelAndView resource(HttpServletRequest req,
			NoSuchRequestHandlingMethodException ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("classtype", ex.getClass().toString());
		//mav.addObject("cause", ex.getCause().toString());
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("Error");
		return mav;

	}

	@ExceptionHandler(SQLException.class)
	public ModelAndView databaseError(HttpServletRequest req, SQLException ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("classtype", ex.getClass().toString());
		//mav.addObject("cause", ex.getCause().toString());
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("Error");
		return mav;

	}

	@ExceptionHandler(DataAccessException.class)
	public ModelAndView databaseError1(HttpServletRequest req,
			DataAccessException ex) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("classtype", ex.getClass().toString());
		//mav.addObject("cause", ex.getCause().toString());
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("Error");
		return mav;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception exception) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("classtype", exception.getClass().toString());
		//mav.addObject("cause", exception.getCause().toString());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("Error");
		return mav;
	}
	@ExceptionHandler(java.lang.IllegalStateException.class)
	public ModelAndView sessionerror(HttpServletRequest req,
			DataAccessException ex) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("classtype", ex.getClass().toString());
		//mav.addObject("cause", ex.getCause().toString());
		String error="Session Invalidated Please Re-Login";
		mav.addObject("except", ex);
		mav.addObject("exception", error);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("Error");
		return mav;

	}

}
