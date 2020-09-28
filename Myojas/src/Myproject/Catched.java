package Myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Catched {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datamy","root","root");
             System.out.println(con + "Connected Successfylly");
             Statement st = con.createStatement();
             ResultSet res = st.executeQuery("select * from employeee");
             RowSetFactory raf = RowSetProvider.newFactory();
             CachedRowSet cra = raf.createCachedRowSet();
             cra.populate(res);
             con.close();
             cra.beforeFirst();
             while(cra.next()) {
            	 System.out.println(cra.getInt(1) + " " + cra.getString(2));
             }
        }
        catch (Exception e) {
            System.out.println(e);
        }

	}

}
