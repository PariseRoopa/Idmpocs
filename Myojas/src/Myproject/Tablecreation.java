package Myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Tablecreation {
	public static void main(String[] args) {
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datamy","root","root");
	            System.out.println(con + " connected successfully");
	            Statement st =con.createStatement();
	            st.execute("create table customer100(cid int(20),cname varchar(20))");
	            System.out.println("table created");
	}
		 catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e);
	        }
	}

}