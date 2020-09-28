package Myproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datamy","root","root");
            System.out.println(con + " connected successfully");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    
    }

	}

