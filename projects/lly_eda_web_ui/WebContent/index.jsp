<%@page import="java.sql.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
  <%
 
  Connection con = null;
  try {  
      Class.forName("oracle.jdbc.odbc.JdbcOdbcDriver");  
  }  
  catch(Exception ex){
	  System.out.println("Error: unable to load driver class! " + ex);  
      System.exit(1);  
  }
  
  con = DriverManager.getConnection("jdbc:oracle:thin:@10.5.112.106:1521:XE","LLY_EDA","LLY_EDA");
  
  Statement stmt=con.createStatement();  
  ResultSet rs=stmt.executeQuery("select * from EDA_POC_CLINICAL_STUDY_MASTER");
  while(rs.next())  {
	  System.out.println("No of TPO " + rs.getString(12));
  }
  
  %>
</body>
</html>