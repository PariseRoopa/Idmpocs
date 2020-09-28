package Myproject;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datamy","root","root");
             System.out.println(con + "Connected Successfylly");
             Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
             ResultSet res = st.executeQuery("select * from emp10");
             System.out.println("forward direction");
             while(res.next()) {
            	 System.out.println(res.getInt(1) +""+res.getString(2));
             }
             System.out.println("Backward direction");
             res.afterLast();
             while(res.previous()) {
            	 System.out.println(res.getInt(1) + " "+res.getString(2));
             }
        }
        catch (Exception e) {
            System.out.println(e);
        }

	}

}
