package Myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class Databasemt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datamy","root","root");
	            System.out.println(con + "Connected Successfylly");
	            DatabaseMetaData dsmd = (DatabaseMetaData) con.getMetaData();
	            System.out.println("Driver Name :" +dsmd.getDriverName());
	            System.out.println("Driver version : "+ dsmd.getDriverVersion());
	            System.out.println("user name : " + dsmd.getUserName());
	            System.out.println("Database product version :" + dsmd.getDatabaseProductVersion());
	            
	            

	}
		 catch (Exception e) {
	           System.out.println(e);
	       }


	}
}
