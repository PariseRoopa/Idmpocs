package Myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Preparedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter ur no,name,salary ?");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datamy","root","root");
            System.out.println(con + " connected successfully");
            PreparedStatement pst =con.prepareStatement("insert into employee100 value(?,?,?)");
            pst.setInt(1, sc.nextInt());
            pst.setString(2, sc.next());
            pst.setDouble(3, sc.nextDouble());
            int a=pst.executeUpdate();
            System.out.println(a + "inserted successfully");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    
	}

}
