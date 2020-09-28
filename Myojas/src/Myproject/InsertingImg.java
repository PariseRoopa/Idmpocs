package Myproject;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertingImg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			System.out.println(con + " is connected successfully");
			FileInputStream fis = new FileInputStream("A:\\.jpg");
			PreparedStatement pst = con.prepareStatement("insert into image_store values (?)");
			pst.setBinaryStream(1, fis, fis.available());
			int res = pst.executeUpdate();
			System.out.println(res + " Data inserted ");
			pst.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}



