package Myproject;

import java.sql.Connection;//resultset
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datamy","root","root");
            System.out.println(con + "Connected Successfylly");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet res=st.executeQuery("select * from employee");
            res.last();
            System.out.println(res.getInt(1) + " "+ res.getString(2));
            res.first();
            System.out.println(res.getInt(1) + " "+ res.getString(2));
            res.absolute(4);
            System.out.println(res.getInt(1) + " "+ res.getString(2));
            res.first();
            res.updateInt(1, 10);
            res.updateString(2,"Arun");
            res.updateRow();
            
        }
       catch (Exception e) {
           System.out.println(e);
       }



   }
}
