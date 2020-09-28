package Myproject;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class proper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			 try {
			    	FileInputStream fis = new FileInputStream("C:\\Users\\vamsi krishna\\Desktop\\MyOjasConections\\src\\jdbc.properties");
			    	Properties p=new Properties();
			    	p.load(fis);
			    	Class.forName("com.mysql.cj.jdbc.Driver");
			    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datamy",p);
			    	System.out.println(con + " Connected successfully");
			    }
			    catch(Exception e)
			    {
			    	System.out.println(e);
			    }
		}

	}
	
