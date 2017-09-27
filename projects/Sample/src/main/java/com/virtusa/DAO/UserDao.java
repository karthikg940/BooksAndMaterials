package com.virtusa.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.virtusa.bean.User;

public class UserDao {

	public void create(User user)
	{
		   
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "root");
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Inserting records into the table...");
		      stmt = conn.createStatement();
		      
		      String sql = "INSERT INTO user " +
		                   "VALUES ('Zar1a', 'Ali')";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO user " +
		                   "VALUES ('Mahn1az', 'Fatma')";
		      stmt.executeUpdate(sql);
		       
		      System.out.println("Inserted records into the table...");

		   }catch(SQLException se){
		     
		      se.printStackTrace();
		   }catch(Exception e){
		      
		      e.printStackTrace();
		   }finally{
		      
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		 
		}//end JDBCExample
	}

