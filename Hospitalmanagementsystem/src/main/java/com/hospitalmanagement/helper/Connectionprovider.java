package com.hospitalmanagement.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectionprovider {


		private static Connection con;

		 public static Connection connect() {
			try {

	            if (con == null) {
	                //driver class load
	            	  Class.forName("org.postgresql.Driver");
	                  con = DriverManager
	                     .getConnection("jdbc:postgresql://localhost:5432/Hospital_management",
	                     "postgres", "root");
	                  	System.out.println("connected"+con);
	       
	            }

	        } catch (Exception e) {
	        	System.out.println("not connected");
	            e.printStackTrace();
	        }

	        return con;
		}
	}


