package Myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class Emprecords {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Connection con = null;
        Statement st = null;
        ResultSet res = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datamy", "root", "root");
            System.out.println(con + " connected successfully");
            st = con.createStatement();
            res = st.executeQuery("select * from student;");
            ResultSetMetaData rsmd = res.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i) + " ");
            }
            System.out.println("\n******************************\n");
            while (res.next()) {
                System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getInt(3));
            }


        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        } finally {
            try {
                res.close();
                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }


}
 







