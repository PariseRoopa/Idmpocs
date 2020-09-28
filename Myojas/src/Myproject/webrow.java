package Myproject;

import java.sql.SQLException;

import java.sql.*;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
public class Catched1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbcRowSet jdbcRowSet = null;
     try {
    	 //Class.forName("com.mysql.cj.jdbc.Driver");
    	 jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
    	 jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/datamy");
    	 jdbcRowSet.setUsername("root");
    	 jdbcRowSet.setPassword("root");
    	 
    	 jdbcRowSet.setCommand("select * from Employeee where empno = ?");
    	 jdbcRowSet.setInt(1,1);
    	 jdbcRowSet.execute();
    	 
    	 System.out.println("jdbcRowSet has created connection,"+ "PreparedStatement and RowSet object");
    	 while(jdbcRowSet.next()) {
    		 System.out.println(jdbcRowSet.getInt("empno")+ " ");
    		 System.out.println(jdbcRowSet.getString("eNAME"));
    	 }
      	 
    	
  }  catch(Exception e) {
 	System.out.println(e);
  }
 }
}