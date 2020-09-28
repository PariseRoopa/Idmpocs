package Myproject;

import java.util.Scanner;
import java.sql.*;

 

public class Callable {

 

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datamy", "root", "root");
            System.out.println(con + "connected successfully");
            System.out.println("Enter employee number ?");

 

            CallableStatement cst = con.prepareCall("{CALL getSalary(?,?)}");
            cst.setInt(1, sc.nextInt());
            cst.registerOutParameter(2, Types.FLOAT);
            cst.execute();
            System.out.println("salary : " + cst.getFloat(2));

 

        } catch (Exception e) {
            System.out.println(e);
        }
    }

 

}
 