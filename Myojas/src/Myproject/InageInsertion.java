package Myproject;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class InageInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
             System.out.println(con + "Connected Successfylly");
             FileInputStream fis = new FileInputStream(("D:\\1.jpg"));
             PreparedStatement st = con.prepareStatement("insert into image_store values(?)");
             st.setBinaryStream(1,fis,fis.available());
             int res=st.executeUpdate();
             System.out.println(res+"record inserted");
             st.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

	}

}
