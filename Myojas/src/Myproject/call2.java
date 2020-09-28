package Myproject;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;





public class call2 {

  public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
               Connection con=DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/datamy","root","root");
               System.out.println(con + "connected successfully");
               while(true) {
               System.out.println("enter the sno,sname,marks ?");
               
               CallableStatement cst= con.prepareCall("{CALL addStu(?,?,?)}");
               cst.setInt(1,sc.nextInt());
               cst.setString(2,sc.next());
               cst.setInt(3,sc.nextInt());
               int res = cst.executeUpdate();
               if(res > 0)
                {
               System.out.println("Inserted successfully");
               }
               else {
               System.out.println("try again");
               }
               System.out.println("Do you want one more record to insert ?");
               String option = sc.next();
               if(option.equals("no")) {
               break;
               }
               }
        }
        
           catch(Exception e) {
               System.out.println(e);
           }
        
    }





    
}











