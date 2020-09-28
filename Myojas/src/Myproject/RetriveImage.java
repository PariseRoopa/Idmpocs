package Myproject;


import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 

public class RetriveImage extends Frame{

 

    public static void main(String[] args) throws Exception{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

 

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
            System.out.println(con + " is connected successfully");
            FileOutputStream fos = new FileOutputStream("abc.txt");
            Statement st =  con.createStatement();
            
            ResultSet res = st.executeQuery("select * from image_store");
            res.next();
            InputStream is = res.getBinaryStream(1);
            int k=0;
            while((k=is.read())!=-1) {//EOF
                fos.write(k);
            }
            is.close();
            res.close();
            st.close();
            fos.close();
        }catch (Exception e) {
            // TODO: handle exception
        }
        Frame f = new RetriveImage();
        f.setBackground(Color.blue);
        f.setSize(50,50);
        f.setVisible(true);
    }
        
        public void paint(Graphics g) {
            Toolkit t = Toolkit.getDefaultToolkit();
            Image i1 = t.getImage("abc.txt");
            g.drawImage(i1, 50, 50, this);
        }

 

    }