package Myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
	Connection createConnection() {
        Connection con = null;
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datamy","root","root");
             System.out.println(con + "Connected Successfylly");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    void createTable() {
        try {
            Connection con = createConnection();
            Statement st =  con.createStatement();
                        st.executeUpdate("Create table employee100(empno int primary key, ename varchar(20),num int(30))");
                        System.out.println("table is created successfully");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        
    }
    void updateEmpRecord(int empno,String name,double num) {
    	try {
            Connection con = createConnection();
            Statement st =  con.createStatement();
            int res = st.executeUpdate("update employee100 set ename=' "+name +" ' ,num="+num+"where empno = "+empno);
            if(res > 0) {
                        System.out.println("table is updated successfully");
        
    	
    }
            else {
            	System.out.println("try again");

            }
            }
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Update obj = new Update();
        obj.createTable();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter ur no,name,salary");
        obj.updateEmpRecord(sc.nextInt(),sc.next(),sc.nextDouble());

}
}