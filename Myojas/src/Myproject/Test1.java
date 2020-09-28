package Myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

 import java.sql.Statement;


 

public class Test1 {
          public static void main(String[] args) {
                // TODO Auto-generated method stub
                 try {
                     Class.forName("com.mysql.cj.jdbc.Driver");
                     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datamy","root","root");
                     System.out.println(con + "Connected Successfylly");
                     Statement st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                     ResultSet res = ((java.sql.Statement) st).executeQuery("select * from emp10");
                     System.out.println("forward direction");
                     res.absolute(2);
                     res.updateString(2, "zzz");
                     res.updateRow();
                 }
                catch (Exception e) {
                    System.out.println(e);
                }

 

            }
}